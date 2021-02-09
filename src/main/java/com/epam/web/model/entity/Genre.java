package com.epam.web.model.entity;


public class Genre {
    private String title;

    public Genre() {}

    public Genre(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return title != null && title.equals(genre.title);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + title.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder("Genre{").append( "title=").append(title).append("}").toString();
    }
}
