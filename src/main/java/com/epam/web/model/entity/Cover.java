package com.epam.web.model.entity;

import java.util.Arrays;
import java.util.List;

public enum Cover {
    HARD ("Hard cover"),
    SOFT ("Soft cover"),
    FRENCH ("French cover"),
    TYPOGRAPHIC ("Typographic cover");

    private final String title;

    Cover(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    public static List<Cover> getStuff() {
        return Arrays.asList(Cover.values());
    }

    @Override
    public String toString() {
        return title;
    }
}
