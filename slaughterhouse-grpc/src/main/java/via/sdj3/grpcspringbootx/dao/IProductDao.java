package via.sdj3.grpcspringbootx.dao;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    List<Integer> getIdsOfAnimals(int productId) throws SQLException;
}
