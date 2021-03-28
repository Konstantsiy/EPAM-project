package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Author;
import com.epam.web.model.entity.Book;
import com.epam.web.model.fabric.AuthorFabric;
import com.epam.web.model.fabric.BookFabric;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.BookService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import com.epam.web.model.service.impl.BookServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AddBookCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddBookCommand.class);
    private final BookService bookService;
    private final AuthorService authorService;

    public AddBookCommand() {
        this.bookService = new BookServiceImpl();
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_BOOKS;

        String title = request.getParameter(RequestParam.BOOK_TITLE);
        String authorId = request.getParameter(RequestParam.BOOK_AUTHOR_ID);
        String genreTitle = request.getParameter(RequestParam.BOOK_GENRE);
        String cover = request.getParameter(RequestParam.BOOK_COVER);
        String year = request.getParameter(RequestParam.BOOK_PUBLISHING_YEAR);
        String size = request.getParameter(RequestParam.BOOK_SIZE);
        String price = request.getParameter(RequestParam.BOOK_PRICE);
        String desc = request.getParameter(RequestParam.BOOK_DESCRIPTION);

        Part imagePart = null;
        try {
            imagePart = request.getPart(RequestParam.BOOK_IMAGE);
        } catch (ServletException | IOException e) {
            logger.error(e.getMessage());
        }

        logger.debug("genre: " + genreTitle + "\t authorId: " + authorId);

        Author author = AuthorFabric.createAuthor(authorId);
        Optional<Book> bookOptional = BookFabric.createBook(title, price, author, genreTitle, cover, year, size, desc, "");

        logger.debug("book [" + title + "] was created");

        if(bookOptional.isPresent()) {
            if(bookService.add(bookOptional.get(), imagePart)) {
                logger.debug("Added new book: " + title);
                List<Book> existBooks = bookService.findAll();
                List<Author> existAuthors = authorService.findAll();
                request.setAttribute("books", existBooks);
                request.setAttribute("authors", existAuthors);
            }
        }
        return page;
    }
}
