package via.sdj3.grpcspringbootx.domain;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Long productId;

    public Product() {
        animalPartList = new ArrayList<>();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void addAnimalParts(AnimalPart ap) {
        animalPartList.add(ap);
    }

    public List<AnimalPart> getAnimalPartList() {
        return animalPartList;
    }

    private final List<AnimalPart> animalPartList;
}
