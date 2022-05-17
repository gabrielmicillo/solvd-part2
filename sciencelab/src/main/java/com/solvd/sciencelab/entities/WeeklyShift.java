package com.solvd.sciencelab.entities;

public class WeeklyShift {
    private Laboratory laboratory;
    private Employee employee;
    private int weeklyShift;

    public WeeklyShift() {
    }

    public WeeklyShift(Laboratory laboratory, Employee employee, int weeklyShift) {
        this.laboratory = laboratory;
        this.employee = employee;
        this.weeklyShift = weeklyShift;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getWeeklyShift() {
        return weeklyShift;
    }

    public void setWeeklyShift(int weeklyShift) {
        this.weeklyShift = weeklyShift;
    }

    @Override
    public String toString() {
        return "WeeklyShift{" +
                "laboratory=" + laboratory +
                ", employee=" + employee +
                ", weeklyShift=" + weeklyShift +
                '}';
    }
}
