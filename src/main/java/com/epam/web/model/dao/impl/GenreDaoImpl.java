package com.epam.web.model.dao.impl;

import com.epam.web.model.dao.ClosableDao;
import com.epam.web.model.dao.GenreDao;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl extends ClosableDao implements GenreDao {
    private static final Logger logger = LogManager.getLogger(GenreDaoImpl.class);
    private static final GenreDao instance = new GenreDaoImpl();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final String ADD_GENRE = "INSERT INTO genres (title) values (?)";
    private final String FIND_ALL_GENRES = "SELECT * FROM genres";
    private final String CHECK_GENRE = "SELECT * FROM genres WHERE ? = genres.title";
    private final String DELETE_GENRE = "DELETE FROM genres WHERE ? = genres.id";

    private GenreDaoImpl() {}

    public static GenreDao getInstance() {
        return instance;
    }

    @Override
    public boolean exists(String title) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(CHECK_GENRE);
            statement.setString(1, title);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                result = true;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return result;
    }

    @Override
    public boolean add(String title) {
        logger.debug("adding genre in dao...");
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(ADD_GENRE);
            statement.setString(1, title);
            result = (statement.executeUpdate() == 1);
            logger.debug("Genre " + title + " was added now");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
        return result;
    }

    @Override
    public List<Genre> convertResultSetToList(ResultSet resultSet) {
        List<Genre> genres = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                Genre genre = new Genre(id, title);
//                logger.debug("Genre form db: " + genre);
                genres.add(genre);
            }
        } catch (SQLException e) {
            logger.debug(e.getMessage());
        }
        return genres;
    }

    @Override
    public Genre convertResultSetToEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public Genre findById(int id) {
        return null;
    }

    @Override
    public List<Genre> findAll() {
        logger.debug("Getting all genres...");
        List<Genre> genres = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_ALL_GENRES);
            logger.debug("getting result statement...");
            resultSet = statement.executeQuery();
           genres = convertResultSetToList(resultSet);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return genres;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(DELETE_GENRE);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
    }
}
