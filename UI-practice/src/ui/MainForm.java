package ui;

import javax.swing.*;

public class MainForm extends BaseForm{
    private JButton showAllClientsButton;
    private JPanel mainPanel;

    public MainForm(){
      super(600, 400);
      setContentPane(mainPanel);

      this.initButtons();
      
      setVisible(true);
    }

    private void initButtons() {
        showAllClientsButton.addActionListener(e -> {
            new ClientListForm();
        });
    }
}
