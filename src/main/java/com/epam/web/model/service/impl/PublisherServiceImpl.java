package com.epam.web.model.service.impl;

import com.epam.web.model.dao.PublisherDao;
import com.epam.web.model.dao.impl.PublisherDaoImpl;
import com.epam.web.model.entity.Publisher;
import com.epam.web.model.service.PublisherService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    private static final Logger logger = LogManager.getLogger(PublisherServiceImpl.class);
    private final PublisherDao publisherDao = PublisherDaoImpl.getInstance();

    @Override
    public boolean add(String title) {
        return publisherDao.add(title);
    }

    @Override
    public boolean exists(String title) {
        return publisherDao.exists(title);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    @Override
    public void delete(int id) {
        publisherDao.deleteById(id);
    }
}
