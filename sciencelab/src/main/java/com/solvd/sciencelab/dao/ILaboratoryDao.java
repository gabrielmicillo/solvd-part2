package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.entities.Laboratory;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface ILaboratoryDao extends IDao<Laboratory> {

    Laboratory selectByName(String name) throws SQLException;

    void insert(@Param("name") String name, @Param("exp_capacity") int exp_capacity, @Param("labs_size_id") int labSizeId, @Param("city_id") int cityId) throws SQLException;

    int getIdByLabName(String labName) throws SQLException;
}
