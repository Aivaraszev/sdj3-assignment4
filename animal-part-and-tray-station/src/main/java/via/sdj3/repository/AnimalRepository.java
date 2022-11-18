package via.sdj3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import via.sdj3.domain.Animal;

@Repository
@Service
public interface AnimalRepository extends CrudRepository<Animal, Long> {
}
