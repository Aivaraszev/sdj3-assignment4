package via.sdj3.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @OneToMany(mappedBy = "product")
    private List<AnimalPart> animalParts;

    public Product() {
        animalParts = new ArrayList<>();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void addAnimalParts(AnimalPart ap) {
        animalParts.add(ap);
    }

    public List<AnimalPart> getAnimalParts() {
        return animalParts;
    }

}
