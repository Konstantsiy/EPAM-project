package com.epam.web.model.dao;

import java.sql.ResultSet;
import java.util.List;

public interface BaseDao<E> {
    List<E> findAll();
    void deleteById(int id);
    List<E> convertResultSetToList(ResultSet resultSet);
    E convertResultSetToEntity(ResultSet resultSet);
    E findById(int id);
}
