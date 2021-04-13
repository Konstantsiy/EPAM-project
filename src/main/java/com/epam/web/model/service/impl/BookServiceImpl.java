package com.epam.web.model.service.impl;

import com.epam.web.model.dao.BookDao;
import com.epam.web.model.dao.impl.BookDaoImpl;
import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.BookWithAuthorBio;
import com.epam.web.model.service.BookService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.util.Collections;
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
    public List<Book> findByAuthorId(int id) {
        return bookDao.findByAuthorId(id);
    }

    @Override
    public List<Book> findByGenreId(int id) {
        return bookDao.findByGenreId(id);
    }

    @Override
    public List<Book> findByYears(int from, int to) {
        return bookDao.findByYears(from, to);
    }

    @Override
    public List<Book> sortByYears(List<Book> books, boolean isAscOrder) {
        if(isAscOrder) {
            Collections.sort(books);
        } else {
            books.sort(Collections.reverseOrder());
        }
        return books;
    }

    @Override
    public List<Book> findLastThreeBooks() {
        return bookDao.findLastThreeBooks();
    }

    @Override
    public BookWithAuthorBio findById_(int id) {
        return bookDao.findById_(id);
    }

    @Override
    public List<Book> findBooksByChildren() {
        return bookDao.findBooksForChildren();
    }
}
