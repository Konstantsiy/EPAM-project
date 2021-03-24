package com.epam.web.model.dao;

import com.epam.web.model.entity.Book;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public interface BookDao extends BaseDao<Book>  {
    boolean add(Book book, Part imagePart);
    boolean exists(String title);
}
