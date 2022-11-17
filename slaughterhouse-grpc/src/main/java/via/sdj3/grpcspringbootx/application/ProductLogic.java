package via.sdj3.grpcspringbootx.application;

import via.sdj3.grpcspringbootx.domain.AnimalPart;
import via.sdj3.grpcspringbootx.domain.Product;
import via.sdj3.grpcspringbootx.domain.Tray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductLogic {

    public ProductLogic() {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product());
        }

    }

    private final List<Product> products;

    public void putAnimalPartsToProducts(Tray t) {
        for (AnimalPart ap : t.getAnimalPartList()) {
            int id = new Random().nextInt(5);
            products.get(id).addAnimalParts(ap);
            if (products.get(id).getAnimalPartList().size() > 5) {
                send(products.get(id));
                products.remove(id);
                products.add(new Product());
            }
        }
    }

    public void send(Product product) {
        System.out.println("FINISHED" + product);
    }
}
