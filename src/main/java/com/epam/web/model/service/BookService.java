package com.epam.web.model.service;

import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.BookWithAuthorBio;

import javax.servlet.http.Part;
import java.sql.SQLException;
import java.util.List;

public interface BookService extends BaseService<Book> {
    boolean add(Book book, Part imagePart);
    boolean exists(String title);
    List<Book> findByAuthorId(int id);
    List<Book> findByGenre(String genreTitle);
    List<Book> findByYears(int from, int to);
    List<Book> sortByYears(List<Book> books, boolean isAscOrder);
    List<Book> findLastThreeBooks();
    BookWithAuthorBio findById_(int id);
}
