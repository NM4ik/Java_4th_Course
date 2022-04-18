package ru.jokerMask.manager;

import ru.jokerMask.App;
import ru.jokerMask.entity.ProductEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductEntityManager {

    public static List<ProductEntity> selectAllProducts() throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "SELECT * FROM demoexam.product";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<ProductEntity> entities = new ArrayList<>();
            while (resultSet.next()) {
                entities.add(
                        new ProductEntity(
                                resultSet.getInt("ID"),
                                resultSet.getString("Title"),
                                resultSet.getInt("ArticleNumber"),
                                resultSet.getString("Description"),
                                resultSet.getString("Image"),
                                resultSet.getInt("ProductionPersonCount"),
                                resultSet.getInt("ProductionWorkshopNumber"),
                                resultSet.getDouble("MinCostForAgent"),
                                resultSet.getString("ProductType")
                        )
                );
            }
            return entities;
        }
    }

    public static ProductEntity selectProductById(int id) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "SELECT * FROM demoexam.product WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ProductEntity productEntity = new ProductEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getInt("ArticleNumber"),
                        resultSet.getString("Description"),
                        resultSet.getString("Image"),
                        resultSet.getInt("ProductionPersonCount"),
                        resultSet.getInt("ProductionWorkshopNumber"),
                        resultSet.getDouble("MinCostForAgent"),
                        resultSet.getString("ProductType")
                );
                return productEntity;
            }
            return null;
        }
    }

    public static void insertProduct(ProductEntity productEntity) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "INSERT INTO demoexam.product(Title, ArticleNumber, Description, Image, ProductionPersonCount, ProductionWorkshopNumber, MinCostForAgent, ProductType) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, productEntity.getTitle());
            ps.setInt(2, productEntity.getArticleNumber());
            ps.setString(3, productEntity.getDescription());
            ps.setString(4, productEntity.getImage());
            ps.setInt(5, productEntity.getProductionPersonCount());
            ps.setInt(6, productEntity.getProductionWorkshopNumber());
            ps.setDouble(7, productEntity.getMinCostForAgent());
            ps.setString(8, productEntity.getProductionType());

            ps.executeUpdate();
            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                productEntity.setId(resultSet.getInt(1));
            }
        }
    }

    public static void updateProduct(ProductEntity productEntity) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "UPDATE demoexam.product SET Title=?, ArticleNumber=?, Description=?, Image=?, ProductionPersonCount=?, ProductionWorkshopNumber=?, MinCostForAgent=?, ProductType=? WHERE ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, productEntity.getTitle());
            ps.setInt(2, productEntity.getArticleNumber());
            ps.setString(3, productEntity.getDescription());
            ps.setString(4, productEntity.getImage());
            ps.setInt(5, productEntity.getProductionPersonCount());
            ps.setInt(6, productEntity.getProductionWorkshopNumber());
            ps.setDouble(7, productEntity.getMinCostForAgent());
            ps.setString(8, productEntity.getProductionType());
            ps.setInt(9, productEntity.getId());

            ps.executeUpdate();
        }
    }

    public static void deleteProduct(int id) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "DELETE FROM demoexam.product WHERE ID =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
    }


}
