package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.City;
import com.solvd.sciencelab.LabSize;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabSizeDao implements Dao<LabSize> {
    @Override
    public LabSize select(long id) {
        String query = "SELECT id, lab_size, square_meters FROM Labs_Size WHERE id = " + id;
        LabSize lSize;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int labSizeId = resultSet.getInt("id");
            String labSize = resultSet.getString("lab_size");
            int squareMeters = resultSet.getInt("square_meters");

            lSize = new LabSize(labSizeId, labSize, squareMeters);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lSize;
    }

    @Override
    public List<LabSize> selectAll() {
        String query = "SELECT id, lab_size, square_meters FROM Labs_Size";
        LabSize lSize;
        List<LabSize> labSizes = new ArrayList<>();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int labSizeId = resultSet.getInt("id");
                String labSize = resultSet.getString("lab_size");
                int squareMeters = resultSet.getInt("square_meters");

                lSize = new LabSize(labSizeId, labSize, squareMeters);
                labSizes.add(lSize);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return labSizes;
    }

    @Override
    public void insert(LabSize lSize) {
        String query = "INSERT INTO Labs_Size (lab_size, square_meters) VALUES (?, ?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, lSize.getLabSize());
            statement.setInt(2, lSize.getSquareMeters());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(LabSize lSize, int id) {
        String query = "UPDATE Labs_Size SET lab_size = ?, square_meters = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, lSize.getLabSize());
            statement.setInt(2, lSize.getSquareMeters());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(LabSize lSize) {
        String query = "DELETE FROM cities WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, lSize.getLabSizeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
