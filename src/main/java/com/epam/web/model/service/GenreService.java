package com.epam.web.model.service;

import com.epam.web.model.entity.Genre;

public interface GenreService extends BaseService<Genre> {
    boolean add(String titleEng, String titleRus);
    boolean exists(String title, boolean isEng);
}
