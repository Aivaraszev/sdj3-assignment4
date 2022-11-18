package via.sdj3.grpcspringbootx.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import via.sdj3.grpcspringbootx.domain.Product;

import java.util.List;

@Repository
@Service
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT DISTINCT p.productId FROM Product p " +
            "INNER JOIN AnimalPart ap ON p = ap.product" +
            " INNER JOIN Animal a ON ap.animal = a" +
            " WHERE a.regNumber = ?1")
    List<Long> findAllProductsByAnimalId(Long id);
}
