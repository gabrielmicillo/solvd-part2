package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.entities.City;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface ICityDao extends IDao<City> {

    int getIdByCityName(String cityName) throws SQLException;

    City getByLaboratoryId(int id) throws SQLException;

    City selectByName(String cityName) throws SQLException;

    void insert(@Param("city_name") String cityName) throws SQLException;

    void update(@Param("city_name") String cityName, @Param("id") int id) throws SQLException;
}
