package via.sdj3.grpcspringbootx.domain;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Animal {

    @Id
    @Column(name = "REG_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regNumber;
    private String type;
    private String storeDate;
    private float weight;
    private String origin;

    @OneToMany(mappedBy = "animal")
    private List<AnimalPart> animalParts;

    public Animal(long regNumber, String type, String storeDate, float weight, String origin) {
        this.regNumber = regNumber;
        this.type = type;
        this.storeDate = storeDate;
        this.weight = weight;
        this.origin = origin;
    }

    public Animal() {

    }

    public long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(long regNumber) {
        this.regNumber = regNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStoreDate() {
        return storeDate;
    }

    public void setStoreDate(String storeDate) {
        this.storeDate = storeDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<AnimalPart> getAnimalParts() {
        return animalParts;
    }

    public void setAnimalParts(List<AnimalPart> animalParts) {
        this.animalParts = animalParts;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return regNumber == animal.regNumber && Float.compare(animal.weight, weight) == 0 && Objects.equals(type, animal.type) && Objects.equals(storeDate, animal.storeDate) && Objects.equals(origin, animal.origin) && Objects.equals(animalParts, animal.animalParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber, type, storeDate, weight, origin, animalParts);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "regNumber=" + regNumber +
                ", type='" + type + '\'' +
                ", storeDate='" + storeDate + '\'' +
                ", weight=" + weight +
                ", origin='" + origin + '\'' +
                ", animalParts=" + animalParts +
                '}';
    }
}
