package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.entities.Status;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface IStatusDao extends IDao<Status> {
    void insert(@Param("exp_status") String expStatus) throws SQLException;

    void update(@Param("exp_status") String expStatus, @Param("id") int id) throws SQLException;
}
