package com.epam.web.model.service;

import java.util.List;

public interface BaseService<E> {
    List<E> findAll();
}
