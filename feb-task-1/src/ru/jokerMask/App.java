package ru.jokerMask;

import ru.jokerMask.entity.MaterialEntity;
import ru.jokerMask.entity.ProductEntity;
import ru.jokerMask.manager.MaterialEntityManager;
import ru.jokerMask.manager.ProductEntityManager;
import ru.jokerMask.ui.MainForm;
import ru.jokerMask.ui.ProductCreateForm;
import ru.jokerMask.ui.ProductTableForm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        new ProductTableForm();
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123123qweqwe");
    }

}
