package com.epam.web.model.entity;


public class Genre1 extends BaseEntity {
    private String title;

    public Genre1(int id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre1 genre = (Genre1) o;
        return title != null && title.equals(genre.title);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + title.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder("Genre{").append( "titleEng=").append(title).append("}").toString();
    }
}
