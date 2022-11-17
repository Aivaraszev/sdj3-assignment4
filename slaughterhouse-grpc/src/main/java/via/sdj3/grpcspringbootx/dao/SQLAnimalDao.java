package via.sdj3.grpcspringbootx.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLAnimalDao implements IAnimalDao {
    private static final IAnimalDao instance = new SQLAnimalDao();

    private SQLAnimalDao() {

    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:file:/data/demo","sa","");
    }

    public static IAnimalDao getInstance() {
        return instance;
    }

    @Override
    public List<Integer> getIdsOfProducts(int animalId) throws SQLException {
        List<Integer> ids = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM Animal a INNER JOIN AnimalPart ap ON a.id = ap.animalId " +
                                "INNER JOIN Tray t ON ap.trayId = t.id " +
                                "INNER JOIN TrayAndProduct tap ON tap.trayId = t.id " +
                                "WHERE a.id = ?"
                );
        ) {
            statement.setInt(1, animalId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("productId");
                ids.add(id);
            }
        }

        return ids;
    }
}
