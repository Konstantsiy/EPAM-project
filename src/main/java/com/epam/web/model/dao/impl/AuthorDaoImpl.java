package com.epam.web.model.dao.impl;

import com.epam.web.model.dao.AuthorDao;
import com.epam.web.model.dao.ClosableDao;
import com.epam.web.model.entity.Author;
import com.epam.web.model.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.Part;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class AuthorDaoImpl extends ClosableDao implements AuthorDao {
    private final Logger logger = LogManager.getLogger(AuthorDaoImpl.class);

    private static final AuthorDao instance = new AuthorDaoImpl();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final String ADD_BOOK = "INSERT INTO authors (image, name, surname) values (?, ?, ?)";
    private final String CHECK_AUTHOR = "SELECT EXISTS (SELECT id FROM authors WHERE ? = authors.name AND ? = authors.surname)";
    private final String FIND_ALL_AUTHORS = "SELECT * FROM authors";

    private AuthorDaoImpl() {}

    public static AuthorDao getInstance() {
        return instance;
    }

    @Override
    public boolean add(Part imagePart, String name, String surname) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(ADD_BOOK);

            InputStream image = imagePart.getInputStream();

            statement.setBlob(1, image);
            statement.setString(2, name);
            statement.setString(3, surname);

            result = statement.executeUpdate();
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
        return result == 1;
    }

//    @Override
//    public boolean add(File imageFile, String name, String surname) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        FileInputStream fis;
//        int result = 0;
//        try {
//            connection = connectionPool.getConnection();
//            statement = connection.prepareStatement(ADD_BOOK);
//            fis = new FileInputStream(imageFile);
//
//            statement.setBinaryStream(1, fis, (int)(imageFile.length()));
//            statement.setString(2, name);
//            statement.setString(3, surname);
//
//            result = statement.executeUpdate();
//            fis.close();
//        } catch (SQLException | IOException e) {
//            logger.error(e.getMessage());
//        } finally {
//            connectionPool.close(connection, statement, resultSet);
//        }
//        return result == 1;
//    }

    @Override
    public boolean exists(String name, String surname) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result = 0;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(CHECK_AUTHOR);

            statement.setString(1, name);
            statement.setString(2, surname);

            resultSet = statement.executeQuery();
            result = resultSet.getInt(1);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return result == 1;
    }

    private List<Author> convertResultSetToList(ResultSet resultSet) throws SQLException, IOException {
        List<Author> authors = new ArrayList<>();
        while(resultSet.next()) {
            Blob blob = resultSet.getBlob(2);
            String surname = resultSet.getString(3);
            String name = resultSet.getString(4);
            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = outputStream.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
            inputStream.close();
            outputStream.close();
            authors.add(new Author(name, surname, base64Image));
        }
        return authors;
    }

    @Override
    public List<Author> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Author> authors = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_ALL_AUTHORS);
            resultSet = statement.executeQuery();
            authors = convertResultSetToList(resultSet);
        } catch (SQLException | IOException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return authors;
    }
}
