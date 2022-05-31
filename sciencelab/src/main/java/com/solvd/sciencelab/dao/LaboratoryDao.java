package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.City;
import com.solvd.sciencelab.entities.LabSize;
import com.solvd.sciencelab.entities.Laboratory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaboratoryDao extends JDBCDao implements ILaboratoryDao {
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
            LabSize labSize = new LabSize(rs.getString("lab_size"), rs.getInt("square_meters"));
            City city = new City(rs.getString("city_name"));
            return new Laboratory(rs.getString("name"), rs.getInt("exp_capacity"), labSize, city);
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<Laboratory> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<Laboratory> laboratories = new ArrayList<>();
        String query = "Select * from Laboratories JOIN Labs_Size on Laboratories.labs_size_id=Labs_Size.id JOIN Cities on Laboratories.city_id=Cities.id";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LabSize labSize = new LabSize(rs.getString("lab_size"), rs.getInt("square_meters"));
                City city = new City(rs.getString("city_name"));
                Laboratory laboratory = new Laboratory(rs.getString("name"), rs.getInt("exp_capacity"), labSize, city);
                laboratories.add(laboratory);
            }
            return laboratories;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
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
            LOGGER.info("Laboratory successfully stored into database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void update(Laboratory laboratory, int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "UPDATE Laboratories SET name = ?, exp_capacity = ?, labs_size_id = ?, city_id = ? where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, laboratory.getName());
            ps.setInt(2, laboratory.getExpCapacity());
            ps.setInt(3, laboratory.getLabsize().getLabSizeId());
            ps.setInt(4, laboratory.getCity().getCityId());
            ps.setInt(5, id);
            ps.executeUpdate();
            LOGGER.info("Laboratory was updated in the database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "DELETE FROM Laboratories WHERE id = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            LOGGER.info("Laboratory was deleted from database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public Laboratory selectByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void insert(String name, int expCapacity, int labSizeId, int cityId) throws SQLException {

    }
}
