package via.sdj3.domain;

import java.util.ArrayList;
import java.util.List;

public class Tray {
    private Long trayId;
    private String animalPartType;
    private final List<AnimalPart> animalPartList;

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

    public Tray(String animalPartType, float capacity) {
        this.animalPartType = animalPartType;
        this.capacity = capacity;
        animalPartList = new ArrayList<>();
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
