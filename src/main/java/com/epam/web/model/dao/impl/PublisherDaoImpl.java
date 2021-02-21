package com.epam.web.model.dao.impl;

import com.epam.web.model.dao.ClosableDao;
import com.epam.web.model.dao.PublisherDao;
import com.epam.web.model.entity.Publisher;
import com.epam.web.model.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublisherDaoImpl extends ClosableDao implements PublisherDao {
    private static final Logger logger = LogManager.getLogger(GenreDaoImpl.class);
    private static final PublisherDao instance = new PublisherDaoImpl();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final String ADD_PUBLISHER = "INSERT INTO publishers (title) VALUES (?)";
    private final String CHECK_PUBLISHER = "SELECT * FROM publishers WHERE ? = publishers.title";
    private final String DELETE_PUBLISHER = "DELETE FROM publishers WHERE ? = publishers.id";
    private final String FIND_ALL_PUBLISHERS = "SELECT * FROM publishers";

    private PublisherDaoImpl() {}

    public static PublisherDao getInstance() {
        return instance;
    }

    @Override
    public boolean exists(String title) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(CHECK_PUBLISHER);
            statement.setString(1, title);
            result = statement.executeQuery().next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
        return result;
    }

    @Override
    public boolean add(String title) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(ADD_PUBLISHER);
            statement.setString(1, title);
            result = (statement.executeUpdate() == 1);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
        return result;
    }

    @Override
    public List<Publisher> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Publisher> publishers = new ArrayList<>();
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_ALL_PUBLISHERS);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                Publisher publisher = new Publisher(id, title);
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return publishers;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(DELETE_PUBLISHER);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement);
        }
    }

    @Override
    public List<Publisher> convertResultSetToList(ResultSet resultSet) {
        return null;
    }
}
