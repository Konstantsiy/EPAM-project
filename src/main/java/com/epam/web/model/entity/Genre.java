package com.epam.web.model.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Genre {
    HORROR("horror"),
    ADVENTURE("adventure"),
    DETECTIVES("detectives"),
    FANTASY("fantasy"),
    PHILOSOPHY("philosophy"),
    EDUCATIONAL("educational"),
    CLASSIC("classic"),
    EROTIC("erotic"),
    CHILDREN("children");

    private final String title;

    Genre(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    public static List<Genre> getStuff() {
        return Arrays.asList(Genre.values());
    }
    @Override
    public String toString() {
        return title;
    }
}