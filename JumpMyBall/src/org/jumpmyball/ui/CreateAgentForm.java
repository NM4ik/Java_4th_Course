package org.jumpmyball.ui;

import org.jumpmyball.entity.AgentEntity;
import org.jumpmyball.manager.AgentEntityManager;
import org.jumpmyball.util.BaseForm;
import org.jumpmyball.util.DialogUtil;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreateAgentForm extends BaseForm {
    private JPanel mainPanel;
    private JTextField titleField;
    private JTextField typeField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField logoField;
    private JSpinner prioritySpinner;
    private JButton saveButton;
    private JButton backButton;

    public CreateAgentForm() {
        super(700, 700);
        setContentPane(mainPanel);
        setVisible(true);

        initButtons();
    }

    private void initButtons() {
        backButton.addActionListener(e -> {
            dispose();
            new AgentTableForm();
        });


        saveButton.addActionListener(e -> {
            String title = titleField.getText();
            if (title.isEmpty() || title.length() > 20) {
                DialogUtil.showError(this, "Title length > 20 or Empty");
                return;
            }

            String agentType = typeField.getText();
            if (agentType.isEmpty() || agentType.length() > 20) {
                DialogUtil.showError(this, "AgentType length > 20 or Empty");
                return;
            }

            String address = addressField.getText();
            if (address.isEmpty() || address.length() > 20) {
                DialogUtil.showError(this, "address length > 20 or Empty");
                return;
            }

            String phone = phoneField.getText();
            if (phone.isEmpty() || phone.length() > 20) {
                DialogUtil.showError(this, "phone length > 20 or Empty");
                return;
            }

            String email = emailField.getText();
            if (email.isEmpty() || email.length() > 20) {
                DialogUtil.showError(this, "email length > 20 or Empty");
                return;
            }

            String logo = logoField.getText();
            if (logo.isEmpty() || logo.length() > 20) {
                DialogUtil.showError(this, "logo length > 20 or Empty");
                return;
            }

            int priority = (int) prioritySpinner.getValue();

            AgentEntity agentEntity = new AgentEntity(
                    1,
                    title,
                    agentType,
                    address,
                    phone,
                    email,
                    logo,
                    priority
            );

            try {
                AgentEntityManager.createAgentEntity(agentEntity);
                DialogUtil.showError(this,"Success");
                dispose();
                new AgentTableForm();
            } catch (SQLException ex) {
                DialogUtil.showError(this,"Error");
                ex.printStackTrace();
            }

        });
    }
}
