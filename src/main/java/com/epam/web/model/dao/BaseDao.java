package com.epam.web.model.dao;

import java.sql.ResultSet;
import java.util.List;

public interface BaseDao<E> {
    List<E> findAll();

//    default List<E> convertResultSetToList(ResultSet resultSet) {
//        Class cls = Class.forName(null);
//    }
}
