package com.solvd.sciencelab.service;

import com.solvd.sciencelab.Order;
import com.solvd.sciencelab.dao.OrderDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
    OrderDao orderDao = new OrderDao();

    public Order getOrderById(int id) {
        return orderDao.select(id);
    }

    public List<Order> getAllOrders() {
        return orderDao.selectAll();
    }

    public List<Order> getAllOrdersByHoursRequired() {
        return orderDao.selectAll().stream()
                .sorted(Comparator.comparing(Order::getHoursRequired))
                .collect(Collectors.toList());
    }

    public void newOrder (Order order) {
        orderDao.insert(order);
    }

    public void changeOrderById(Order order, int id) {
        orderDao.update(order, id);
    }


    public void cancelOrder (Order order) {
        orderDao.delete(order);
    }
}
