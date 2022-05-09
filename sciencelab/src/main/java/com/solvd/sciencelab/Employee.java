package com.solvd.sciencelab;

import java.util.List;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private Position position;
    private List<Experiment> experiment;

    public Employee() {
    }

    public Employee(int employeeId, String firstName, String lastName, Position position, List<Experiment> experiment) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.experiment = experiment;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Experiment> getExperiment() {
        return experiment;
    }

    public void setExperiment(List<Experiment> experiment) {
        this.experiment = experiment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", experiment=" + experiment +
                '}';
    }
}
