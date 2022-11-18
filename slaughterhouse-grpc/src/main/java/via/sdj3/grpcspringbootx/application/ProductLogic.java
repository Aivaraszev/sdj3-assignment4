package via.sdj3.grpcspringbootx.application;

import org.springframework.beans.factory.annotation.Autowired;
import via.sdj3.grpcspringbootx.domain.AnimalPart;
import via.sdj3.grpcspringbootx.domain.Product;
import via.sdj3.grpcspringbootx.domain.Tray;
import via.sdj3.grpcspringbootx.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductLogic {

    private final ProductRepository productRepository;

    public ProductLogic(ProductRepository productRepository) {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product());
        }
        this.productRepository = productRepository;
    }

    private final List<Product> products;

    public void putAnimalPartsToProducts(Tray t) {
        for (AnimalPart ap : t.getAnimalPartList()) {
            int id = new Random().nextInt(5);
            products.get(id).addAnimalParts(ap.getPartId());
            if (products.get(id).getAnimalPartList().size() > 5) {
                send(products.get(id));
                products.remove(id);
                products.add(new Product());
            }
        }
    }

    public void send(Product product) {
        System.out.println("FINISHED" + product);
        productRepository.save(product);
    }
}
