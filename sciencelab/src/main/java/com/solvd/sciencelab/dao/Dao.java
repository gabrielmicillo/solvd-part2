package com.solvd.sciencelab.dao;

import java.util.List;

public interface Dao<T> {

    T select(long id);

    List<T> selectAll();

    void insert(T t);

    void update(T t, int id);

    void delete(T t);
}