package via.sdj3;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import via.sdj3.application.AnimalPartLogic;
import via.sdj3.domain.Animal;
import via.sdj3.repository.AnimalPartRepository;
import via.sdj3.repository.TrayRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class AnimalPartAndTrayApplication {

    private final static String QUEUE_NAME = "Animals";
    @Autowired
    private TrayRepository trayRepository;
    @Autowired
    private AnimalPartRepository animalPartRepository;

    public static void main(String[] args) {
        SpringApplication.run(AnimalPartAndTrayApplication.class, args);
    }

    @Bean
    public void rabbitMqListener() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        AnimalPartLogic logic = new AnimalPartLogic(trayRepository, animalPartRepository);
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                Animal animal = new Gson().fromJson(message, Animal.class);
                System.out.println(" [x] Received '" + animal + "'");
                logic.processAnimal(animal);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        } catch (IOException |
                 TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

}