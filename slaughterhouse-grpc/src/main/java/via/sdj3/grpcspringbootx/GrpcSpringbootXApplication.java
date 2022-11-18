package via.sdj3.grpcspringbootx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import via.sdj3.grpcspringbootx.application.ProductLogic;
import via.sdj3.grpcspringbootx.domain.Tray;
import via.sdj3.grpcspringbootx.repository.AnimalPartRepository;
import via.sdj3.grpcspringbootx.repository.ProductRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class GrpcSpringbootXApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcSpringbootXApplication.class, args);
    }

    private final static String QUEUE_NAME = "Trays";

    @Autowired
    private AnimalPartRepository animalPartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Bean
    public void rabbitMqService() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        ProductLogic logic = new ProductLogic(productRepository,animalPartRepository);
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                GsonBuilder gsonBuilder = new GsonBuilder();
                new GraphAdapterBuilder().addType(Tray.class).registerOn(gsonBuilder);
                Gson gson = gsonBuilder.create();
                Tray tray = gson.fromJson(message, Tray.class);
                System.out.println(" [x] Received '" + tray + "'");
                logic.putAnimalPartsToProducts(tray);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }


}
