package ru.jokerMask.entity;

import java.util.Objects;

public class MaterialEntity {
    private int id;
    private String title;
    private String materialType;
    private int countInPack;
    private String unit;
    private int countInStock;
    private int minCount;
    private String description;
    private double cost;
    private String image;

    public MaterialEntity(int id, String title, String materialType, int countInPack, String unit, int countInStock, int minCount, String description, double cost, String image) {
        this.id = id;
        this.title = title;
        this.materialType = materialType;
        this.countInPack = countInPack;
        this.unit = unit;
        this.countInStock = countInStock;
        this.minCount = minCount;
        this.description = description;
        this.cost = cost;
        this.image = image;
    }

    @Override
    public String toString() {
        return "MaterialEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", materialType='" + materialType + '\'' +
                ", countInPack=" + countInPack +
                ", unit='" + unit + '\'' +
                ", countInStock=" + countInStock +
                ", minCount=" + minCount +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", image='" + image + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialEntity that = (MaterialEntity) o;
        return id == that.id && countInPack == that.countInPack && countInStock == that.countInStock && minCount == that.minCount && Double.compare(that.cost, cost) == 0 && Objects.equals(title, that.title) && Objects.equals(materialType, that.materialType) && Objects.equals(unit, that.unit) && Objects.equals(description, that.description) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, materialType, countInPack, unit, countInStock, minCount, description, cost, image);
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

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public int getCountInPack() {
        return countInPack;
    }

    public void setCountInPack(int countInPack) {
        this.countInPack = countInPack;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(int countInStock) {
        this.countInStock = countInStock;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
