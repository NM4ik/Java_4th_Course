package org.jumpmyball.ui;

import org.jumpmyball.entity.AgentEntity;
import org.jumpmyball.manager.AgentEntityManager;
import org.jumpmyball.util.BaseForm;
import org.jumpmyball.util.CustomTableModel;
import org.jumpmyball.util.DialogUtil;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class AgentTableForm extends BaseForm {
    private JTable table;
    private JButton createAgentButton;
    private JPanel mainPanel;
    private JButton sortByPriorityButton;
    private JComboBox agentTypeComboBox;
    private JComboBox agentPrioritycomboBox;
    private JLabel rowCountLabel;

    private CustomTableModel model;
    private boolean prioritySort = false;

    public AgentTableForm() {
        super(1000, 1000);
        setContentPane(mainPanel);
        setVisible(true);

        initTable();
        initButtons();

        initSort();
        initBoxes();
    }


    private void ApplyFilters() {
        try {
            List<AgentEntity> entities = AgentEntityManager.selectAllAgents();
            int max = entities.size();


            Object e = agentPrioritycomboBox.getSelectedItem();
            if (e.equals("<50")) {
                entities.removeIf(agentEntity -> agentEntity.getPriority() >= 50);
            }
            if (e.equals("50-150")) {
                entities.removeIf(agentEntity -> agentEntity.getPriority() < 50);
                entities.removeIf(agentEntity -> agentEntity.getPriority() >= 150);
            }
            if (e.equals("150-300")) {
                entities.removeIf(agentEntity -> agentEntity.getPriority() < 150);
                entities.removeIf(agentEntity -> agentEntity.getPriority() >= 300);
            }
            if (e.equals(">300")) {
                entities.removeIf(agentEntity -> agentEntity.getPriority() < 300);
            }

            Object x = agentTypeComboBox.getSelectedItem();

            if (!x.equals("Все")) {
                entities.removeIf(agentEntity -> !x.equals(agentEntity.getAgentType()));
            }

            model.setRows(entities);
            model.fireTableDataChanged();

            prioritySort = false;

            initValues(max, entities.size());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initBoxes() {
        agentTypeComboBox.addItem("Все");
        try {
            List<AgentEntity> entities = AgentEntityManager.selectAllAgents();
            HashSet<String> set = new HashSet<>();
            entities.forEach(agentEntity -> set.add(agentEntity.getAgentType()));

            set.forEach(s -> agentTypeComboBox.addItem(s));

        } catch (SQLException e) {
            agentTypeComboBox.addItem("Data error");
            e.printStackTrace();
        }
        agentPrioritycomboBox.addItem("Все");
        agentPrioritycomboBox.addItem("<50");
        agentPrioritycomboBox.addItem("50-150");
        agentPrioritycomboBox.addItem("150-300");
        agentPrioritycomboBox.addItem(">300");

        agentPrioritycomboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ApplyFilters();
            }
        });

        agentTypeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ApplyFilters();
                }
            }
        });


    }

    private void initSort() {
        sortByPriorityButton.addActionListener(e -> {

            Collections.sort(model.getRows(), new Comparator<AgentEntity>() {

                @Override
                public int compare(AgentEntity o1, AgentEntity o2) {
                    return prioritySort ? Integer.compare(o1.getPriority(), o2.getPriority()) : Integer.compare(o2.getPriority(), o1.getPriority());
                }
            });


            prioritySort = !prioritySort;
            model.fireTableDataChanged();

        });
    }

    private void initButtons() {
        createAgentButton.addActionListener(e -> {
            dispose();
            new CreateAgentForm();
        });
    }

    private void initTable() {

        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(50);

        List<AgentEntity> entities = new ArrayList<>();
        try {
            entities = AgentEntityManager.selectAllAgents();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model = new CustomTableModel<>(
                entities,
                AgentEntity.class,
                new String[]{"ID", "Title", "AgentType", "Address", "Phone", "Email", "PhotoPath", "Priority", "Image"}
        );

        table.setModel(model);


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = table.rowAtPoint(e.getPoint());
                    AgentEntity agentEntity = (AgentEntity) model.getRows().get(index);
                    dispose();
                    new EditAgentForm(agentEntity);
                }
            }
        });

        initValues(entities.size(), entities.size());

    }

    private void initValues(int max, int now) {
        rowCountLabel.setText("Quantity records: " + now + " / " + max);
    }
}
