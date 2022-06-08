package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.Client;
import com.solvd.sciencelab.entities.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDao extends JDBCDao implements IStatusDao {

    private static final Logger LOGGER = LogManager.getLogger(StatusDao.class);

    private final ConnectionPool cp = getCp();
    @Override
    public Status select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Status where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Status(rs.getString("exp_status"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<Status> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<Status> statuses = new ArrayList<>();
        String query = "Select * from Status";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Status status = new Status(rs.getString("exp_status"));
                statuses.add(status);
            }
            return statuses;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(Status status) throws SQLException {
        Connection c = cp.getConnection();
        String query = "INSERT INTO Status (exp_status) VALUES (?, ?)";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, status.getExpStatus());
            ps.executeUpdate();
            LOGGER.info("Status successfully stored in database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void update(Status status, int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "UPDATE Status SET exp_status = ? where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, status.getExpStatus());
            ps.setInt(2, id);
            ps.executeUpdate();
            LOGGER.info("Status was updated in the database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "DELETE FROM Status WHERE id = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            LOGGER.info("Status was deleted from database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(String expStatus) throws SQLException {

    }

    @Override
    public void update(String expStatus, int id) throws SQLException {

    }
}
