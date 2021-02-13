package com.epam.web.model.service.impl;

import com.epam.web.util.PasswordCoder;
import com.epam.web.model.dao.UserDao;
import com.epam.web.model.dao.impl.UserDaoImpl;
import com.epam.web.model.entity.User;
import com.epam.web.model.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private final UserDao userDao = UserDaoImpl.getInstance();
    private final String ADMIN_PROPERTY_PATH = "admin.properties";

    public UserServiceImpl() {}

    @Override
    public List<User> findAll() {
        return UserDaoImpl.getInstance().findAll();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<User> login(String email, String password) {
//        if(!UserValidator.isEmailValid(email) || !UserValidator.isPasswordValid(password)) { todo
//            return Optional.empty();
//        }
        String passwordHash = PasswordCoder.code(password);
        return userDao.login(email, passwordHash);
    }

    @Override
    public boolean adminVerification(String email, String password) {
        Properties properties = new Properties();
        boolean result = false;
        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream(ADMIN_PROPERTY_PATH);
            properties.load(inputStream);
            String adminEmail = properties.getProperty("admin.email");
            String adminPassword = properties.getProperty("admin.password");
            result = email.equals(adminEmail) && password.equals(adminPassword);
            logger.debug("RESULT OF ADMIN LOGIN: " + result);
            inputStream.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean registration(String username, String age, String email, String password) {
//        if(!UserValidator.isUsernameValid(username) || !UserValidator.isAgeValid(age) todo
//                || !UserValidator.isEmailValid(email) || !UserValidator.isPasswordValid(password)) {
//            return false;
//        }
        String passwordHash = PasswordCoder.code(password);
        return userDao.registration(username, Integer.parseInt(age), email, passwordHash);
    }
}