package com.solvd.sciencelab.dao;


import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.Experiment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExperimentDao extends JDBCDao implements Dao<Experiment> {

    private static final Logger LOGGER = LogManager.getLogger(ExperimentDao.class);
    private final ConnectionPool cp = getCp();

    @Override
    public Experiment select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Experiments where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
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
        try (PreparedStatement ps = c.prepareStatement(query)) {
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
    }

    @Override
    public void update(Experiment experiment, int id) {
    }

    @Override
    public void delete(Experiment experiment) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Delete from Experiments where ID = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, experiment.getExperimentId());
            LOGGER.info("Experiment: " + experiment.getExperimentId() + " was canceled and deleted.");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }
}
