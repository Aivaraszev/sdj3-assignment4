package via.sdj3.grpcspringbootx.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import via.sdj3.grpcspringbootx.domain.Animal;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query("SELECT DISTINCT a.regNumber FROM Animal a " +
            "INNER JOIN AnimalPart ap ON a = ap.animal" +
            " INNER JOIN Product p ON ap.product = p" +
            " WHERE p.productId = ?1")
    List<Long> findAllAnimalsByProductId(Long id);

}
