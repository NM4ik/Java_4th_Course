package SqlRequests;

import Entity.Product;
import Connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditProductSqlRequest {

    public static boolean editProduct(int id, Product product) throws SQLException {
        try(Connection connection = ProductConnection.getConnection()) {
            String sql = """
                    UPDATE DemoExam.nm_product SET title = ?, cost = ?, countInStock = ? WHERE id = ?
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getCost());
            preparedStatement.setInt(3, product.getCountInStock());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

            return true;
        }
    }
}
