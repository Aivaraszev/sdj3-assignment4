package via.sdj3.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Animal {

    private long regNumber;
    private String type;
    private String storeDate;
    private float weight;
    private String origin;

    public Animal(long regNumber, String type, String storeDate, float weight, String origin) {
        this.regNumber = regNumber;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "regNumber=" + regNumber +
                ", Type='" + type + '\'' +
                ", storeDate='" + storeDate + '\'' +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return regNumber == animal.regNumber && Float.compare(animal.weight, weight) == 0 && Objects.equals(type, animal.type) && Objects.equals(storeDate, animal.storeDate) && Objects.equals(origin, animal.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, type, storeDate, weight, origin);
    }
}
