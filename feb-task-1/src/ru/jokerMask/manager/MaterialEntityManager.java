package ru.jokerMask.manager;

import ru.jokerMask.App;
import ru.jokerMask.entity.MaterialEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialEntityManager {
    public static void insertMaterial(MaterialEntity materialEntity) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String request = "INSERT INTO demoexam.material(Title, MaterialType, CountInPack, Unit, CountInStock, MinCount, Description, Cost, Image) VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, materialEntity.getTitle());
            ps.setString(2, materialEntity.getMaterialType());
            ps.setInt(3, materialEntity.getCountInPack());
            ps.setString(4, materialEntity.getUnit());
            ps.setInt(5, materialEntity.getCountInStock());
            ps.setInt(6, materialEntity.getMinCount());
            ps.setString(7, materialEntity.getDescription());
            ps.setDouble(8, materialEntity.getCost());
            ps.setString(9, materialEntity.getImage());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                materialEntity.setId(keys.getInt(1));
                return;
            }

            throw new SQLException("entity wasn't added");
        }
    }

    public static MaterialEntity selectMaterialByID(int id) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "SELECT * FROM demoexam.material WHERE ID=?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                MaterialEntity materialEntity = new MaterialEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("Title"),
                        resultSet.getString("MaterialType"),
                        resultSet.getInt("CountInPack"),
                        resultSet.getString("Unit"),
                        resultSet.getInt("CountInStock"),
                        resultSet.getInt("MinCount"),
                        resultSet.getString("Description"),
                        resultSet.getDouble("Cost"),
                        resultSet.getString("Image")
                );
                return materialEntity;
            }
            return null;
        }
    }

    public static List<MaterialEntity> selectAllMaterial() throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "SELECT * FROM demoexam.material";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            List<MaterialEntity> entities = new ArrayList<>();
            while (resultSet.next()) {
                entities.add(new MaterialEntity(
                                resultSet.getInt("id"),
                                resultSet.getString("Title"),
                                resultSet.getString("MaterialType"),
                                resultSet.getInt("CountInPack"),
                                resultSet.getString("Unit"),
                                resultSet.getInt("CountInStock"),
                                resultSet.getInt("MinCount"),
                                resultSet.getString("Description"),
                                resultSet.getDouble("Cost"),
                                resultSet.getString("Image")
                        )
                );
            }
            return entities;
        }
    }

    public static void deleteMaterialById(int id) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "DELETE FROM demoexam.material WHERE ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
        }
    }


    public static void updateMaterial(MaterialEntity materialEntity) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String request = "UPDATE demoexam.material SET Title=?, MaterialType=?, CountInPack=?, Unit=?, CountInStock=?, MinCount=?, Description=?, Cost=?, Image=? WHERE ID=?";

            PreparedStatement ps = connection.prepareStatement(request, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, materialEntity.getTitle());
            ps.setString(2, materialEntity.getMaterialType());
            ps.setInt(3, materialEntity.getCountInPack());
            ps.setString(4, materialEntity.getUnit());
            ps.setInt(5, materialEntity.getCountInStock());
            ps.setInt(6, materialEntity.getMinCount());
            ps.setString(7, materialEntity.getDescription());
            ps.setDouble(8, materialEntity.getCost());
            ps.setString(9, materialEntity.getImage());
            ps.setInt(10, materialEntity.getId());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
        }
    }
}
