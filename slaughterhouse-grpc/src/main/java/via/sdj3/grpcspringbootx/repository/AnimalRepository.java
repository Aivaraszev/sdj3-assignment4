package via.sdj3.grpcspringbootx.repository;

import org.springframework.data.repository.CrudRepository;
import via.sdj3.grpcspringbootx.domain.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long> {


}
