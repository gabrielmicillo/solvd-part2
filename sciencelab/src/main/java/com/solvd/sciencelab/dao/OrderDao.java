package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.*;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements Dao<Order> {
    @Override
    public Order select(long id) {
//        String query = "Use gabriel_micillo;" +
//                "SELECT id, hours_required, experiment_id, client_id, first_name, last_name FROM orders WHERE id = " + id;
//
//        Order order;
//        Client client = new Client();
//        List<Experiment> experiments = new ArrayList<>();
//
//        try {
//            Connection connection = Conection.getConnection();
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet resultSet = statement.executeQuery();
//
//            //Order info
//            int orderId = resultSet.getInt("id");
//            int hoursRequired = resultSet.getInt("hours_required");
//
//            //Client info
//            client.setFirstName(resultSet.getString("first_name"));
//            client.setLastName(resultSet.getString("last_name"));
//
//            order = new Order(orderId, hoursRequired, client, experiments);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        order.toString();
        return null;
    }

    @Override
    public List<Order> selectAll() {
//        String query = "SELECT o.id, o.hours_required, o.experiment_id, o.client_id, c.first_name, c.last_name FROM orders o " +
//                "JOIN clients c on o.client_id = c.id";
//
//        Order order;
//        Client client = new Client();
//        List<Experiment> experiments = new ArrayList<>();
//        List<Order> orders = new ArrayList<>();
//
//        try {
//            Connection connection = Conection.getConnection();
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                //Order info
//                int orderId = resultSet.getInt("id");
//                int hoursRequired = resultSet.getInt("hours_required");
//
//                //Client info
//                client.setFirstName(resultSet.getString("first_name"));
//                client.setLastName(resultSet.getString("last_name"));
//
//                order = new Order(orderId, hoursRequired, client, experiments);
//                orders.add(order);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    @Override
    public void insert(Order order) {
        String query = "INSERT INTO orders (hours_required) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, order.getHoursRequired());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Order order, int id) {
        String query = "UPDATE orders SET hours_required = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, order.getHoursRequired());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Order order) {
        String query = "DELETE FROM orders WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, order.getHoursRequired());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
