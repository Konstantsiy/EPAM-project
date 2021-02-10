package com.epam.web.model.service;

import com.epam.web.model.entity.Author;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.util.List;

public interface AuthorService {
    boolean add(Part filePart, String name, String surname);
    List<Author> findAll();
}
