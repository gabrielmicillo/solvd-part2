package com.solvd.sciencelab.dao;


import com.solvd.sciencelab.*;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao implements Dao<Employee> {

    @Override
    public Employee select(long id) {
        String query = "SELECT e.id, e.first_name, e.last_name, e.position_id, e.experiment_id, p.position_name FROM employees e " +
                "JOIN positions p on e.position_id = p.id WHERE e.id = " + id;

        Employee employee;
        Position position = new Position();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            //Employee info
            int employeeId = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            //Position info
            position.setPositionId(resultSet.getInt("position_id"));
            position.setPositionName(resultSet.getString("position_name"));

            List<Experiment> experiment = new ArrayList<>();

            employee = new Employee(employeeId, firstName, lastName, position, experiment);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public List<Employee> selectAll() {
        String query = "SELECT e.id, e.first_name, e.last_name, e.position_id, e.experiment_id, p.position_name FROM employees e " +
                "JOIN positions p on e.position_id = p.id";

        List<Employee> employees = new ArrayList<>();
        Employee employee;
        Position position = new Position();

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

            //Employee info
            int employeeId = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");

            //Position info
            position.setPositionId(resultSet.getInt("position_id"));
            position.setPositionName(resultSet.getString("position_name"));

            List<Experiment> experiment = new ArrayList<>();

            employee = new Employee(employeeId, firstName, lastName, position, experiment);
            employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void insert(Employee employee) {
        String query = "INSERT INTO employees (first_name, last_name) VALUES (?, ?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee, int id) {
        String query = "UPDATE employees SET first_name = ?, last_name = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, employee.getFirstName());
            statement.setString(1, employee.getLastName());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Employee employee) {
        String query = "DELETE FROM employees WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, employee.getEmployeeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
