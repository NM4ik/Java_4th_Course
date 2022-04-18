package org.jumpmyball;

import org.jumpmyball.entity.AgentEntity;
import org.jumpmyball.manager.AgentEntityManager;
import org.jumpmyball.ui.AgentTableForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        new AgentTableForm();

    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123123qweqwe");
    }
}
