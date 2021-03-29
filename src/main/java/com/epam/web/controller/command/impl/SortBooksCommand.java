//package com.epam.web.controller.command.impl;
//
//import com.epam.web.controller.command.Command;
//import com.epam.web.controller.command.PagePath;
//import com.epam.web.model.entity.Book;
//import com.epam.web.model.service.BookService;
//import com.epam.web.model.service.impl.BookServiceImpl;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//public class SortBooksCommand implements Command {
//    private final BookService bookService;
//
//    public SortBooksCommand() {
//        this.bookService = new BookServiceImpl();
//    }
//
//    @Override
//    public String execute(HttpServletRequest request) {
//        String page = PagePath.BOOK_LIST;
//        List<Book> books = request.getPa
//    }
//}
