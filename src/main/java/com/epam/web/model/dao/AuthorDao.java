package com.epam.web.model.dao;

import com.epam.web.model.entity.Author;

import javax.servlet.http.Part;
import java.util.List;

public interface AuthorDao {
    boolean add(Part image, String name, String surname);
    boolean exists(String name, String surname);
    List<Author> findAll();
}
