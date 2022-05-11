package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.*;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryDao implements Dao<Laboratory> {
    @Override
    public Laboratory select(long id) {
        String query = "SELECT l.id, l.name, l.exp_capacity, l.labs_size_id, l.city_id, ls.lab_size, ls.square_meters, c.city_name FROM laboratories l " +
                "JOIN labs_size ls on l.labs_size_id = ls.id " +
                "JOIN cities c on l.city_id = c.id WHERE l.id = " + id;

        Laboratory laboratory;
        LabSize labSize = new LabSize();
        City city = new City();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            //Laboratory info
            int laboratoryId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int expCapacity = resultSet.getInt("exp_capacity");

            //LabSize info
            labSize.setLabSizeId(resultSet.getInt("labs_size_id"));
            labSize.setLabSize(resultSet.getString("lab_size"));

            //City info
            city.setCityId(resultSet.getInt("city_id"));
            city.setCityName(resultSet.getString("city_name"));

            laboratory = new Laboratory(laboratoryId, name, expCapacity, labSize, city);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return laboratory;
    }

    @Override
    public List<Laboratory> selectAll() {
        String query = "SELECT l.id, l.name, l.exp_capacity, l.labs_size_id, l.city_id, ls.lab_size, ls.square_meters, c.city_name FROM laboratories l " +
                "JOIN labs_size ls on l.labs_size_id = ls.id " +
                "JOIN cities c on l.city_id = c.id";

        Laboratory laboratory;
        LabSize labSize = new LabSize();
        City city = new City();
        List<Laboratory> laboratories = new ArrayList<>();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //Laboratory info
                int laboratoryId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int expCapacity = resultSet.getInt("exp_capacity");

                //LabSize info
                labSize.setLabSizeId(resultSet.getInt("labs_size_id"));
                labSize.setLabSize(resultSet.getString("lab_size"));

                //City info
                city.setCityId(resultSet.getInt("city_id"));
                city.setCityName(resultSet.getString("city_name"));

                laboratory = new Laboratory(laboratoryId, name, expCapacity, labSize, city);
                laboratories.add(laboratory);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return laboratories;
    }

    @Override
    public void insert(Laboratory laboratory) {
        String query = "INSERT INTO laboratories (name, exp_capacity) VALUES (?, ?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, laboratory.getName());
            statement.setInt(2, laboratory.getExpCapacity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Laboratory laboratory, int id) {
        String query = "UPDATE laboratories SET name = ?, exp_capacity = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, laboratory.getName());
            statement.setInt(1, laboratory.getExpCapacity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Laboratory laboratory) {
        String query = "DELETE FROM laboratories WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, laboratory.getLaboratoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
