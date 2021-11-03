package Entity;

import java.util.Objects;

public class Product {
    private int id;
    private String title;
    private int cost;
    private int countInStock;

    public Product(int id, String title, int cost, int countInStock) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.countInStock = countInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", countInStock=" + countInStock +
                '}' ;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(int countInStock) {
        this.countInStock = countInStock;
    }
}
