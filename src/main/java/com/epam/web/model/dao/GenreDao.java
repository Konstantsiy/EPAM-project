package com.epam.web.model.dao;

import com.epam.web.model.entity.Genre;

public interface GenreDao extends BaseDao<Genre> {
    boolean add(String title_eng, String title_rus);
    boolean exists(String title);
}
