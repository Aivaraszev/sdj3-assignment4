package via.sdj3.grpcspringbootx.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import via.sdj3.grpcspringbootx.domain.Product;

@Repository
@Service
public interface ProductRepository extends CrudRepository<Product, Long> {
}
