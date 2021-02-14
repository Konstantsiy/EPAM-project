package com.epam.web.model.service.impl;

import com.epam.web.model.dao.AuthorDao;
import com.epam.web.model.dao.impl.AuthorDaoImpl;
import com.epam.web.model.entity.Author;
import com.epam.web.model.service.AuthorService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private static final Logger logger = LogManager.getLogger(AuthorServiceImpl.class);

    private final AuthorDao authorDao = AuthorDaoImpl.getInstance();

    public AuthorServiceImpl() {}

    @Override
    public boolean add(Part filePart, String name, String surname, String bio) {
        if(filePart == null || authorDao.exists(name, surname)) {
            return false;
        }
        logger.debug("File name: " + filePart.getName());
        logger.debug("File size: " + filePart.getSize());
        logger.debug("File content type: " + filePart.getContentType());
        return authorDao.add(filePart, name, surname, bio);
    }

    @Override
    public boolean exists(String name, String surname) {
        return authorDao.exists(name, surname);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public void delete(int id) {

    }
}
