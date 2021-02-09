package com.epam.web.model.entity;

public enum Cover {
    HARD ("Hard cover"),
    SOFT ("Soft cover"),
    STAPLING ("Stapling cover"),
    FRENCH ("French cover"),
    TYPOGRAPHIC ("Typographic cover"),
    THERMAL ("Thermal cover");

    private final String title;

    Cover(String s) {
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
