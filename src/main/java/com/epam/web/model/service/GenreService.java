package com.epam.web.model.service;

import com.epam.web.model.entity.Genre1;

public interface GenreService extends BaseService<Genre1> {
    boolean add(String title);
    boolean exists(String title);
}
