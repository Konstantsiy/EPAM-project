package com.epam.web.model.dao;

import com.epam.web.model.entity.Genre;

public interface GenreDao extends BaseDao<Genre> {
    boolean add(String titleEng, String titleRus);
    boolean exists(String title, boolean isEng);
    boolean exists(String titleEng, String titleRus);
}
