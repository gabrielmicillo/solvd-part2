package com.solvd.sciencelab;

import com.solvd.sciencelab.service.OrderService;

public class Runner {
    public static void main(String[] args){
        OrderService os = new OrderService();

        os.getOrderById(1);
    }
}
