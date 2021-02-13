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

    private final String ADD_GENRE = "INSERT INTO genres (title_eng, title_rus) values (?, ?)";
    private final String FIND_ALL_GENRES = "SELECT * FROM genres";
    private final String CHECK_GENRE_ENG = "SELECT id FROM genres WHERE ? = genres.title_eng";
    private final String CHECK_GENRE_RUS = "SELECT id FROM genres WHERE ? = genres.title_rus";
    private final String CHECK_GENRE_ENG_RUS = "SELECT * FROM genres WHERE ? = genres.title_eng AND ? = genres.title_rus";
    private final String DELETE_GENRE = "DELETE FROM genres WHERE ? = genres.id";

    private GenreDaoImpl() {}

    public static GenreDao getInstance() {
        return instance;
    }

    @Override
    public boolean exists(String title, boolean isEng) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            connection = connectionPool.getConnection();
            if(isEng) {
                statement = connection.prepareStatement(CHECK_GENRE_ENG);
            } else {
                statement = connection.prepareStatement(CHECK_GENRE_RUS);
            }
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
    public boolean exists(String titleEng, String titleRus) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(CHECK_GENRE_ENG_RUS);
            statement.setString(1, titleEng);
            statement.setString(2, titleRus);
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
    public boolean add(String title_eng, String title_rus) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(ADD_GENRE);
            statement.setString(1, title_eng);
            statement.setString(2, title_rus);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
        return result == 1;
    }

    @Override
    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_ALL_GENRES);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String titleEng = resultSet.getString(2);
                String titleRus = resultSet.getString(3);
                Genre genre = new Genre(id, titleEng, titleRus);
                genres.add(genre);
            }
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
