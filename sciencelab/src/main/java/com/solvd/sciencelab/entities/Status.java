package com.solvd.sciencelab.entities;

public class Status {

    private int statusId;
    private String expStatus;

    public Status() {
    }

    public Status(String expStatus) {
        this.expStatus = expStatus;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getExpStatus() {
        return expStatus;
    }

    public void setExpStatus(String expStatus) {
        this.expStatus = expStatus;
    }

    @Override
    public String toString() {
        return "Status{" +
                "expStatus='" + expStatus + '\'' +
                '}';
    }
}
