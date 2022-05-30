package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends JDBCDao implements ICityDao {

    private static final Logger LOGGER = LogManager.getLogger(CityDao.class);
    private final ConnectionPool cp = getCp();

    @Override
    public City select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Cities where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new City(rs.getString("city_name"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    public int getIdByCityName(String cityName) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Cities where city_name = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, cityName);
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

    public City getByLaboratoryId(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Laboratories JOIN Cities on Laboratories.city_id=Cities.id where Laboratories.id=?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new City(rs.getString("city_name"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<City> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<City> cities = new ArrayList<>();
        String query = "Select * from Cities";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                City city = new City(rs.getString("city_name"));
                cities.add(city);
            }
            return cities;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(City city) throws SQLException {
        Connection c = cp.getConnection();
        String query = "INSERT INTO Cities (city_name) VALUES (?)";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, city.getCityName());
            ps.executeUpdate();
            LOGGER.info("City successfully stored in database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void update(City city, int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "UPDATE Cities SET city_name = ? where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, city.getCityName());
            ps.setInt(2, id);
            ps.executeUpdate();
            LOGGER.info("City was updated in the database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }


    @Override
    public void delete(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "DELETE FROM Cities WHERE id = ?";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            LOGGER.info("City was deleted from database.");
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(String cityName) throws SQLException {

    }

    @Override
    public void update(String cityName, int id) throws SQLException {

    }
}
