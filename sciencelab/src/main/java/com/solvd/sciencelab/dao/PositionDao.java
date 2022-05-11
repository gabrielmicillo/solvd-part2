package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.Laboratory;
import com.solvd.sciencelab.PhoneNumber;
import com.solvd.sciencelab.Position;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDao implements Dao<Position>{
    @Override
    public Position select(long id) {
        String query = "SELECT id, position_name FROM Positions WHERE id = " + id;
        Position position;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int positionId = resultSet.getInt("id");
            String positionName = resultSet.getString("position_name");

            position = new Position(positionId, positionName);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return position;
    }

    @Override
    public List<Position> selectAll(){
        String query = "SELECT id, position_name FROM Positions";
        Position position;
        List<Position> positions = new ArrayList<>();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int positionId = resultSet.getInt("id");
                String positionName = resultSet.getString("position_name");

                position = new Position(positionId, positionName);
                positions.add(position);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return positions;
    }

    @Override
    public void insert(Position position) {
        String query = "INSERT INTO Positions (position_name) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, position.getPositionName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Position position, int id) {
        String query = "UPDATE Positions SET position_name = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, position.getPositionName());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Position position) {
        String query = "DELETE FROM Positions WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, position.getPositionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
