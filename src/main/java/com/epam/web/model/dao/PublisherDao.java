package com.epam.web.model.dao;

import com.epam.web.model.entity.Publisher;

public interface PublisherDao extends BaseDao<Publisher> {
    boolean add(String title);
    boolean exists(String title);
}
