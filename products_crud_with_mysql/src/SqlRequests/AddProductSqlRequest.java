package SqlRequests;

import Entity.Product;
import Connection.ProductConnection;

import java.sql.*;

public class AddProductSqlRequest {

    public static boolean addProduct(Product product) throws SQLException{
        try(Connection connection = ProductConnection.getConnection()) {
            //request
            String sql = """ 
                    INSERT INTO DemoExam.nm_product(title, cost, countInStock)
                    VALUES (?,?,?)
                    """;

            //do request. Generated keys for return all keys generated from db
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getCost());
            preparedStatement.setInt(3, product.getCountInStock());

            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();

            //check any keys on exists
            if(keys.next()){
                product.setId(keys.getInt(1));
                return true;
            }

            throw new SQLException("products not added");
        }
    }
}
