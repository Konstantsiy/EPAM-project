package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.Author;
import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.BookService;
import com.epam.web.model.service.GenreService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import com.epam.web.model.service.impl.BookServiceImpl;
import com.epam.web.model.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewBooksCommand implements Command {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public ViewBooksCommand() {
        this.bookService = new BookServiceImpl();
        this.authorService = new AuthorServiceImpl();
        this.genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_BOOKS;
        List<Book> existBooks = bookService.findAll();
        List<Author> existAuthors = authorService.findAll();
        List<Genre> existGenres = genreService.findAll();
        request.setAttribute("books", existBooks);
        request.setAttribute("authors", existAuthors);
        request.setAttribute("genres", existGenres);
        return page;
    }
}
