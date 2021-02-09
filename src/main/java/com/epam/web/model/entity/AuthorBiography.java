package com.epam.web.model.entity;


public class AuthorBiography {
    String biography;

    public AuthorBiography(String biography) {
        this.biography = biography;
    }

    public String getBiography() {
        return biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorBiography that = (AuthorBiography) o;
        return biography != null && biography.equals(that.biography);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + biography.hashCode();
    }
}
