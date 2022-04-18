package ru.jokerMask.ui;

import ru.jokerMask.entity.ProductEntity;
import ru.jokerMask.manager.ProductEntityManager;
import ru.jokerMask.utl.BaseForm;
import ru.jokerMask.utl.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class ProductCreateForm extends BaseForm {
    private JPanel panel1;
    private JTextField articleNumber;
    private JTextField description;
    private JTextField image;
    private JTextField productionPersonCount;
    private JTextField productionWorkshopNumber;
    private JTextField minCostForAgent;
    private JTextField productType;
    private JButton saveProductButton;
    private JTextField titleField;
    private JButton backButton;

    public ProductCreateForm() {
        super(500, 500);
        setContentPane(panel1);
        setVisible(true);

        initButtons();
    }

    public void initButtons() {
        saveProductButton.addActionListener(e -> {
            String title = titleField.getText();
            if (title.isEmpty() || title.length() > 50) {
                DialogUtil.showError(this, "Имя не введено или слишком длинное..");
                return;
            }

            int articleNumber1;
            try {
                articleNumber1 = Integer.parseInt(articleNumber.getText());
            } catch (Exception ex) {
                DialogUtil.showError(this, "Введите артикул в виде числа..");
                return;
            }
            String description1 = description.getText();
            String image1 = image.getText();
            int productionPersonCount1 = Integer.parseInt(productionPersonCount.getText());
            int productionWorkshopNumber1 = Integer.parseInt(productionWorkshopNumber.getText());
            double minCostForAgent1 = Double.parseDouble(minCostForAgent.getText());
            String productType1 = productType.getText();


            ProductEntity productEntity = new ProductEntity(
                    title,
                    articleNumber1,
                    description1,
                    image1,
                    productionPersonCount1,
                    productionWorkshopNumber1,
                    minCostForAgent1,
                    productType1
            );

            System.out.println(productEntity);
            try {
                ProductEntityManager.insertProduct(productEntity);
                dispose();
                new ProductTableForm();
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Продукт не был добавлен...");
                ex.printStackTrace();
            }

        });

        backButton.addActionListener(e -> {
            dispose();
            new ProductTableForm();
        });
    }
}
