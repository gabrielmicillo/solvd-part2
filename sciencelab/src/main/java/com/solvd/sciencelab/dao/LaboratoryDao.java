package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.Laboratory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LaboratoryDao extends JDBCDao implements Dao<Laboratory> {
    private static final Logger LOGGER = LogManager.getLogger(LaboratoryDao.class);
    private final ConnectionPool cp = getCp();

    @Override
    public Laboratory select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Laboratories JOIN Labs_Size on Laboratories.labs_size_id=Labs_Size.id JOIN Cities on Laboratories.city_id=Cities.id where Laboratories.id = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Laboratory(rs.getString("name"), rs.getInt("exp_capacity"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    public Laboratory selectByLabSizeId(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Laboratories JOIN Labs_Size on Laboratories.labs_size_id=Labs_Size.id JOIN Cities on Laboratories.city_id=Cities.id where Laboratories.id = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Laboratory(rs.getString("name"), rs.getInt("exp_capacity"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }

    }

    @Override
    public List<Laboratory> selectAll() {
        return null;
    }

    @Override
    public void insert(Laboratory laboratory) throws SQLException {
        Connection c = cp.getConnection();
        String query = "INSERT INTO Laboratories (name, exp_capacity, labs_size_id, city_id) VALUES (?,?,?,?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, laboratory.getName());
            ps.setInt(2, laboratory.getExpCapacity());
            ps.setInt(3, laboratory.getLabsize().getLabSizeId());
            ps.setInt(4, laboratory.getCity().getCityId());
            ps.executeUpdate();
            LOGGER.info("Laboratory: " + laboratory.getName() + " successfully stored into database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void update(Laboratory laboratory, int id) {
    }

    @Override
    public void delete(Laboratory laboratory) {
    }
}
