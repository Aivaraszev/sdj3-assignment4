package via.sdj3.animalregistrationservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import via.sdj3.animalregistrationservice.domain.Animal;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Repository
@Resource
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    Iterable<Animal> findByOrigin(@Param("origin") String origin);
    Iterable<Animal> findByStoreDate(@Param("storeDate") String storeDate);

    Iterable<Animal> findByOriginContainingAndStoreDateContaining(@Param("origin") String origin, @Param("storeDate") String storeDate);

}
