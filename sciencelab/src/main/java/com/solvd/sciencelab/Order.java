package com.solvd.sciencelab;

import java.util.List;

public class Order {
    private long orderId;
    private int hoursRequired;
    private Client client;
    private List<Experiment> experiment;

    public Order() {
    }

    public Order(int hoursRequired, Client client, List<Experiment> experiment) {
        this.hoursRequired = hoursRequired;
        this.client = client;
        this.experiment = experiment;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getHoursRequired() {
        return hoursRequired;
    }

    public void setHoursRequired(int hoursRequired) {
        this.hoursRequired = hoursRequired;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Experiment> getExperiment() {
        return experiment;
    }

    public void setExperiment(List<Experiment> experiment) {
        this.experiment = experiment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", hoursRequired=" + hoursRequired +
                ", client=" + client +
                ", experiment=" + experiment +
                '}';
    }
}
