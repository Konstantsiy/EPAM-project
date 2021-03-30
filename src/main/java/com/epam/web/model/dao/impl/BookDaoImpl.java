package com.epam.web.model.dao.impl;

import com.epam.web.model.dao.BookDao;
import com.epam.web.model.dao.ClosableDao;
import com.epam.web.model.entity.*;
import com.epam.web.model.fabric.AuthorFabric;
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

    private static final String ADD_BOOK = "INSERT INTO books (title, size, price, p_year, image, author_id, cover, description, genre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String CHECK_BOOK = "SELECT * FROM books WHERE ? = books.title";
    private static final String FIND_ALL_BOOKS = "SELECT * FROM books";

    private static final String FIND_BOOK_WITH_AUTHOR_BY_AUTHOR_ID = new StringBuilder()
            .append("SELECT books.id, books.title, books.size, books.price, books.p_year, books.image, books.author_id, books.cover, books.description, books.genre, authors.id, authors.name, authors.surname ")
            .append("FROM books JOIN authors ")
            .append("ON ? = books.author_id AND books.author_id = authors.id").toString();

    private static final String FIND_BOOK_WITH_AUTHOR_BY_GENRE = new StringBuilder()
            .append("SELECT books.id, books.title, books.size, books.price, books.p_year, books.image, books.author_id, books.cover, books.description, books.genre, authors.id, authors.name, authors.surname ")
            .append("FROM books JOIN authors ")
            .append("ON ? = books.genre AND books.author_id = authors.id").toString();

    private static final String FIND_ALL_BOOKS_WITH_AUTHORS = new StringBuilder()
            .append("SELECT books.id, books.title, books.size, books.price, books.p_year, books.image, books.author_id, books.cover, books.description, books.genre, authors.id, authors.name, authors.surname ")
            .append("FROM books JOIN authors ")
            .append("ON books.author_id = authors.id").toString();

    private static final String FIND_BOOK_BY_ID = new StringBuilder()
            .append("SELECT books.id, books.title, books.size, books.price, books.p_year, books.image, books.author_id, books.cover, books.description, books.genre, authors.id, authors.name, authors.surname, authors.bio, authors.image ")
            .append("FROM books JOIN authors ")
            .append("ON ? = books.id AND books.author_id = authors.id").toString();

    private static final String DELETE_BOOK = "DELETE FROM books WHERE ? = books.id";
    private static final String FIND_BY_YEARS = "SELECT * FROM books WHERE books.p_year > ? AND books.p_year < ?";
    private static final String FIND_BY_AUTHOR_GENRE_YEARS = "SELECT * FROM books WHERE ? = books.author_id AND ? = books.genre AND books.p_year > ? AND books.p_year < ?";
    private static final String FIND_LAST_THREE_BOOKS = "SELECT books.id, books.title, books.price, books.image FROM books ORDER BY books.id DESC LIMIT 3";


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
            statement.setInt(6, book.getAuthor().getId());
            statement.setString(7, book.getCover().getTitle());
            statement.setString(8, book.getDesc());
            statement.setString(9, book.getGenre().getTitle());
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
    public List<Book> findByAuthorId(int authorId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> neededBooks = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_BOOK_WITH_AUTHOR_BY_AUTHOR_ID);
            statement.setInt(1, authorId);
            resultSet = statement.executeQuery();
            neededBooks = convertResultSetToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return neededBooks;
    }

    @Override
    public List<Book> findByGenre(String genreTitle) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> neededBooks = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_BOOK_WITH_AUTHOR_BY_GENRE);
            statement.setString(1, genreTitle);
            resultSet = statement.executeQuery();
            neededBooks = convertResultSetToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return neededBooks;
    }

    @Override
    public List<Book> findByYears(int from, int to) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> neededBooks = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_BY_YEARS);
            statement.setInt(1, from);
            statement.setInt(2, to);
            resultSet = statement.executeQuery();
            neededBooks = convertResultSetToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return neededBooks;
    }

    @Override
    public List<Book> findByAuthorIdGenreYears(int authorId, String genreTitle, int from, int to) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> neededBooks = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_BY_AUTHOR_GENRE_YEARS);
            statement.setInt(1, authorId);
            statement.setString(2, genreTitle);
            statement.setInt(3, from);
            statement.setInt(4, to);
            resultSet = statement.executeQuery();
            neededBooks = convertResultSetToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return neededBooks;
    }

    @Override
    public List<Book> findLastThreeBooks() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_LAST_THREE_BOOKS);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                Blob image = resultSet.getBlob(4);
                String base64Image = TypeConverter.blobToString(image);
                Book book = new Book.Builder()
                        .withId(id)
                        .withTitle(title)
                        .withImage(base64Image)
                        .withPrice(price)
                        .build();
                books.add(book);
            }
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return books;
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
            Cover cover = Cover.valueOf(resultSet.getString(8).toUpperCase());
            String desc = resultSet.getString(9);
            Genre genre = Genre.valueOf(resultSet.getString(10).toUpperCase());

            int _authorId = resultSet.getInt(11);
            String authorName = resultSet.getString(12);
            String authorSurname = resultSet.getString(13);

            Author author = AuthorFabric.createAuthor(_authorId, authorName, authorSurname);

            book = new Book.Builder()
                    .withId(id)
                    .withTitle(title)
                    .withSize(size)
                    .withPrice(price)
                    .withYear(year)
                    .withImage(base64Image)
                    .withAuthor(author)
                    .withCover(cover)
                    .withDesc(desc)
                    .withGenre(genre)
                    .build();
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage());
        }
        return book;
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public BookWithAuthorBio findById_(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        BookWithAuthorBio bookWithAuthorBio = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_BOOK_BY_ID);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                int bookId = resultSet.getInt(1);
                String bookTitle = resultSet.getString(2);
                int bookSize = resultSet.getInt(3);
                double bookPrice = resultSet.getDouble(4);
                int year = resultSet.getInt(5);
                Blob imageBlob = resultSet.getBlob(6);
                String base64Image = TypeConverter.blobToString(imageBlob);
                int authorId = resultSet.getInt(7);
                Cover cover = Cover.valueOf(resultSet.getString(8).toUpperCase());
                String desc = resultSet.getString(9);
                Genre genre = Genre.valueOf(resultSet.getString(10).toUpperCase());

                int author_id = resultSet.getInt(11);
                String name = resultSet.getString(12);
                String surname = resultSet.getString(13);
                String bio = resultSet.getString(14);
                Blob authorImageBlob = resultSet.getBlob(15);
                String authorImage = TypeConverter.blobToString(authorImageBlob);

                Author author = new Author(author_id, name, surname, authorImage);
                Book book = new Book.Builder()
                        .withId(bookId)
                        .withTitle(bookTitle)
                        .withPrice(bookPrice)
                        .withCover(cover)
                        .withSize(bookSize)
                        .withImage(base64Image)
                        .withDesc(desc)
                        .withYear(year)
                        .withAuthor(author)
                        .withGenre(genre)
                        .build();
                bookWithAuthorBio = new BookWithAuthorBio(book, bio);
            }
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return bookWithAuthorBio;
    }

    @Override
    public List<Book> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Book> books = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_ALL_BOOKS_WITH_AUTHORS);
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
