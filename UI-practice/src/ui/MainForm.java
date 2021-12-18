package ui;

import EntityManager.Client;
import Methods.SelectClientById;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MainForm extends BaseForm {
    private JButton showAllClientsButton;
    private JPanel mainPanel;
    private JButton EditClientButton;

    public MainForm() {
        super(600, 400);
        setContentPane(mainPanel);

        this.initButtons();

        setVisible(true);
    }

    private void initButtons() {
        showAllClientsButton.addActionListener(e -> {
            new ClientListForm();
        });

        EditClientButton.addActionListener(e -> {
            int id = -1;
            try {
                id = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите id.", "Ввод", JOptionPane.QUESTION_MESSAGE));
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Id не введен или введен неверно.", " Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Client client = null;

            try {
                client = SelectClientById.selectById(id);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка получения данных." + ex.getMessage());
                return;
            }

            if(client == null){
                JOptionPane.showMessageDialog(this, "Клиента с таким id не сущесвует.");
                return;
            }

            new ClientEditForm(this, client);
        });

    }

}
