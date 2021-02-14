package com.epam.web.model.service;

import com.epam.web.model.entity.Author;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.util.List;

public interface AuthorService extends BaseService<Author> {
    boolean add(Part filePart, String name, String surname, String bio);
    boolean exists(String name, String surname);
}
