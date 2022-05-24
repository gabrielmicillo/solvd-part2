package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.conection.ConnectionPool;
import com.solvd.sciencelab.conection.JDBCDao;
import com.solvd.sciencelab.entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends JDBCDao implements Dao<Order> {

    private final ConnectionPool cp = getCp();

    @Override
    public Order select(long id) throws SQLException {
        Connection c = cp.getConnection();
        String query = "Select * from Orders where ID = ?";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Order(rs.getInt("id"), rs.getInt("hours_required"));
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public List<Order> selectAll() throws SQLException {
        Connection c = cp.getConnection();
        List<Order> orders = new ArrayList<>();
        String query = "Select * from Orders";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"), rs.getInt("hours_required"));
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            cp.releaseConnection(c);
        }
    }

    @Override
    public void insert(Order order) {
    }

    @Override
    public void update(Order order, int id) {
    }

    @Override
    public void delete(int id) {
    }
}
