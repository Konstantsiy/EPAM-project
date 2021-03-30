package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.Author;
import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.BookService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import com.epam.web.model.service.impl.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoHomeCommand implements Command {
    private final BookService bookService;
    private final AuthorService authorService;

    public GoHomeCommand() {
        this.bookService = new BookServiceImpl();
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.HOME;
        List<Book> newestBooks = bookService.findLastThreeBooks();
        List<Author> authors = authorService.findAll();
        request.setAttribute("books", newestBooks);
        request.setAttribute("authors", authors);
        request.setAttribute("genres", Genre.getStuff());
        return page;
    }
}
