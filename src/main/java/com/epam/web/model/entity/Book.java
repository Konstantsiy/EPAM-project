package com.epam.web.model.entity;

import java.util.List;

public class Book extends BaseEntity {
    private String title;
    private Author author;
    private List<Genre> genres;
    private int size;
    private Cover cover;
    private double price;
    private Publisher publisher;
    private int year;

//    public Book() {}

    public Book(int id, String title, Author author, List<Genre> genres, int size, double price, Cover cover, Publisher publisher, int year) {
        super(id);
        this.title = title;
        this.author = author;
        this.genres = genres;
        this.size = size;
        this.price = price;
        this.cover = cover;
        this.publisher = publisher;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
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

    public Cover getCover() {
        return cover;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
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
                author != null && author.equals(book.author) &&
                genres.equals(book.genres) &&
                cover == book.cover &&
                publisher != null && publisher.equals(book.publisher);
    }

    @Override
    public int hashCode() {
        int result = 31 * 17;
        result += 31 * 17 + title.hashCode();
        result += 31 * 17 + Integer.hashCode(size);
        result += 31 * 17 + Integer.hashCode(year);
        result += 31 * 17 + author.hashCode();
        result += 31 * 17 + genres.hashCode();
        result += 31 * 17 + Double.hashCode(price);
        result += 31 * 17 + publisher.hashCode();
        return result;
    }
}
