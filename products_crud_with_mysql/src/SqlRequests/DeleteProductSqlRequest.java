package SqlRequests;

import Connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProductSqlRequest {

    public static boolean deleteProduct(int id) throws SQLException {
        try(Connection connection = ProductConnection.getConnection()) {
            //request
            String sql = """ 
                    DELETE FROM DemoExam.nm_product
                    WHERE id = (?)
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            return true;
        }
    }

}
