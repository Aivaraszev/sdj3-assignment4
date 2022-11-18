package via.sdj3.grpcspringbootx.application;

import via.sdj3.grpcspringbootx.domain.AnimalPart;
import via.sdj3.grpcspringbootx.domain.Product;
import via.sdj3.grpcspringbootx.domain.Tray;
import via.sdj3.grpcspringbootx.repository.AnimalPartRepository;
import via.sdj3.grpcspringbootx.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductLogic {

    private final ProductRepository productRepository;
    private final AnimalPartRepository animalPartRepository;

    public ProductLogic(ProductRepository productRepository, AnimalPartRepository animalPartRepository) {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Product p = new Product();
            products.add(p);
            productRepository.save(p);
        }
        this.productRepository = productRepository;
        this.animalPartRepository = animalPartRepository;
    }

    private final List<Product> products;

    public void putAnimalPartsToProducts(Tray t) {
        for (AnimalPart ap : t.getAnimalParts()) {
            int id = new Random().nextInt(5);
            products.get(id).addAnimalParts(ap);
            ap.setProduct(products.get(id));
            animalPartRepository.save(ap);
            if (products.get(id).getAnimalParts().size() > 5) {
                send(products.get(id));
                products.remove(id);
                Product p = new Product();
                products.add(p);
                productRepository.save(p);
            }
        }
    }

    public void send(Product product) {
        System.out.println("FINISHED" + product);
    }
}
