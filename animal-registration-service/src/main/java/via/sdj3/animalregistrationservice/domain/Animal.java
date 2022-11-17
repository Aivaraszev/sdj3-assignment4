package via.sdj3.animalregistrationservice.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regNumber;
    private String storeDate;
    private float weight;
    private String origin;

    public Animal(long regNumber, String storeDate, float weight, String origin) {
        this.regNumber = regNumber;
        this.storeDate = storeDate;
        this.weight = weight;
        this.origin = origin;
    }

    public Animal() {

    }

    public void setRegNumber(long regNumber) {
        this.regNumber = regNumber;
    }

    public void setStoreDate(String storeDate) {
        this.storeDate = storeDate;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public long getRegNumber() {
        return regNumber;
    }

    public String getStoreDate() {
        return storeDate;
    }

    public float getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "regNumber=" + regNumber +
                ", storeDate=" + storeDate +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return regNumber == animal.regNumber && Float.compare(animal.weight, weight) == 0 && Objects.equals(storeDate, animal.storeDate) && Objects.equals(origin, animal.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, storeDate, weight, origin);
    }
}
