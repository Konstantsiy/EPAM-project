package com.epam.web.model.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ClosableDao {
    private static final Logger logger = LogManager.getLogger(ClosableDao.class);

    public void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection);
        close(statement);
        close(resultSet);
    }

    public void close(Connection connection, Statement statement) {
        close(connection);
        close(statement);
    }

    public void close(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void close(Statement statement) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void close(ResultSet resultSet) {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
