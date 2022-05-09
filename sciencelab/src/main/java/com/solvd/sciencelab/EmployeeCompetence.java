package com.solvd.sciencelab;

public class EmployeeCompetence {
    private ExperimentType experimentType;
    private Employee employee;
    private int employeeCompetence;

    public EmployeeCompetence() {
    }

    public EmployeeCompetence(ExperimentType experimentType, Employee employee, int employeeCompetence) {
        this.experimentType = experimentType;
        this.employee = employee;
        this.employeeCompetence = employeeCompetence;
    }

    public ExperimentType getExperimentType() {
        return experimentType;
    }

    public void setExperimentType(ExperimentType experimentType) {
        this.experimentType = experimentType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEmployeeCompetence() {
        return employeeCompetence;
    }

    public void setEmployeeCompetence(int employeeCompetence) {
        this.employeeCompetence = employeeCompetence;
    }

    @Override
    public String toString() {
        return "EmployeeCompetence{" +
                "experimentType=" + experimentType +
                ", employee=" + employee +
                ", employeeCompetence=" + employeeCompetence +
                '}';
    }
}
