package via.sdj3.grpcspringbootx;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import via.sdj3.grpcspringbootx.application.ProductLogic;
import via.sdj3.grpcspringbootx.domain.Tray;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class GrpcSpringbootXApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrpcSpringbootXApplication.class, args);
    }

    private final static String QUEUE_NAME = "Trays";

    static {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        ProductLogic logic = new ProductLogic();
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                Tray tray = new Gson().fromJson(message, Tray.class);
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