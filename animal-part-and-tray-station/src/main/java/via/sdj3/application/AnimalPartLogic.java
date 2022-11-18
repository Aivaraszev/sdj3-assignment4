package via.sdj3.application;


import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import via.sdj3.domain.Animal;
import via.sdj3.domain.AnimalPart;
import via.sdj3.domain.Tray;
import via.sdj3.repository.AnimalPartRepository;
import via.sdj3.repository.TrayRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class AnimalPartLogic {

    private final List<Tray> trayList;
    private final TrayRepository trayRepository;
    private final AnimalPartRepository animalPartRepository;

    public AnimalPartLogic(TrayRepository trayRepository, AnimalPartRepository animalPartRepository) {
        trayList = new ArrayList<>();
        this.trayRepository = trayRepository;
        this.animalPartRepository = animalPartRepository;

    }

    private List<AnimalPart> cutAnimalIntoParts(Animal animal) {
        List<AnimalPart> list = new ArrayList<>();

        AnimalPart p1 = new AnimalPart(393, "Leg", animal);
        list.add(p1);
        AnimalPart p2 = new AnimalPart(467, "Loin", animal);
        list.add(p2);
        AnimalPart p3 = new AnimalPart(326, "Ribs", animal);
        list.add(p3);
        AnimalPart p4 = new AnimalPart(591, "Head", animal);
        list.add(p4);
        AnimalPart p5 = new AnimalPart(328, "Belly", animal);
        list.add(p5);
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
                        ap.setTray(t);
                        animalPartRepository.save(ap);
                        t.addAnimalPart(ap);
                    } else {
                        sendTray(t);
                        Tray newTray = new Tray(ap.getType(), 2000);
                        trayRepository.save(newTray);
                        ap.setTray(newTray);
                        animalPartRepository.save(ap);
                        newTray.addAnimalPart(ap);
                        trayList.add(newTray);
                    }
                    foundPart = true;
                    break;
                }
            }
            if (!foundPart) {
                Tray newTray = new Tray(ap.getType(), 2000);
                trayRepository.save(newTray);
                ap.setTray(newTray);
                animalPartRepository.save(ap);
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
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
