//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookEntityManager {
//
//    public static List<Author> selectByFio(String fio) throws SQLException {
//        try (Connection c = App.getConnection()) {
//            List<Author> authors = new ArrayList<>();
//            String sql = "SELECT * FROM DemoExam.nm_human WHERE fio=?";
//            PreparedStatement ps = c.prepareStatement(sql);
//
//            ps.setString(1, fio);
//            ResultSet resultSet = ps.executeQuery();
//
//            while (resultSet.next()) {
//                authors.add(
//                        new Author(
//                                resultSet.getInt("id"),
//                                resultSet.getString("fio"),
//                                resultSet.getString("birth"),
//                                resultSet.getString("gender")
//                        )
//                );
//            }
//
//            return authors;
//        }
//    }
//
//    public static Author selectByID(int id) throws SQLException {
//        try (Connection c = App.getConnection()) {
//            String sql = "SELECT * FROM DemoExam.nm_human WHERE id=?";
//            PreparedStatement ps = c.prepareStatement(sql);
//
//            ps.setInt(1, id);
//            ResultSet resultSet = ps.executeQuery();
//
//            if (resultSet.next()) {
//                return new Author(
//                        resultSet.getInt("id"),
//                        resultSet.getString("fio"),
//                        resultSet.getString("birth"),
//                        resultSet.getString("gender")
//                );
//            }
//            return null;
//        }
//    }
//
//    public static List<Author> showTable() throws SQLException {
//        try (Connection c = App.getConnection()) {
//            String sql = "SELECT * FROM DemoExam.nm_human";
//            Statement s = c.createStatement();
//            ResultSet resultSet = s.executeQuery(sql);
//
//            List<Author> authors = new ArrayList<>();
//
//            while (resultSet.next()) {
//                authors.add(new Author(
//                        resultSet.getInt("id"),
//                        resultSet.getString("fio"),
//                        resultSet.getString("birth"),
//                        resultSet.getString("gender")
//                ));
//            }
//            return authors;
//        }
//    }
//
//    public static void addEntity(Author author) throws SQLException {
//        try (Connection c = App.getConnection()) {
//            String sql = "INSERT INTO DemoExam.nm_human(fio, birth, gender) VALUES (?,?,?)";
//
//            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
//
//            ps.setString(1, author.getFio());
//            ps.setString(2, author.getBirth());
//            ps.setString(3, author.getGender().substring(0, 1));
//
//            ps.executeUpdate();
//
//            ResultSet keys = ps.getGeneratedKeys();
//
//            if (keys.next()) {
//                //получение ключа и установка его в сущность
//                author.setId(keys.getInt(1));
//                return;
//            }
//
//            //если не было ни 1 ключа - выбрасываем ошибку
//            throw new SQLException("entity not added");
//
//        }
//    }
//
//}
