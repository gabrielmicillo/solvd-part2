package com.solvd.sciencelab.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    T select(long id) throws SQLException;

    List<T> selectAll() throws SQLException;

    void insert(T t) throws SQLException;

    void update(T t, int id) throws SQLException;

    void delete(int id) throws SQLException;
}