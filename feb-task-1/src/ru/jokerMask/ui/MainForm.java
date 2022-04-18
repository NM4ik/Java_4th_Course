package ru.jokerMask.ui;

import ru.jokerMask.manager.ProductEntityManager;
import ru.jokerMask.utl.BaseForm;
import ru.jokerMask.utl.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MainForm extends BaseForm {
    private JPanel mainPanel;
    private JButton listButton;
    private JButton createProductButton;
    private JButton editProductButton;


    public MainForm() {
        super(500, 500);
        setContentPane(mainPanel);
        setVisible(true);

        initButtons();
    }

    private void initButtons() {
        listButton.addActionListener(e -> {
            dispose();
            new ProductTextListForm();
        });
        createProductButton.addActionListener(e -> {
            dispose();
            new ProductCreateForm();
        });
        editProductButton.addActionListener(e -> {
            String s = JOptionPane.showInputDialog(this, "Введите id", "Ввод", JOptionPane.QUESTION_MESSAGE);

            if(s==null){
                return;
            }
            if(s.isEmpty()){
                DialogUtil.showError(this, "Id не введен");
                return;
            }

            try {
                new ProductEditForm(ProductEntityManager.selectProductById(Integer.parseInt(s)));
                dispose();
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Id в виде числа надо ввести");
                ex.printStackTrace();
                return;
            }
        });
    }
}
