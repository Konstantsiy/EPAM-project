package com.epam.web.model.entity;

import java.util.List;

public class Book extends BaseEntity {
    private String title;
    private int authorId;
    private List<Genre> genres;
    private int size;
    private String image;
    private Cover cover;
    private double price;
    private int year;
    private String description;

    public Book() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCover() {
        return cover.getTitle();
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return size == book.size &&
                year == book.year &&
                Double.compare(book.price, price) == 0 &&
                title != null && title.equals(book.title) &&
                authorId == book.authorId &&
                genres.equals(book.genres) &&
                cover == book.cover;
    }

    @Override
    public int hashCode() {
        int result = 31 * 17;
        result += 31 * 17 + title.hashCode();
        result += 31 * 17 + Integer.hashCode(size);
        result += 31 * 17 + Integer.hashCode(year);
        result += 31 * 17 + Integer.hashCode(authorId);
        result += 31 * 17 + genres.hashCode();
        result += 31 * 17 + Double.hashCode(price);
        return result;
    }

    public static class Builder {
        private final Book newBook;

        public Builder() {
            newBook = new Book();
        }

        public Builder withId(int id) {
            newBook.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            newBook.title = title;
            return this;
        }

        public Builder withSize(int size) {
            newBook.size = size;
            return this;
        }

        public Builder withPrice(double price) {
            newBook.price = price;
            return this;
        }

        public Builder withYear(int year) {
            newBook.year = year;
            return this;
        }

        public Builder withImage(String image) {
            newBook.image = image;
            return this;
        }

        public Builder withAuthorId(int authorId) {
            newBook.authorId = authorId;
            return this;
        }

        public Builder withCover(Cover cover) {
            newBook.cover = cover;
            return this;
        }

        public Builder withDesc(String desc) {
            newBook.description = desc;
            return this;
        }

        public Book build() {
            return newBook;
        }
    }
}
