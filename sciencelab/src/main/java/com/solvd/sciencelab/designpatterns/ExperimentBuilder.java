package com.solvd.sciencelab.designpatterns;

import com.solvd.sciencelab.entities.*;

public class ExperimentBuilder {
    private long experimentId;
    private int testTubeUsage;
    private Status status;
    private ExperimentType experimentType;
    private Financiation financiation;
    private Laboratory laboratory;

    public ExperimentBuilder() {
    }

    public ExperimentBuilder(int testTubeUsage, Status status, ExperimentType experimentType, Financiation financiation, Laboratory laboratory) {
        this.testTubeUsage = testTubeUsage;
        this.status = status;
        this.experimentType = experimentType;
        this.financiation = financiation;
        this.laboratory = laboratory;
    }

    public ExperimentBuilder setExperimentId(long experimentId) {
        this.experimentId = experimentId;
        return this;
    }

    public ExperimentBuilder setTestTubeUsage(int testTubeUsage) {
        this.testTubeUsage = testTubeUsage;
        return this;
    }

    public ExperimentBuilder setStatus(Status status) {
        this.status = status;
        return this;
    }

    public ExperimentBuilder setExperimentType(ExperimentType experimentType) {
        this.experimentType = experimentType;
        return this;
    }

    public ExperimentBuilder setFinanciation(Financiation financiation) {
        this.financiation = financiation;
        return this;
    }

    public ExperimentBuilder setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
        return this;
    }

    public Experiment build() {
        return new Experiment(testTubeUsage, status, experimentType, financiation, laboratory);
    }

    @Override
    public String toString() {
        return "ExperimentBuilder{" +
                "testTubeUsage=" + testTubeUsage +
                ", status=" + status +
                ", experimentType=" + experimentType +
                ", financiation=" + financiation +
                ", laboratory=" + laboratory +
                '}';
    }
}
