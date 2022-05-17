package com.solvd.sciencelab.entities;

public class Status {
    private String expStatus;

    public Status() {
    }

    public Status(String expStatus) {
        this.expStatus = expStatus;
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
