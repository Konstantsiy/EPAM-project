package com.epam.web.model.dao;

import com.epam.web.model.entity.Genre1;

public interface GenreDao extends BaseDao<Genre1> {
    boolean add(String title);
    boolean exists(String title);
}
