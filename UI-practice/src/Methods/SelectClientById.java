package Methods;

import DataManager.DataBaseConnection;
import EntityManager.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectClientById {
    public static Client selectById(int id) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String sql = """
                    SELECT * FROM client.client WHERE id = ?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                return new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Patronymic"),
                        resultSet.getTimestamp("Birthday"),
                        resultSet.getTimestamp("RegistrationDate"),
                        resultSet.getString("Email"),
                        resultSet.getString("Phone"),
                        resultSet.getString("GenderCode").charAt(0)
                );
            }
            return null;
        }
    }
}
