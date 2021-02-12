package com.epam.web.model.dao;

import com.epam.web.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends BaseDao<User> {
    Optional<User> login(String email, String passwordHash);
    boolean registration(String username, int age, String email, String passwordHash);
}