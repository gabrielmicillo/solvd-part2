package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.LabSize;
import com.solvd.sciencelab.dao.conection.Conection;
import com.solvd.sciencelab.dao.conection.ConnectionPool;
import com.solvd.sciencelab.dao.conection.JDBCDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabSizeDao extends JDBCDao implements Dao<LabSize> {

    private ConnectionPool cp = getCp();

    public LabSize select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Labs_Size where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query);) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new LabSize(rs.getString("lab_size"), rs.getInt("square_meters"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }

    }

    @Override
    public List<LabSize> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<LabSize> labSizes = new ArrayList<>();
        String query = "Select * from Labs_Size";
        try (PreparedStatement ps = c.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LabSize labSize = new LabSize(rs.getString("lab_size"), rs.getInt("square_meters"));
                labSizes.add(labSize);
            }
            return labSizes;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
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

            statement.setInt(1, lSize.getSquareMeters());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
