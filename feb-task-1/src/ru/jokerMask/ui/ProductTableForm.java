package ru.jokerMask.ui;

import ru.jokerMask.entity.ProductEntity;
import ru.jokerMask.manager.ProductEntityManager;
import ru.jokerMask.utl.BaseForm;
import ru.jokerMask.utl.CustomTableModel;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class ProductTableForm extends BaseForm {
    private JPanel mainPanel;
    private JTable table;
    private JButton createProductButton;
    private JComboBox<String> minCostFilter;
    private JComboBox<String> productTypeFilter;
    private JButton agentSortButton;
    private JLabel quantity;

    private CustomTableModel<ProductEntity> model;

    private boolean agentSort = true;

    public ProductTableForm() {
        super(1200, 800);
        setContentPane(mainPanel);
        setVisible(true);

        initTable();
        initButton();

        try {
            initQuantity(ProductEntityManager.selectAllProducts());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        initBoxes();
    }

    private void initBoxes() {
        try {
            List<ProductEntity> list = ProductEntityManager.selectAllProducts();
            HashSet<String> set = new HashSet<>();
            list.forEach(productEntity -> set.add(productEntity.getProductionType()));

            set.forEach(s -> productTypeFilter.addItem(s));
        } catch (SQLException e) {
            productTypeFilter.addItem("Не удалось загрузить данные");
            e.printStackTrace();
        }

        productTypeFilter.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                try {
                    List<ProductEntity> list = ProductEntityManager.selectAllProducts();

                    list.removeIf(productEntity -> !e.getItem().equals(productEntity.getProductionType()));

                    model.setRows(list);
                    model.fireTableDataChanged();
                    initQuantity(list);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });


        minCostFilter.addItem("Без фильтрации по цене для агента");
        minCostFilter.addItem("Цена для агента по возрастанию");
        minCostFilter.addItem("Цена для агента по убыванию");

        minCostFilter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        List<ProductEntity> list = ProductEntityManager.selectAllProducts();

                        if (minCostFilter.getSelectedIndex() == 0) {
                            model.setRows(list);
                            model.fireTableDataChanged();
                        }
                        if (minCostFilter.getSelectedIndex() == 1) {
                            list.sort(Comparator.comparingDouble(ProductEntity::getMinCostForAgent));
                            model.setRows(list);
                            model.fireTableDataChanged();
                        }
                        if (minCostFilter.getSelectedIndex() == 2) {
                            list.sort((o1, o2) -> Double.compare(o2.getMinCostForAgent(), o1.getMinCostForAgent()));
                            model.setRows(list);
                            model.fireTableDataChanged();
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    private void initQuantity(List list) throws SQLException {
        List<ProductEntity> initList = ProductEntityManager.selectAllProducts();

        quantity.setText("Количество записей: " + list.size() + " / " + initList.size());
    }

    private void initTable() {

        table.getTableHeader().setReorderingAllowed(false);

        try {
            model = new CustomTableModel<>(
                    ProductEntity.class,
                    ProductEntityManager.selectAllProducts(),
                    new String[]{"ID", "Название", "Артикул", "Описание", "Картинка", "Персонал", "Мастерская", "Мин. стоимость для агента", "Тип продукции"}
            );
            table.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.rowAtPoint(e.getPoint());
                    new ProductEditForm(model.getRows().get(row));
                    dispose();
                }
            }
        });

    }

    private void initButton() {
        createProductButton.addActionListener(e -> {
            dispose();
            new ProductCreateForm();
        });

        agentSortButton.addActionListener(e -> {
            if (agentSort) {
                model.getRows().sort(new Comparator<ProductEntity>() {
                    @Override
                    public int compare(ProductEntity o1, ProductEntity o2) {
                        return Double.compare(o2.getMinCostForAgent(), o1.getMinCostForAgent());
                    }
                });
            } else {
                model.getRows().sort(new Comparator<ProductEntity>() {
                    @Override
                    public int compare(ProductEntity o1, ProductEntity o2) {
                        return Double.compare(o1.getMinCostForAgent(), o2.getMinCostForAgent());
                    }
                });
            }

            agentSort = !agentSort;
            model.fireTableDataChanged();
        });

    }
}
