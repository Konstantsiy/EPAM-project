package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Author;
import com.epam.web.model.entity.Book;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.BookService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import com.epam.web.model.service.impl.BookServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteBookCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeleteGenreCommand.class);
    private final BookService bookService;
    private final AuthorService authorService;

    public DeleteBookCommand() {
        this.bookService = new BookServiceImpl();
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_BOOKS;
        String id = request.getParameter(RequestParam.ID);
        bookService.delete(Integer.parseInt(id));
        List<Book> existBooks = bookService.findAll();
        List<Author> existAuthors = authorService.findAll();
        request.setAttribute("books", existBooks);
        request.setAttribute("authors", existAuthors);
        return page;
    }
}
