//package com.epam.web.controller.command.impl;
//
//import com.epam.web.controller.command.Command;
//import com.epam.web.controller.command.PagePath;
//import com.epam.web.controller.command.RequestParam;
//import com.epam.web.model.entity.Author;
//import com.epam.web.model.entity.Book;
//import com.epam.web.model.service.AuthorService;
//import com.epam.web.model.service.BookService;
//import com.epam.web.model.service.impl.AuthorServiceImpl;
//import com.epam.web.model.service.impl.BookServiceImpl;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//import java.util.Objects;
//
//public class SearchBooksCommand implements Command {
//    private final BookService bookService;
//    private final AuthorService authorService;
//
//    public SearchBooksCommand() {
//        this.bookService = new BookServiceImpl();
//        this.authorService = new AuthorServiceImpl();
//    }
//
//    @Override
//    public String execute(HttpServletRequest request) {
//        String page = PagePath.BOOK_LIST;
//        String searchGenre = request.getParameter(RequestParam.SEARCH_GENRE);
//        String searchAuthorId = request.getParameter(RequestParam.SEARCH_AUTHOR_ID);
//        String searchFrom = request.getParameter(RequestParam.SEARCH_FROM);
//        String searchTo = request.getParameter(RequestParam.SEARCH_TO);
//
//        request.setAttribute("books", Objects.requireNonNullElseGet(neededBooks, List::of));
//        List<Author> authors = authorService.findAll();
//        request.setAttribute("authors", authors);
//        return page;
//    }
//}
