package com.epam.web.model.dao;

import java.sql.ResultSet;
import java.util.List;

public interface BaseDao<E> {
    List<E> findAll();
    void deleteById(int id);

//    default List<E> convertResultSetToList(ResultSet resultSet) {
//        Class cls = Class.forName(null);
//    }
}
