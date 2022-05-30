package com.solvd.sciencelab.dao;

import com.solvd.sciencelab.entities.Client;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface IClientDao extends Dao<Client> {
    void insert(@Param("first_name") String firstName, @Param("last_name") String lastName) throws SQLException;

    void update(@Param("first_name") String firstName, @Param("last_name") String lastName, @Param("id") int id) throws SQLException;
}
