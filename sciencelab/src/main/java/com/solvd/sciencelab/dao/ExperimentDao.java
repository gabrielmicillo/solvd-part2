package com.solvd.sciencelab.dao;




import com.solvd.sciencelab.*;
import com.solvd.sciencelab.dao.conection.Conection;
import com.solvd.sciencelab.dao.conection.ConnectionPool;
import com.solvd.sciencelab.dao.conection.JDBCDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExperimentDao extends JDBCDao implements Dao<Experiment> {

    private ConnectionPool cp = getCp();
    @Override
    public Experiment select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Experiments where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query);) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Experiment(rs.getInt("test_tube_usage"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<Experiment> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<Experiment> experiments = new ArrayList<>();
        String query = "Select * from Experiments";
        try (PreparedStatement ps = c.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Experiment experiment = new Experiment(rs.getInt("test_tube_usage"));
                experiments.add(experiment);
            }
            return experiments;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(Experiment experiment) {
        String query = "INSERT INTO experiments (test_tube_usage) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, experiment.getTestTubeUsage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Experiment experiment, int id) {
        String query = "UPDATE experiments SET test_tube_usage = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, experiment.getTestTubeUsage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Experiment experiment) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Delete from Experiments where ID = ?";

        try (PreparedStatement ps = c.prepareStatement(query);) {
            ps.setLong(1, experiment.getExperimentId());
            System.out.println("Experiment: " + experiment.getExperimentId() + " was canceled and deleted.");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }
}
