package via.sdj3.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tray {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trayId;
    private String animalPartType;

    @ElementCollection
    private final List<AnimalPart> animalPartList = new ArrayList<>();

    public List<AnimalPart> getAnimalPartList() {
        return animalPartList;
    }

    public Long getTrayId() {
        return trayId;
    }

    public void setTrayId(Long trayId) {
        this.trayId = trayId;
    }

    public String getAnimalPartType() {
        return animalPartType;
    }

    public void setAnimalPartType(String animalPartType) {
        this.animalPartType = animalPartType;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public Tray() {

    }

    public Tray(String animalPartType, float capacity) {
        this.animalPartType = animalPartType;
        this.capacity = capacity;
    }
    public double getTotalWeight(){
        double total = 0;
        for (AnimalPart ap : animalPartList) {
            total+=ap.getWeight();
        }
        return total;
    }

    public void addAnimalPart(AnimalPart ap) {
        animalPartList.add(ap);
    }
    private float capacity;
}
