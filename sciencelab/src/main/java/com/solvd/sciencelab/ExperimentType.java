package com.solvd.sciencelab;

public class ExperimentType {
    private int experimentTypeId;
    private String typeName;
    private int costPerHour;

    public ExperimentType() {
    }

    public ExperimentType(int experimentTypeId, String typeName, int costPerHour) {
        this.experimentTypeId = experimentTypeId;
        this.typeName = typeName;
        this.costPerHour = costPerHour;
    }

    public int getExperimentTypeId() {
        return experimentTypeId;
    }

    public void setExperimentTypeId(int experimentTypeId) {
        this.experimentTypeId = experimentTypeId;
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
                "experimentTypeId=" + experimentTypeId +
                ", typeName='" + typeName + '\'' +
                ", costPerHour=" + costPerHour +
                '}';
    }
}
