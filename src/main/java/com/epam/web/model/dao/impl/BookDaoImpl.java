package com.epam.web.model.dao.impl;

import com.epam.web.model.dao.BookDao;
import com.epam.web.model.dao.ClosableDao;
import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.Cover;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.pool.ConnectionPool;
import com.epam.web.util.TypeConverter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends ClosableDao implements BookDao {
    private static final Logger logger = LogManager.getLogger(BookDaoImpl.class);

    private static final BookDao instance = new BookDaoImpl();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String ADD_BOOK = "INSERT INTO books (title, size, price, p_year, image, genre, cover, description, author_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CHECK_BOOK = "SELECT * FROM books WHERE ? = books.title";
    private static final String FIND_ALL_BOOKS = "SELECT * FROM books";
    private static final String FIND_BY_ID = "SELECT * FROM books WHERE ? = books.id";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE ? = books.id";

    private BookDaoImpl() {}

    public static BookDao getInstance() {
        return instance;
    }

    @Override
    public boolean add(Book book, Part imagePart) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(ADD_BOOK);
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getSize());
            statement.setDouble(3, book.getPrice());
            statement.setInt(4, book.getYear());
            statement.setBlob(5, imagePart.getInputStream());
            statement.setInt(6, book.getAuthorId());
            statement.setString(7, book.getCover());
            statement.setString(8, book.getDescription());
            result = statement.executeUpdate();
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, null);
        }
        return result == 1;
    }

    @Override
    public boolean exists(String title) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(CHECK_BOOK);
            statement.setString(1, title);
            resultSet = statement.executeQuery();
            result = resultSet.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return result;
    }

    @Override
    public List<Book> convertResultSetToList(ResultSet resultSet) {
        List<Book> books = new ArrayList<>();
        try {
            while(resultSet.next()) {
                books.add(convertResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return books;
    }

    @Override
    public Book convertResultSetToEntity(ResultSet resultSet) {
        Book book = null;
        try {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            int size = resultSet.getInt(3);
            double price = resultSet.getDouble(4);
            int year = resultSet.getInt(5);
            Blob blob = resultSet.getBlob(6);

            String base64Image = TypeConverter.blobToString(blob);

            int authorId = resultSet.getByte(7);
            Cover cover = Cover.valueOf(resultSet.getString(8));
            String desc = resultSet.getString(9);
            Genre genre = Genre.valueOf(resultSet.getString(10));
            book = new Book.Builder()
                    .withId(id)
                    .withTitle(title)
                    .withSize(size)
                    .withPrice(price)
                    .withYear(year)
                    .withImage(base64Image)
                    .withAuthorId(authorId)
                    .withCover(cover)
                    .withDesc(desc)
                    .withGenre(genre)
                    .build();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return book;
    }

    @Override
    public Book findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Book neededBook = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_BY_ID);
            resultSet = statement.executeQuery();
            neededBook = convertResultSetToEntity(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return neededBook;
    }

    @Override
    public List<Book> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_ALL_BOOKS);
            resultSet = statement.executeQuery();
            books = convertResultSetToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return books;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(DELETE_BOOK);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
    }
}
