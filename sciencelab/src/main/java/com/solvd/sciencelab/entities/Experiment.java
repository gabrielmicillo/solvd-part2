package com.solvd.sciencelab.entities;

public class Experiment {
    private long experimentId;
    private int testTubeUsage;
    private Status status;
    private ExperimentType experimentType;
    private Financiation financiation;
    private Laboratory laboratory;

    public Experiment() {
    }

    public Experiment(int testTubeUsage, Status status, ExperimentType experimentType, Financiation financiation, Laboratory laboratory) {
        this.testTubeUsage = testTubeUsage;
        this.status = status;
        this.experimentType = experimentType;
        this.financiation = financiation;
        this.laboratory = laboratory;
    }

    public long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(long experimentId) {
        this.experimentId = experimentId;
    }

    public int getTestTubeUsage() {
        return testTubeUsage;
    }

    public void setTestTubeUsage(int testTubeUsage) {
        this.testTubeUsage = testTubeUsage;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ExperimentType getExperimentType() {
        return experimentType;
    }

    public void setExperimentType(ExperimentType experimentType) {
        this.experimentType = experimentType;
    }

    public Financiation getFinanciation() {
        return financiation;
    }

    public void setFinanciation(Financiation financiation) {
        this.financiation = financiation;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "experimentId=" + experimentId +
                ", testTubeUsage=" + testTubeUsage +
                ", status=" + status +
                ", experimentType=" + experimentType +
                ", financiation=" + financiation +
                ", laboratory=" + laboratory +
                '}';
    }
}
