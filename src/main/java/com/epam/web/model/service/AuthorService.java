package com.epam.web.model.service;

import com.epam.web.model.entity.Author;

import java.util.List;

public interface AuthorService {
    boolean add(String image, String name, String surname);
    List<Author> findAll();
}
