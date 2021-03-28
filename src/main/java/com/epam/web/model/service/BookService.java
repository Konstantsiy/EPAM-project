package com.epam.web.model.service;

import com.epam.web.model.entity.Book;

import javax.servlet.http.Part;
import java.sql.SQLException;
import java.util.List;

public interface BookService extends BaseService<Book> {
    boolean add(Book book, Part imagePart);
    boolean exists(String title);
    List<Book> findBy(String... params);

}
