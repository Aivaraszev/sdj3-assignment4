package via.sdj3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import via.sdj3.domain.AnimalPart;

@Repository
@Service
public interface AnimalPartRepository extends CrudRepository<AnimalPart, Long> {
}