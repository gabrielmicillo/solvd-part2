package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao extends JDBCDao implements IClientDao {

    private static final Logger LOGGER = LogManager.getLogger(ClientDao.class);
    private final ConnectionPool cp = getCp();

    @Override
    public Client select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Clients where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Client(rs.getString("first_name"), rs.getString("last_name"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<Client> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<Client> clients = new ArrayList<>();
        String query = "Select * from Clients";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client(rs.getString("first_name"), rs.getString("last_name"));
                clients.add(client);
            }
            return clients;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(Client client) throws SQLException {
        Connection c = cp.getConnection();
        String query = "INSERT INTO Clients (first_name, last_name) VALUES (?, ?)";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.executeUpdate();
            LOGGER.info("Client successfully stored in database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void update(Client client, int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "UPDATE Clients SET first_name = ?, last_name = ? where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setInt(3, id);
            ps.executeUpdate();
            LOGGER.info("Client was updated in the database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "DELETE FROM Clients WHERE id = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            LOGGER.info("Client was deleted from database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(String firstName, String lastName) throws SQLException {
//
    }

    @Override
    public void update(String firstName, String lastName, int id) throws SQLException {
//
    }
}
