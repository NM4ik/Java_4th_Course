package Methods;

import DataManager.DataBaseConnection;
import EntityManager.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AllClientsSqlRequest {

    public static List<Client> AllClients() throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection()) {
            List<Client> clients = new ArrayList<>();

            //sql-request for all clients
            String sql = """
                    SELECT * FROM client.client
                    """;


            //create a request to db
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            //loop for get data
            while (resultSet.next()) {
                clients.add(
                        new Client(
                                resultSet.getInt("id"),
                                resultSet.getString("FirstName"),
                                resultSet.getString("LastName"),
                                resultSet.getString("Patronymic"),
                                resultSet.getTimestamp("Birthday"),
                                resultSet.getTimestamp("RegistrationDate"),
                                resultSet.getString("Email"),
                                resultSet.getString("Phone"),
                                resultSet.getString("GenderCode").charAt(0)
                                )
                );
            }

            return clients;
        }
    }

}
