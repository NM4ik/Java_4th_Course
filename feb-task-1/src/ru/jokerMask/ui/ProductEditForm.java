package ru.jokerMask.ui;

import ru.jokerMask.entity.ProductEntity;
import ru.jokerMask.manager.ProductEntityManager;
import ru.jokerMask.utl.BaseForm;
import ru.jokerMask.utl.DialogUtil;

import javax.swing.*;
import java.sql.SQLException;

public class ProductEditForm extends BaseForm {
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
    private JTextField idField;
    private JButton deleteButton;

    private ProductEntity productEntity;

    public ProductEditForm(ProductEntity productEntity) {
        super(500, 500);
        this.productEntity = productEntity;
        setContentPane(panel1);
        setVisible(true);

        initFields();
        initButtons();
    }

    public void initFields() {
        idField.setEditable(false);
        idField.setText(String.valueOf(productEntity.getId()));
        titleField.setText(productEntity.getTitle());
        articleNumber.setText(String.valueOf(productEntity.getArticleNumber()));
        description.setText(productEntity.getDescription());
        image.setText(productEntity.getImage());
        productionPersonCount.setText(String.valueOf(productEntity.getProductionPersonCount()));
        productionWorkshopNumber.setText(String.valueOf(productEntity.getProductionWorkshopNumber()));
        minCostForAgent.setText(String.valueOf(productEntity.getMinCostForAgent()));
        productType.setText(productEntity.getProductionType());
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


            productEntity.setTitle(title);
            productEntity.setArticleNumber(articleNumber1);
            productEntity.setDescription(description1);
            productEntity.setImage(image1);
            productEntity.setProductionPersonCount(productionPersonCount1);
            productEntity.setProductionWorkshopNumber(productionWorkshopNumber1);
            productEntity.setMinCostForAgent(minCostForAgent1);
            productEntity.setProductionType(productType1);

            System.out.println(productEntity);
            try {
                ProductEntityManager.updateProduct(productEntity);
                dispose();
                new MainForm();
            } catch (SQLException ex) {
                DialogUtil.showError(this, "Продукт не был обновлен...");
                ex.printStackTrace();
            }

        });

        backButton.addActionListener(e -> {
            dispose();
            new MainForm();
        });

        deleteButton.addActionListener(e -> {
            try {
                ProductEntityManager.deleteProduct(productEntity.getId());
                dispose();
                new MainForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}
