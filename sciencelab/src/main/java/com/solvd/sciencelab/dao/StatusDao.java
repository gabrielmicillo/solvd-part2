package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.Position;
import com.solvd.sciencelab.Status;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao implements Dao<Status>{
    @Override
    public Status select(long id) {
        String query = "SELECT id, exp_status FROM Status WHERE id = " + id;
        Status status;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int statusId = resultSet.getInt("id");
            String expStatus = resultSet.getString("exp_status");

            status = new Status(statusId, expStatus);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    @Override
    public List<Status> selectAll() {
        String query = "SELECT id, exp_status FROM Status";
        Status status;
        List<Status> statuses = new ArrayList<>();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int statusId = resultSet.getInt("id");
                String expStatus = resultSet.getString("exp_status");

                status = new Status(statusId, expStatus);
                statuses.add(status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statuses;
    }

    @Override
    public void insert(Status status) {
        String query = "INSERT INTO Status (exp_status) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, status.getExpStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Status status, int id) {
        String query = "UPDATE Status SET exp_status = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, status.getExpStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Status status) {
        String query = "DELETE FROM Status WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, status.getStatusId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
