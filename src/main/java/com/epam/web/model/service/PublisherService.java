package com.epam.web.model.service;

import com.epam.web.model.entity.Publisher;

public interface PublisherService extends BaseService<Publisher> {
    boolean add(String title);
    boolean exists(String title);
}
