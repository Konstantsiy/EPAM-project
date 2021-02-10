package com.epam.web.model.service.impl;

import com.epam.web.model.dao.AuthorDao;
import com.epam.web.model.dao.impl.AuthorDaoImpl;
import com.epam.web.model.entity.Author;
import com.epam.web.model.service.AuthorService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private static final Logger logger = LogManager.getLogger(AuthorServiceImpl.class);

    private final AuthorDao authorDao = AuthorDaoImpl.getInstance();

    public AuthorServiceImpl() {}

    @Override
    public boolean add(String image, String name, String surname) {
        if(authorDao.exists(name, surname)) {
            return false;
        }
        File prepareImage = new File(image);
        return authorDao.add(prepareImage, name, surname);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
