package com.epam.web.model.service;

import com.epam.web.model.entity.Genre;

public interface GenreService extends BaseService<Genre> {
    boolean add(String title_eng, String title_rus);
    boolean exists(String title);
}
