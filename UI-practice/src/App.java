import DataManager.*;
import Methods.AllClientsSqlRequest;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        System.out.println(AllClientsSqlRequest.AllClients());
    }

}
