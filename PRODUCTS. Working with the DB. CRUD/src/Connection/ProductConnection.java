package Connection;

import java.sql.*;

public class ProductConnection {
    //подключение к бд
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://116.202.236.174:3306", "DemoExam", "DemoExam");
    }
}
