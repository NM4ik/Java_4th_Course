package ru.jokerMask.entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class ProductEntity {
    private int id;
    private String title;
    private int articleNumber;
    private String description;
    private String image;
    private int productionPersonCount;
    private int productionWorkshopNumber;
    private double minCostForAgent;
    private String ProductionType;
//    private ImageIcon photo;

    public ProductEntity(int id, String title, int articleNumber, String description, String image, int productionPersonCount, int productionWorkshopNumber, double minCostForAgent, String productionType) {
        this.id = id;
        this.title = title;
        this.articleNumber = articleNumber;
        this.description = description;
        this.image = image;
        this.productionPersonCount = productionPersonCount;
        this.productionWorkshopNumber = productionWorkshopNumber;
        this.minCostForAgent = minCostForAgent;
        this.ProductionType = productionType;

//        try {
//            System.out.println(image);
//            this.photo = new ImageIcon(ImageIO.read(ProductEntity.class.getClassLoader().getResource(image)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public ProductEntity(String title, int articleNumber, String description, String image, int productionPersonCount, int productionWorkshopNumber, double minCostForAgent, String productionType) {
        this.id = -1;
        this.title = title;
        this.articleNumber = articleNumber;
        this.description = description;
        this.image = image;
        this.productionPersonCount = productionPersonCount;
        this.productionWorkshopNumber = productionWorkshopNumber;
        this.minCostForAgent = minCostForAgent;
        ProductionType = productionType;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", articleNumber=" + articleNumber +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", productionPersonCount=" + productionPersonCount +
                ", productionWorkshopNumber=" + productionWorkshopNumber +
                ", minCostForAgent=" + minCostForAgent +
                ", ProductionType='" + ProductionType + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id && articleNumber == that.articleNumber && productionPersonCount == that.productionPersonCount && productionWorkshopNumber == that.productionWorkshopNumber && Double.compare(that.minCostForAgent, minCostForAgent) == 0 && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(image, that.image) && Objects.equals(ProductionType, that.ProductionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, articleNumber, description, image, productionPersonCount, productionWorkshopNumber, minCostForAgent, ProductionType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(int articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getProductionPersonCount() {
        return productionPersonCount;
    }

    public void setProductionPersonCount(int productionPersonCount) {
        this.productionPersonCount = productionPersonCount;
    }

    public int getProductionWorkshopNumber() {
        return productionWorkshopNumber;
    }

    public void setProductionWorkshopNumber(int productionWorkshopNumber) {
        this.productionWorkshopNumber = productionWorkshopNumber;
    }

    public double getMinCostForAgent() {
        return minCostForAgent;
    }

    public void setMinCostForAgent(double minCostForAgent) {
        this.minCostForAgent = minCostForAgent;
    }

    public String getProductionType() {
        return ProductionType;
    }

    public void setProductionType(String productionType) {
        ProductionType = productionType;
    }
}
