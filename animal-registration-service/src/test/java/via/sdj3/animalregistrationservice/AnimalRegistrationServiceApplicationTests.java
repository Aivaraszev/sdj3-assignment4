package via.sdj3.animalregistrationservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import via.sdj3.animalregistrationservice.domain.Animal;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AnimalRegistrationServiceApplicationTests {

    @Test
    void animalStored() throws IOException {
        Animal an1 = new Animal(9000, "Deer","2002-03-03",2424.4F,"Donald");
        HttpUriRequest request = new HttpPost( "http://localhost:8080/animals");

        ObjectMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(an1);

        StringEntity entity = new StringEntity(xml, ContentType.APPLICATION_XML);
        request.setEntity(entity);
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        Animal value = xmlMapper.readValue(httpResponse.getEntity().getContent(), Animal.class);

        System.out.println(value);
        assertEquals(value, an1);
    }

    @Test
    void animalsReturned() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/animals");
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        ObjectMapper xmlMapper = new XmlMapper();
        Iterable<Animal> value = xmlMapper.readValue(httpResponse.getEntity().getContent(), Iterable.class);
        System.out.println(value);
        assertEquals(httpResponse.getCode(),200);
    }

    @Test
    void animalsReturnedByDate() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/animals?date=2000-03-03");
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        ObjectMapper xmlMapper = new XmlMapper();
        Iterable<Animal> value = xmlMapper.readValue(httpResponse.getEntity().getContent(), Iterable.class);
        System.out.println(value);
        assertEquals(httpResponse.getCode(),200);
    }

    @Test
    void animalsReturnedByOrigin() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/animals?origin=Donald");
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        ObjectMapper xmlMapper = new XmlMapper();
        Iterable<Animal> value = xmlMapper.readValue(httpResponse.getEntity().getContent(), Iterable.class);
        System.out.println(value);
        assertEquals(httpResponse.getCode(),200);
    }

    @Test
    void animalsReturnedByOriginAndDate() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/animals?origin=Los&date=2000-03-03");
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        ObjectMapper xmlMapper = new XmlMapper();
        Iterable<Animal> value = xmlMapper.readValue(httpResponse.getEntity().getContent(), Iterable.class);
        System.out.println(value);
        assertEquals(httpResponse.getCode(),200);
    }

    @Test
    void getAnimalById() throws IOException {
        int id = 1;
        HttpUriRequest request = new HttpGet( String.format("http://localhost:8080/animals/%d",id));
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        ObjectMapper xmlMapper = new XmlMapper();
        Animal value = xmlMapper.readValue(httpResponse.getEntity().getContent(), Animal.class);
        System.out.println(value);
        assertEquals(httpResponse.getCode(),200);
    }

}
