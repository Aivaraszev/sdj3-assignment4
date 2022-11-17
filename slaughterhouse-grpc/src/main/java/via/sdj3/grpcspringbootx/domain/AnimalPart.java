package via.sdj3.grpcspringbootx.domain;

public class AnimalPart {
    private Long partId;
    private float weight;
    private String type;
    private Long animalId;

    public AnimalPart(float weight, String type, Long animalId) {
        this.weight = weight;
        this.type = type;
        this.animalId = animalId;
    }

    private Long trayId = null;
    private Long productId = null;

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public Long getTrayId() {
        return trayId;
    }

    public void setTrayId(Long trayId) {
        this.trayId = trayId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
