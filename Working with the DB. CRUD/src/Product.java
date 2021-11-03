import java.util.Objects;

public class Product {
    private int id;
    private String title;
    private double cost;
    private int countInStock;

    public Product(int id, String title, double cost, int countInStock) {
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.cost, cost) == 0 && countInStock == product.countInStock && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cost, countInStock);
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(int countInStock) {
        this.countInStock = countInStock;
    }
}
