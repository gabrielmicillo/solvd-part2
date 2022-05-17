package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDao extends JDBCDao implements Dao<City> {
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

    public City getByLaboratoryId(int id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Laboratories JOIN Cities on Laboratories.city_id=Cities.id where Laboratories.id=?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new City(rs.getInt("city_id"), rs.getString("city_name"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<City> selectAll() throws SQLException {
        return null;
    }

    @Override
    public void insert(City city) throws SQLException {

    }

    @Override
    public void update(City city, int id) {

    }

    @Override
    public void delete(City city) throws SQLException {

    }
}
