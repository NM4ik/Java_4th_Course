package org.jumpmyball.ui;

import org.jumpmyball.entity.AgentEntity;
import org.jumpmyball.manager.AgentEntityManager;
import org.jumpmyball.util.BaseForm;
import org.jumpmyball.util.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class EditAgentForm extends BaseForm {
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
    private JTextField idField;
    private JButton deleteButton;

    private AgentEntity agentEntity;

    public EditAgentForm(AgentEntity agentEntity) {
        super(700, 700);
        setContentPane(mainPanel);
        setVisible(true);
        this.agentEntity = agentEntity;

        initFields();

        initButtons();
    }

    private void initFields() {
        idField.setEditable(false);

        idField.setText(String.valueOf(agentEntity.getId()));
        titleField.setText(agentEntity.getTitle());
        typeField.setText(agentEntity.getAgentType());
        addressField.setText(agentEntity.getAddress());
        phoneField.setText(agentEntity.getPhone());
        emailField.setText(agentEntity.getEmail());
        logoField.setText(agentEntity.getLogo());
        prioritySpinner.setValue(agentEntity.getPriority());
    }

    private void initButtons() {
        backButton.addActionListener(e -> {
            dispose();
            new AgentTableForm();
        });

        deleteButton.addActionListener(e -> {
            if (JOptionPane.showConfirmDialog(this, "You sure to delete this agent?", "Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    AgentEntityManager.deleteAgentEntity(agentEntity.getId());
                    DialogUtil.showError(this, "Success");
                    dispose();
                    new AgentTableForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    DialogUtil.showError(this, "Delete error");
                    dispose();
                    new AgentTableForm();
                }
            }
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

            agentEntity.setTitle(title);
            agentEntity.setAgentType(agentType);
            agentEntity.setAddress(address);
            agentEntity.setEmail(email);
            agentEntity.setPhone(phone);
            agentEntity.setLogo(logo);
            agentEntity.setPriority(priority);


            try {
                AgentEntityManager.updateAgentEntity(agentEntity);
                DialogUtil.showError(this, "Success");
                dispose();
                new AgentTableForm();
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Error");
                ex.printStackTrace();
            }

        });
    }
}
