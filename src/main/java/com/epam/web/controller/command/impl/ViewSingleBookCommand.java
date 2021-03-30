package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Book;
import com.epam.web.model.entity.BookWithAuthorBio;
import com.epam.web.model.service.BookService;
import com.epam.web.model.service.impl.BookServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class ViewSingleBookCommand implements Command {
    private final BookService bookService;

    public ViewSingleBookCommand() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.SINGLE_BOOK;
        int id = Integer.parseInt(request.getParameter(RequestParam.ID));
        BookWithAuthorBio bookWithAuthorBio = bookService.findById_(id);
        request.setAttribute("book", bookWithAuthorBio.getBook());
        request.setAttribute("authorBio", bookWithAuthorBio.getBio());
        return page;
    }
}
