package ru.jokerMask.ui;

import ru.jokerMask.entity.ProductEntity;
import ru.jokerMask.manager.ProductEntityManager;
import ru.jokerMask.utl.BaseForm;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ProductTextListForm extends BaseForm {
    private JPanel mainPanel;
    private JTextArea textArea1;
    private JButton backButton;

    public ProductTextListForm() {
        super(500, 500);
        setContentPane(mainPanel);
        setVisible(true);
        initText();
        initButton();
    }

    private void initText(){
        textArea1.setEditable(false);

        try {
            List<ProductEntity> list = ProductEntityManager.selectAllProducts();
            String s = "";
            for (ProductEntity entity : list){
                s += entity;
                s += "\n";
            }
            textArea1.setText(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void initButton(){
        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });
    }
}
