package com.solvd.sciencelab.service;

import com.solvd.sciencelab.dao.OrderDao;
import com.solvd.sciencelab.entities.Order;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    OrderDao orderDao = new OrderDao();

    public Order getOrderById(int id) throws SQLException {
        return orderDao.select(id);
    }

    public List<Order> getAllOrders() throws SQLException {
        return orderDao.selectAll();
    }

    public List<Order> getAllOrdersByHoursRequired() throws SQLException {
        return orderDao.selectAll().stream()
                .sorted(Comparator.comparing(Order::getHoursRequired))
                .collect(Collectors.toList());
    }

    public void newOrder(Order order) {
        orderDao.insert(order);
    }

    public void changeOrderById(Order order, int id) {
        orderDao.update(order, id);
    }


    public void cancelOrder(Order order) {
        orderDao.delete(order);
    }
}
