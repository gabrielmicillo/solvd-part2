package com.solvd.sciencelab.service;

import com.solvd.sciencelab.Employee;
import com.solvd.sciencelab.dao.EmployeeDao;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();

    public Employee getEmployeeById(int id) {
        return employeeDao.select(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.selectAll();
    }

    public List<Employee> getAllEmployeesAlphabetically() {
        return employeeDao.selectAll().stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .collect(Collectors.toList());
    }

    public void registerEmployee(Employee employee) {
        employeeDao.insert(employee);
    }

    public void modifyEmployeeById(Employee employee, int id) {
        employeeDao.update(employee, id);
    }

    public void deleteEmployee(Employee employee) {
        this.employeeDao.delete(employee);
    }
}
