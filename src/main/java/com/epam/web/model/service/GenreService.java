package com.epam.web.model.service;

import com.epam.web.model.entity.Genre;

public interface GenreService extends BaseService<Genre> {
    boolean add(String title);
    boolean exists(String title);
}
