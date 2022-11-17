package via.sdj3.grpcspringbootx.dao;

import java.sql.SQLException;
import java.util.List;

public interface IAnimalDao {
    List<Integer> getIdsOfProducts(int animalId) throws SQLException;
}
