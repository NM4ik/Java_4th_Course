package SqlRequests;

import Connection.ProductConnection;
import Entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class allProductsSqlRequest {

    public static List<Product> AllProducts()  throws SQLException{
        //try-catch for auto connection.close
        try (Connection connection = ProductConnection.getConnection()) {
            List<Product> products = new ArrayList<>();

            //sql-request for all products
            String sql = """
                    SELECT * FROM DemoExam.nm_product
                    """;


            //create a request to db
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            //loop for get data
            while (resultSet.next()) {
                products.add(
                        new Product(
                                resultSet.getInt("id"),
                                resultSet.getString("title"),
                                resultSet.getInt("cost"),
                                resultSet.getInt("countInStock")
                        )
                );
            }



            return products;
        }
    }
}
