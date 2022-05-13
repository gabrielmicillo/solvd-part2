package com.solvd.sciencelab;

public class ExperimentType {
    private String typeName;
    private int costPerHour;

    public ExperimentType() {
    }

    public ExperimentType(String typeName, int costPerHour) {
        this.typeName = typeName;
        this.costPerHour = costPerHour;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Override
    public String toString() {
        return "ExperimentType{" +
                "typeName='" + typeName + '\'' +
                ", costPerHour=" + costPerHour +
                '}';
    }
}
