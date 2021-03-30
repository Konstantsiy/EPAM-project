package com.epam.web.model.entity;

public class BookWithAuthorBio {
    private Book book;
    private String bio;

    public BookWithAuthorBio(Book book, String bio) {
        this.book = book;
        this.bio = bio;
    }

    public Book getBook() {
        return book;
    }

    public String getBio() {
        return bio;
    }
}
