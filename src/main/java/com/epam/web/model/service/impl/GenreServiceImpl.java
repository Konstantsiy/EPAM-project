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
    public boolean add(String titleEng, String titleRus) {
        if(genreDao.exists(titleEng, titleRus)) {
            logger.debug("Genre " + titleEng + " (" + titleRus + ")" + " is already exist");
            return false;
        }
        return genreDao.add(titleEng, titleRus);
    }

    @Override
    public boolean exists(String title, boolean isEng) {
        return genreDao.exists(title, isEng);
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public void delete(int id) {
        genreDao.deleteById(id);
        logger.info("Genre with id " + id + " was deleted");
    }
}
