package ui;

import EntityManager.Client;
import Methods.AllClients;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ClientListForm extends BaseForm{
    private JPanel ListFormPanel;
    private JTextArea ClientListArea;
    private JButton goBackButton;

    public ClientListForm(){
        super(600, 400);
        setContentPane(ListFormPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.initButtons();
        this.intiList();

        setVisible(true);
    }

    private void intiList() {
        try{
            List<Client> ClientList = AllClients.allClients();
            String record = "";

            for(Client client : ClientList){
                record += client;
                record += "\n";
            }

            ClientListArea.setText(record);

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Ошибка подключения к бд... : " + e.getMessage());
        }
    }

    private void initButtons(){
        goBackButton.addActionListener(e -> {
            dispose();
//            ListFormPanel.setEnabled(true);
//            ListFormPanel.setVisible(false);
//            ListFormPanel.setVisible(true); //зачем эти строчки, если диспоз работает??
        });
    }
}
