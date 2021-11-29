package ui;

import javax.swing.*;

public class ClientListForm extends BaseForm{
    private JPanel ListFormPanel;
    private JTextArea textArea1;
    private JButton goBackButton;

    public ClientListForm(){
        super(600, 400);
        setContentPane(ListFormPanel);


        setVisible(true);
    }
}
