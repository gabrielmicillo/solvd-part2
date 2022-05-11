package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.City;
import com.solvd.sciencelab.ExperimentType;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExperimentTypeDao implements Dao<ExperimentType> {
    @Override
    public ExperimentType select(long id) {
        String query = "SELECT id, type_name, cost_per_hour FROM Experiment_Types WHERE id = " + id;
        ExperimentType experimentType;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int experimentTypeId = resultSet.getInt("id");
            String typeName = resultSet.getString("type_name");
            int costPerHour = resultSet.getInt("cost_per_hour");

            experimentType = new ExperimentType(experimentTypeId, typeName, costPerHour);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return experimentType;
    }

    @Override
    public List<ExperimentType> selectAll() {
        String query = "SELECT id, type_name, cost_per_hour FROM Experiment_Types";
        ExperimentType experimentType;
        List<ExperimentType> experimentTypes = new ArrayList<>();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int experimentTypeId = resultSet.getInt("id");
                String typeName = resultSet.getString("type_name");
                int costPerHour = resultSet.getInt("cost_per_hour");

                experimentType = new ExperimentType(experimentTypeId, typeName, costPerHour);
                experimentTypes.add(experimentType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return experimentTypes;
    }

    @Override
    public void insert(ExperimentType experimentType) {
        String query = "INSERT INTO experiment_types (type_name, cost_per_hour) VALUES (?, ?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, experimentType.getTypeName());
            statement.setInt(2, experimentType.getCostPerHour());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ExperimentType experimentType, int id) {
        String query = "UPDATE experiment_types SET type_name = ?, cost_per_hour = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, experimentType.getTypeName());
            statement.setInt(2, experimentType.getCostPerHour());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(ExperimentType experimentType) {
        String query = "DELETE FROM experiment_types WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, experimentType.getExperimentTypeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
