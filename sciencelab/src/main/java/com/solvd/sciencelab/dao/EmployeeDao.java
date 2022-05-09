package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.Client;
import com.solvd.sciencelab.Employee;
import com.solvd.sciencelab.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeDao implements Dao<Employee> {

    private List<Employee> employees = new ArrayList<>();
    @Override
    public Optional<Employee> get(long id) {
        return Optional.ofNullable(employees.get((int) id));
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void update(Employee employee, String[] params) {
        employee.setFirstName(Objects.requireNonNull(
                params[0], "cannot be null"));
        employee.setLastName(Objects.requireNonNull(
                params[1], "cannot be null"));

        employees.add(employee);
    }

    public void update(Employee employee, Position[] params) {
        employee.setPosition(Objects.requireNonNull(
                params[0], "cannot be null"));

        employees.add(employee);
    }

    @Override
    public void delete(Employee employee) {

    }
}
