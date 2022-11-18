package via.sdj3.grpcspringbootx.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @ElementCollection
    private List<Long> animalPartList;
    public Product() {
        animalPartList = new ArrayList<>();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void addAnimalParts(Long partId) {
        animalPartList.add(partId);
    }

    public List<Long> getAnimalPartList() {
        return animalPartList;
    }

}
