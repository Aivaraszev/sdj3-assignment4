package via.sdj3.animalregistrationservice.controller;


import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import via.sdj3.animalregistrationservice.domain.Animal;
import via.sdj3.animalregistrationservice.repository.AnimalRepository;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

@RestController
public class AnimalController {

    @Resource
    private final AnimalRepository repository;

    private final static String QUEUE_NAME = "Animals";

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
        this.repository.save(new Animal(1,"Chicken",  "1980-03-03", 35.6F, "Donald farm"));
        this.repository.save(new Animal(2, "Pig", "2020-03-03", 35.6F, "Pigs and cows"));
        this.repository.save(new Animal(3,"Cow", "2000-03-03", 35.6F, "Los Pollos Hermanos"));
    }

    @PostMapping(path = "/animals",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal create(@RequestBody Animal animal) {
        Animal saved = repository.save(animal);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = new Gson().toJson(saved);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        return repository.save(saved);
    }

    @GetMapping(path = "/animals",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Iterable<Animal> findAll(@RequestParam() Map<String, String> query) {

        if (!query.containsKey("origin"))
            query.put("origin", "");

        if (!query.containsKey("date"))
            query.put("date", "");

        return repository.findByOriginContainingAndStoreDateContaining(query.get("origin"), query.get("date"));
    }


    @GetMapping(path = "/animals/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<Animal> findById(@PathVariable long id) {
        return repository.findById(id);
    }

}
