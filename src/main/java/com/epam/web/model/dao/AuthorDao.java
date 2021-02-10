package com.epam.web.model.dao;

import com.epam.web.model.entity.Author;

import java.io.File;
import java.util.List;

public interface AuthorDao {
    boolean add(File image, String name, String surname);
    boolean exists(String name, String surname);
    List<Author> findAll();
}
