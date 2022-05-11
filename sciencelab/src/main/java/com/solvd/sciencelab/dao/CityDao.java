package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.City;
import com.solvd.sciencelab.dao.conection.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao implements Dao<City>{

    @Override
    public City select(long id) {
        String query = "SELECT id, city_name FROM cities WHERE id = " + id;
        City city;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int cityId = resultSet.getInt("id");
            String cityName = resultSet.getString("city_name");

            city = new City(cityId, cityName);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return city;
    }

    @Override
    public List<City> selectAll() {
        String query = "SELECT id, city_name FROM careers";
        List<City> cities = new ArrayList<>();
        City city;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int cityId = resultSet.getInt("id");
                String cityName = resultSet.getString("city_name");

                city = new City(cityId, cityName);
                cities.add(city);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

    @Override
    public void insert(City city) {
        String query = "INSERT INTO cities (city_name) VALUES (?)";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, city.getCityName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(City city, int id) {
        String query = "UPDATE cities SET city_name = ? WHERE id = " + id;

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, city.getCityName());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(City city) {
        String query = "DELETE FROM cities WHERE id = ?";

        try {
            Connection connection = Conection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, city.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}