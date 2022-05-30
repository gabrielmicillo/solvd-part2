package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.entities.LabSize;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface ILabSizeDao extends Dao<LabSize> {
    void insert(@Param("lab_size") String labSize, @Param("square_meters") int squareMeters) throws SQLException;

    void update(@Param("lab_size") String labSize, @Param("square_meters") int squareMeters, @Param("id") int id) throws SQLException;
}
