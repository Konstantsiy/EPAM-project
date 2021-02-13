package com.epam.web.model.entity;


public class Genre extends BaseEntity {
    private String titleRus;
    private String titleEng;

//    public Genre() {}

    public Genre(int id, String titleEng, String titleRus) {
        super(id);
        this.titleRus = titleRus;
        this.titleEng = titleEng;
    }

    public String getTitleEng() {
        return titleEng;
    }

    public String getTitleRus() {
        return titleRus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return titleRus != null && titleRus.equals(genre.titleRus);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + titleRus.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder("Genre{").append( "titleEng=").append(titleEng)
                .append(", titleRus=").append(titleRus).append("}").toString();
    }
}
