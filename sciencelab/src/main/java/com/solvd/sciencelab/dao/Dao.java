package com.solvd.sciencelab.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T select(long id) throws SQLException;

    List<T> selectAll() throws SQLException;

    void insert(T t) throws SQLException;

    void update(T t, int id);

    void delete(T t) throws SQLException;
}