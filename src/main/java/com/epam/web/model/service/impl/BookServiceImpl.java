package com.epam.web.model.service.impl;

import com.epam.web.model.dao.BookDao;
import com.epam.web.model.dao.impl.BookDaoImpl;
import com.epam.web.model.entity.Book;
import com.epam.web.model.service.BookService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);
    private final BookDao bookDao = BookDaoImpl.getInstance();

    public BookServiceImpl() {}

    @Override
    public boolean add(Book book, Part imagePart) {
        return bookDao.add(book, imagePart);
    }

    @Override
    public boolean exists(String title) {
        return bookDao.exists(title);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public void delete(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> findBy(String... params) {
        if(!params[0].isEmpty() && !params[1].isEmpty() && !params[2].isEmpty() && !params[3].isEmpty()) {
            return bookDao.findByAuthorIdGenreYears(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), Integer.parseInt(params[3]));
        }
        if(!params[0].isEmpty() && params[1].isEmpty() && params[2].isEmpty() && params[3].isEmpty()) {
            return bookDao.findByAuthorId(Integer.parseInt(params[0]));
        }
        if(params[0].isEmpty() && !params[1].isEmpty() && params[2].isEmpty() && params[3].isEmpty()) {
            return bookDao.findByGenre(params[1]);
        }
        if(params[0].isEmpty() && params[1].isEmpty() && !params[2].isEmpty() && !params[3].isEmpty()) {
            return bookDao.findByYears(Integer.parseInt(params[2]), Integer.parseInt(params[3]));
        }
        return null;
    }
}
