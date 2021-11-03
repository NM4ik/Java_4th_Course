import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args){
        try {
            ProductSqlRequest.AllProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
