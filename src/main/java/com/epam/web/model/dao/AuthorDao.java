package com.epam.web.model.dao;

import com.epam.web.model.entity.Author;

import javax.servlet.http.Part;

public interface AuthorDao extends BaseDao<Author> {
    boolean add(Part image, String name, String surname);
    boolean exists(String name, String surname);
}
