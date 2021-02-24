package com.epam.web.model.service.impl;

import com.epam.web.model.dao.AuthorDao;
import com.epam.web.model.dao.BookDao;
import com.epam.web.model.dao.impl.AuthorDaoImpl;
import com.epam.web.model.dao.impl.BookDaoImpl;
import com.epam.web.model.entity.Book;
import com.epam.web.model.service.BookService;
import com.epam.web.model.validator.BookValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.util.List;

public class BookServiceImpl implements BookService {
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);
    private final BookDao bookDao = BookDaoImpl.getInstance();

    public BookServiceImpl() {}


    @Override
    public boolean add(String title, String size, String price, String year, Part imagePart,
                       String authorId, List<String> genresId, String cover, String desc) {
        return false;
    }

    @Override
    public boolean exists(String title) {
        return false;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
