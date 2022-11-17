package via.sdj3.application;


import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import via.sdj3.dao.TrayDao;
import via.sdj3.domain.Animal;
import via.sdj3.domain.AnimalPart;
import via.sdj3.domain.Tray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class AnimalPartLogic {

    private final List<Tray> trayList;
    private final TrayDao trayDao;
    public AnimalPartLogic() {
        trayList = new ArrayList<>();
        trayDao = new TrayDao();
    }

    private List<AnimalPart> cutAnimalIntoParts(Animal animal) {
        List<AnimalPart> list = new ArrayList<>();
        list.add(new AnimalPart(393, "Leg", animal.getRegNumber()));
        list.add(new AnimalPart(467, "Loin", animal.getRegNumber()));
        list.add(new AnimalPart(326, "Ribs", animal.getRegNumber()));
        list.add(new AnimalPart(591, "Head", animal.getRegNumber()));
        list.add(new AnimalPart(328, "Belly", animal.getRegNumber()));
        return list;
    }

    public void processAnimal(Animal animal) {
        List<AnimalPart> animalParts = cutAnimalIntoParts(animal);
        putAnimalPartsIntoTrays(animalParts);
    }


    private void putAnimalPartsIntoTrays(List<AnimalPart> partList) {
        for (AnimalPart ap : partList) {
            boolean foundPart = false;
            for (Tray t : trayList) {
                if (t.getAnimalPartType().equals(ap.getType())) {
                    if (t.getCapacity() >= t.getTotalWeight() + ap.getWeight()) {
                        t.addAnimalPart(ap);
                    } else {
                        sendTray(t);
                        Tray newTray = new Tray(ap.getType(), 2000);
                        newTray.addAnimalPart(ap);
                        trayList.add(newTray);
                    }
                    foundPart = true;
                    break;
                }
            }
            if (!foundPart) {
                Tray newTray = new Tray(ap.getType(), 2000);
                newTray.addAnimalPart(ap);
                trayList.add(newTray);
            }
        }

    }

    private void sendTray(Tray tray) {
        String QUEUE_NAME = "Trays";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = new Gson().toJson(tray);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            trayDao.saveTray(tray);
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}