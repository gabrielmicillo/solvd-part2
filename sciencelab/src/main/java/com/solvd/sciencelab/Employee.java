package com.solvd.sciencelab;

import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private Position position;
    private List<Experiment> experiment;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Position position, List<Experiment> experiment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.experiment = experiment;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", experiment=" + experiment +
                '}';
    }
}
