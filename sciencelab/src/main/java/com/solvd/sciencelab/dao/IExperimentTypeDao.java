package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.entities.ExperimentType;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface IExperimentTypeDao extends IDao<ExperimentType> {
    void insert(@Param("type_name") String typeName, @Param("cost_per_hour") int costPerHour) throws SQLException;

    void update(@Param("type_name") String typeName, @Param("cost_per_hour") int costPerHour, @Param("id") int id) throws SQLException;
}
