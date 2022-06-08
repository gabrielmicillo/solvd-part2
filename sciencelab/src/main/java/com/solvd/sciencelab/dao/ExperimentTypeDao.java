package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.ExperimentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExperimentTypeDao extends JDBCDao implements IExperimentTypeDao {

    private static final Logger LOGGER = LogManager.getLogger(ExperimentTypeDao.class);
    private final ConnectionPool cp = getCp();

    @Override
    public ExperimentType select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Experiment_Types where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new ExperimentType(rs.getString("type_name"), rs.getInt("cost_per_hour"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<ExperimentType> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<ExperimentType> experimentTypes = new ArrayList<>();
        String query = "Select * from Experiment_Types";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ExperimentType experimentType = new ExperimentType(rs.getString("type_name"), rs.getInt("cost_per_hour"));
                experimentTypes.add(experimentType);
            }
            return experimentTypes;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(ExperimentType experimentType) throws SQLException {
        Connection c = cp.getConnection();
        String query = "INSERT INTO Experiment_Types (type_name, cost_per_hour) VALUES (?, ?)";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, experimentType.getTypeName());
            ps.setInt(2, experimentType.getCostPerHour());
            ps.executeUpdate();
            LOGGER.info("Experiment type successfully stored in database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void update(ExperimentType experimentType, int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "UPDATE Experiment_Types SET type_name = ?, cost_per_hour = ? where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, experimentType.getTypeName());
            ps.setInt(2, experimentType.getCostPerHour());
            ps.setInt(3, id);
            ps.executeUpdate();
            LOGGER.info("Experiment type was updated in the database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "DELETE FROM Experiment_Types WHERE id = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            LOGGER.info("Experiment type was deleted from database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(String typeName, int costPerHour) throws SQLException {

    }

    @Override
    public void update(String typeName, int costPerHour, int id) throws SQLException {

    }
}
