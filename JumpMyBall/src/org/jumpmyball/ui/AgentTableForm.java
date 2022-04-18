package org.jumpmyball.ui;

import org.jumpmyball.entity.AgentEntity;
import org.jumpmyball.manager.AgentEntityManager;
import org.jumpmyball.util.BaseForm;
import org.jumpmyball.util.CustomTableModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentTableForm extends BaseForm {
    private JTable table;
    private JButton button1;
    private JPanel mainPanel;

    private CustomTableModel model;

    public AgentTableForm() {
        super(1000, 1000);
        setContentPane(mainPanel);
        setVisible(true);

        initTable();
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
                new String[]{"ID", "Title", "AgentType", "Address", "Phone", "Email", "PhotoPath", "Priority"}
        );

        table.setModel(model);


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    int index = table.rowAtPoint(e.getPoint());
                    System.out.println(model.getRows().get(index));
                }
            }
        });

    }
}
