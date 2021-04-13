package com.epam.web.model.dao;

import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.BookWithAuthorBio;
import com.epam.web.model.entity.SearchParam;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public interface BookDao extends BaseDao<Book>  {
    boolean add(Book book, Part imagePart);
    boolean exists(String title);
    BookWithAuthorBio findById_(int id);
    List<Book> findByAuthorId(int authorId);
    List<Book> findByGenreId(int id);
    List<Book> findByYears(int from, int to);
    List<Book> findByAuthorIdGenreYears(int authorId, String genreTitle, int from, int to);
    List<Book> findLastThreeBooks();
    List<Book> findBooksForChildren();
}
