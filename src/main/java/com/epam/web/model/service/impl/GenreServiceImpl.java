package com.epam.web.model.service.impl;

import com.epam.web.model.dao.GenreDao;
import com.epam.web.model.dao.impl.GenreDaoImpl;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.service.GenreService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    private static final Logger logger = LogManager.getLogger(GenreServiceImpl.class);

    private final GenreDao genreDao = GenreDaoImpl.getInstance();

    public GenreServiceImpl() {}

    @Override
    public boolean add(String title_eng, String title_rus) {
        if(genreDao.exists(title_eng)) {
            return false;
        }
        return genreDao.add(title_eng, title_rus);
    }

    @Override
    public boolean exists(String title) {
        return genreDao.exists(title);
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }
}
