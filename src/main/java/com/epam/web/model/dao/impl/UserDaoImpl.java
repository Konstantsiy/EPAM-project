package com.epam.web.model.dao.impl;

import com.epam.web.model.dao.ClosableDao;
import com.epam.web.model.dao.UserDao;
import com.epam.web.model.entity.User;
import com.epam.web.model.pool.ConnectionPool;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.datatransfer.ClipboardOwner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends ClosableDao implements UserDao {
    private final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    private static final UserDao instance = new UserDaoImpl();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private final String LOGIN = "SELECT * FROM users WHERE email = ? AND password_hash = ?";
    private final String REGISTRATION = "INSERT INTO users (username, age, email, password_hash) VALUES (?, ?, ?, ?)";
    private final String FIND_ALL_USERS = "SELECT * FROM users";
    private final String CHECK_EMAIL_AVAILABILITY = "SELECT * FROM users WHERE email = ?";

    private UserDaoImpl() {}

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public Optional<User> login(String email, String passwordHash) {
        Optional<User> userOptional = Optional.empty();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(LOGIN);
            statement.setString(1, email);
            statement.setString(2, passwordHash);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String userEmail = resultSet.getString(4);
                User user = new User(id, username, age, userEmail);
                userOptional = Optional.of(user);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return userOptional;
    }

    private boolean checkEmailAvailability(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(CHECK_EMAIL_AVAILABILITY);
            statement.setString(1, email);
            resultSet = statement.executeQuery();
            if(resultSet.next()) {
                logger.info("the user with a tick email is already registered");
                return false;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return true;
    }

    @Override
    public boolean registration(String username, int age, String email, String passwordHash) {
        if(checkEmailAvailability(email)) {
            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = connectionPool.getConnection();
                statement = connection.prepareStatement(REGISTRATION);
                statement.setString(1, username);
                statement.setInt(2, age);
                statement.setString(3, email);
                statement.setString(4, passwordHash);
                statement.executeUpdate();
                logger.info("new user in db: " + username);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
            finally {
                close(connection, statement);
            }
            return true;
        } else {
            logger.info("a user with this email already exists");
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = connectionPool.getConnection();
            statement = connection.prepareStatement(FIND_ALL_USERS);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String email = resultSet.getString(4);
                User user = new User(id, username, age, email);
                logger.debug("User form db: " + user);
                users.add(user);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            close(connection, statement, resultSet);
        }
        return users;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<User> convertResultSetToList(ResultSet resultSet) {
        return null;
    }

    @Override
    public User convertResultSetToEntity(ResultSet resultSet) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
