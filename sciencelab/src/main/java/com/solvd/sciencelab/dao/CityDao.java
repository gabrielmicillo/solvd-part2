package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CityDao implements Dao<City>{

    private List<City> cities = new ArrayList<>();

    @Override
    public Optional<City> get(long id) {
        return Optional.ofNullable(cities.get((int) id));
    }

    @Override
    public List<City> getAll() {
        return cities;
    }

    @Override
    public void save(City city) {
        cities.add(city);
    }

    @Override
    public void update(City city, String[] params) {
        city.setCityName(Objects.requireNonNull(
                params[1], "cannot be null"));

        cities.add(city);

    }

    @Override
    public void delete(City city) {
        cities.remove(city);
    }
}
