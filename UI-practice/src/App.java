import ui.MainForm;

import javax.swing.*;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
//        System.out.println(AllClientsSqlRequest.AllClients());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new MainForm();
    }

}
