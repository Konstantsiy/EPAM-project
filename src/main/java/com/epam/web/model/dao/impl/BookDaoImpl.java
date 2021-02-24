package com.epam.web.model.dao.impl;

import com.epam.web.model.dao.BookDao;
import com.epam.web.model.dao.ClosableDao;
import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.Cover;
import com.epam.web.model.pool.ConnectionPool;
import com.epam.web.util.TypeConverter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends ClosableDao implements BookDao {
    private static final Logger logger = LogManager.getLogger(BookDaoImpl.class);

    private static final BookDao instance = new BookDaoImpl();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final StringBuilder ADD_BOOK = new StringBuilder()
        .append("INSERT INTO books ")
        .append("(title, size, price, p_year, image, author_id, cover, description) ")
        .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    private static final String SET_BOOK_GENRE_LINK = "INSERT INTO books_genres (genre_id, book_id) VALUES (?, ?)";
    private static final String FIND_ALL_BOOKS = "SELECT * FROM books";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE ? = books.id";

    private BookDaoImpl() {}

    public static BookDao getInstance() {
        return instance;
    }

    @Override
    public boolean add(String title, int size, double price, int year, InputStream image,
                       int authorId, List<Integer> genresId, String cover, String desc) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean result = true;
        try {
            connection = connectionPool.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(ADD_BOOK.toString(), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, title);
            statement.setInt(2, size);
            statement.setDouble(3, price);
            statement.setInt(4, year);
            statement.setBlob(5, image);
            statement.setInt(6, authorId);
            statement.setString(7, cover);
            statement.setString(8, desc);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            int bookId = 0;
            if(resultSet.next()) {
                bookId = resultSet.getInt(1);
            } else {
                result = false;
            }
            for(int i = 0; i < genresId.size(); i++) {
                statement = connection.prepareStatement(SET_BOOK_GENRE_LINK);
                statement.setInt(1, i);
                statement.setInt(2, bookId);
                statement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            result = false;
            try {
                connection.rollback();
            } catch (SQLException throwable) {
                logger.error(throwable.getMessage()); // todo
            }
        } finally {
            if(connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
            close(connection, statement, resultSet);
        }
        return result;
    }

    @Override
    public boolean exists(String title) {
        return false;
    }

    @Override
    public List<Book> convertResultSetToList(ResultSet resultSet) {
        List<Book> books = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                int size = resultSet.getInt(3);
                double price = resultSet.getDouble(4);
                int year = resultSet.getInt(5);
                Blob blob = resultSet.getBlob(6);
                String base64Image = TypeConverter.blobToString(blob);
                int authorId = resultSet.getByte(7);
                String cover = resultSet.getString(8);
                Cover bookCover = Cover.valueOf(cover);
                String desc = resultSet.getString(9);
                Book book = new Book.Builder()
                        .withId(id)
                        .withTitle(title)
                        .withSize(size)
                        .withPrice(price)
                        .withYear(year)
                        .withImage(base64Image)
                        .withAuthorId(authorId)
                        .withCover(bookCover)
                        .withDesc(desc)
                        .build();
                books.add(book);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return books;
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
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
    }
}
