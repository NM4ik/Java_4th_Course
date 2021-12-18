package Methods;

import DataManager.DataBaseConnection;
import EntityManager.Client;

import java.sql.*;

public class AddClient {

    public static void addClient(Client client) {

        try (Connection connection = DataBaseConnection.getConnection()) {

            String sql = """
                    INSERT INTO client.client
                    (FirstName, LastName, Patronymic, Birthday, RegistrationDate, Email, Phone, GenderCode)
                    VALUES (?,?,?,?,?,?,?,?)
                    """;

            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getPatronymic());
            ps.setTimestamp(4, new Timestamp(client.getBirthday().getTime()));
            ps.setTimestamp(5, new Timestamp(client.getRegistrationDate().getTime()));
            ps.setString(6, client.getEmail());
            ps.setString(7, client.getPhone());
            ps.setString(8, String.valueOf(client.getGenderCode()));

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if(keys.next()){
                client.setId(keys.getInt(1));
                return;
            }
            System.out.println("Клиент был добавлен");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Клиент не был добавлен, ошибка запроса" + throwables.getMessage());
        }

    }

}
