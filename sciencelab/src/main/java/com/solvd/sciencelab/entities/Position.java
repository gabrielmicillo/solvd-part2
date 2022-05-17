package com.solvd.sciencelab.entities;

public class Position {
    private String positionName;

    public Position() {
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionName='" + positionName + '\'' +
                '}';
    }
}

