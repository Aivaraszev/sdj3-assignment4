package via.sdj3.grpcspringbootx.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tray {
    @Id
    @Column(name = "TRAY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trayId;
    private String animalPartType;

    @OneToMany(mappedBy = "tray")
    private List<AnimalPart> animalParts = new ArrayList<>();

    public Long getTrayId() {
        return trayId;
    }

    public void setTrayId(Long trayId) {
        this.trayId = trayId;
    }

    public List<AnimalPart> getAnimalParts() {
        return animalParts;
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

    public double getTotalWeight() {
        double total = 0;
        for (AnimalPart ap : animalParts) {
            total += ap.getWeight();
        }
        return total;
    }

    public void addAnimalPart(AnimalPart ap) {
        animalParts.add(ap);
    }

    private float capacity;
}
