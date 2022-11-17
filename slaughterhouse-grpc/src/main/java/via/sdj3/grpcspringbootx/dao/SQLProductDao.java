package via.sdj3.grpcspringbootx.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLProductDao implements IProductDao {
    private static final IProductDao instance = new SQLProductDao();

    private SQLProductDao() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://mouse.db.elephantsql.com/gpxtmpun?currentSchema=slaughterhouse", "gpxtmpun", "L75JCEcG4n8b1lWlmLZf-8Lf0jnUrGt6");
    }

    public static IProductDao getInstance() {
        return instance;
    }

    @Override
    public List<Integer> getIdsOfAnimals(int productId) throws SQLException {
        List<Integer> ids = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM Animal a INNER JOIN AnimalPart ap ON a.id = ap.animalId " +
                            "INNER JOIN Tray t ON ap.trayId = t.id " +
                            "INNER JOIN TrayAndProduct tap ON tap.trayId = t.id " +
                            "WHERE tap.productId = ?"
                )
        ) {
            statement.setInt(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("animalId");
                ids.add(id);
            }
        }

        return ids;
    }
}
