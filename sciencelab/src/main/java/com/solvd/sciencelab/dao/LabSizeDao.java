package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.LabSize;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LabSizeDao extends JDBCDao implements ILabSizeDao {
    private static final Logger LOGGER = LogManager.getLogger(LabSizeDao.class);

    private final ConnectionPool cp = getCp();

    public LabSize select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Labs_Size where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
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

    public LabSize getByLaboratoryId(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Laboratories JOIN Labs_Size on Laboratories.labs_size_id=Labs_Size.id where Laboratories.id=?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new LabSize(rs.getString("lab_size"), rs.getInt("square_meters"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    public int getIdByLabSize(String labSize) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Labs_Size where lab_size = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, labSize);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            return id;
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
        try (PreparedStatement ps = c.prepareStatement(query)) {
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
    public void insert(LabSize lSize) throws SQLException {
        Connection c = cp.getConnection();
        String query = "INSERT INTO Labs_Size (lab_size, square_meters) VALUES (?, ?)";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, lSize.getLabSize());
            ps.setInt(2, lSize.getSquareMeters());
            ps.executeUpdate();
            LOGGER.info("Laboratory size successfully stored in database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void update(LabSize lSize, int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "UPDATE Labs_Size SET lab_size = ?, square_meters = ? where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, lSize.getLabSize());
            ps.setInt(2, lSize.getSquareMeters());
            ps.setInt(3, id);
            ps.executeUpdate();
            LOGGER.info("Laboratory size was updated in the database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "DELETE FROM Labs_Size WHERE id = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            LOGGER.info("Laboratory size was deleted from database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(String labSize, int squareMeters) throws SQLException {

    }

    @Override
    public void update(String labSize, int squareMeters, int id) throws SQLException {

    }
}
