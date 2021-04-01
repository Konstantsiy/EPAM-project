package com.epam.web.model.entity;

import java.util.Arrays;
import java.util.List;

public enum Genre2 {
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

    Genre2(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    public static List<Genre2> getStuff() {
        return Arrays.asList(Genre2.values());
    }
    @Override
    public String toString() {
        return title;
    }
}