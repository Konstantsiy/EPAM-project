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
import java.util.ArrayList;
import java.util.List;

public class SearchByCategoryCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SearchByCategoryCommand.class);
    private final BookService bookService;
    private final AuthorService authorService;

    public SearchByCategoryCommand() {
        this.bookService = new BookServiceImpl();
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.BOOK_LIST;
        String category = request.getParameter(RequestParam.CATEGORY);
        List<Book> books = new ArrayList<>();
        if(category.equals("author")) {
            int id = Integer.parseInt(request.getParameter(RequestParam.ID));
            books = bookService.findByAuthorId(id);
            logger.info("Get books by authors");
        } else if(category.equals("genre")) {
            String genreTitle = request.getParameter(RequestParam.GENRE_TITLE);
            books = bookService.findByGenre(genreTitle);
            logger.info("Get books by genres");
        }
        request.setAttribute("books", books);
        List<Author> authors = authorService.findAll();
        request.setAttribute("authors", authors);
        return page;
    }
}
