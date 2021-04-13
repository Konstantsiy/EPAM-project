package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.Author;
import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.entity.Genre2;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.BookService;
import com.epam.web.model.service.GenreService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import com.epam.web.model.service.impl.BookServiceImpl;
import com.epam.web.model.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoHomeCommand implements Command {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public GoHomeCommand() {
        this.bookService = new BookServiceImpl();
        this.authorService = new AuthorServiceImpl();
        this.genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.HOME;
        List<Book> newestBooks = bookService.findLastThreeBooks();
//        List<Book> forChildren = bookService.findBooksByChildren();
        List<Author> authors = authorService.findAll();
        List<Genre> genres = genreService.findAll();
        request.setAttribute("books", newestBooks);
//        request.setAttribute("books1", forChildren);
        request.setAttribute("authors", authors);
        request.setAttribute("genres", genres);
        return page;
    }
}
