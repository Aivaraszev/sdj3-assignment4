package via.sdj3.grpcspringbootx.domain;

import javax.persistence.*;

@Entity
public class AnimalPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;


    private float weight;
    private String type;
    @ManyToOne
    @JoinColumn(name = "ANIMAL_ID", referencedColumnName = "REG_NUMBER")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "TRAY_ID", referencedColumnName = "TRAY_ID")
    private Tray tray;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private Product product;


    public AnimalPart() {

    }

    public AnimalPart(float weight, String type, Animal animal) {
        this.weight = weight;
        this.type = type;
        this.animal = animal;
    }

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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Tray getTray() {
        return tray;
    }

    public void setTray(Tray tray) {
        this.tray = tray;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
