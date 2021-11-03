import java.sql.Connection;
import java.sql.SQLException;

public class ProductSqlRequest {

    public static void AllProducts() {

        try(Connection connection = ProductConnection.getConnection()){

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
