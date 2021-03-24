package com.epam.web.model.entity;

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

    @Override
    public String toString() {
        return title;
    }
}