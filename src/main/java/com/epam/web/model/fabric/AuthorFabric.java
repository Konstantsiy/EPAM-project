package com.epam.web.model.fabric;

import com.epam.web.model.entity.Author;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;


public class AuthorFabric {
    private static final Logger logger = LogManager.getLogger(AuthorFabric.class);

    public static Author createAuthor(String id, String name, String surname, String image) {
            return new Author(Integer.parseInt(id), name, surname, image);
    }

    public static Author createAuthor(String id) {
        return new Author(Integer.parseInt(id), "", "", "");
    }

    public static Author createAuthor(String id, String name, String surname) {
        return new Author(Integer.parseInt(id), name, surname, "");
    }

    public static Author createAuthor(int id, String name, String surname) {
        return new Author(id, name, surname, "");
    }
}
