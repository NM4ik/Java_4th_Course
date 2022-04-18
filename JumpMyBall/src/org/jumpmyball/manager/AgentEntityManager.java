package org.jumpmyball.manager;

import org.jumpmyball.App;
import org.jumpmyball.entity.AgentEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgentEntityManager {

    public static List<AgentEntity> selectAllAgents() throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "SELECT * FROM demoexam2.agent";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            List<AgentEntity> agents = new ArrayList<>();
            while (resultSet.next()) {
                agents.add(new AgentEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getString("AgentType"),
                        resultSet.getString("Address"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Logo"),
                        resultSet.getInt("Priority")
                ));
            }
            return agents;
        }
    }

    public static AgentEntity selectAgentEntityById(int id) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "Select * from demoexam2.agent where id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            AgentEntity agentEntity;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                agentEntity = new AgentEntity(
                        resultSet.getInt("ID"),
                        resultSet.getString("Title"),
                        resultSet.getString("AgentType"),
                        resultSet.getString("Address"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Logo"),
                        resultSet.getInt("Priority")
                );
                return agentEntity;
            }
        }
        return null;
    }

    public static void updateAgentEntity(AgentEntity agentEntity) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "UPDATE demoexam2.agent SET ID=?, Title=?, AgentType=?, Address=?, Phone=?, Email=?, Logo=?, Priority=? WHERE ID=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, agentEntity.getId());
            ps.setString(2, agentEntity.getTitle());
            ps.setString(3, agentEntity.getAgentType());
            ps.setString(4, agentEntity.getAddress());
            ps.setString(5, agentEntity.getPhone());
            ps.setString(6, agentEntity.getEmail());
            ps.setString(7, agentEntity.getLogo());
            ps.setInt(8, agentEntity.getPriority());
            ps.setInt(9, agentEntity.getId());

            ps.executeUpdate();

            System.out.println("Updated");
        }
    }

    public static void createAgentEntity(AgentEntity agentEntity) throws SQLException {
        try (Connection connection = App.getConnection()) {
            String sql = "INSERT INTO demoexam2.agent (Title,AgentType,Address,Phone,Email,Logo,Priority) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, agentEntity.getTitle());
            ps.setString(2, agentEntity.getAgentType());
            ps.setString(3, agentEntity.getAddress());
            ps.setString(4, agentEntity.getPhone());
            ps.setString(5, agentEntity.getEmail());
            ps.setString(6, agentEntity.getLogo());
            ps.setInt(7, agentEntity.getPriority());

            ps.executeUpdate();

            System.out.println("Created");
        }
    }

    public static void deleteAgentEntity(int id) throws SQLException{
        try(Connection connection = App.getConnection()){
            String sql = "DELETE FROM demoexam2.agent WHERE ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            System.out.println("Deleted");
        }
    }


}
