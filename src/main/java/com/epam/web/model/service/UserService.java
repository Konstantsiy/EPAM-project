package com.epam.web.model.service;

import com.epam.web.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> login(String email, String password);
    boolean registration(String username, String age, String email, String password);
    List<User> findAll();
    boolean adminVerification(String email, String password);
}