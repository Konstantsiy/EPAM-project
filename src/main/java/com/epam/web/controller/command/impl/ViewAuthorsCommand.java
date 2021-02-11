package com.epam.web.controller.command.impl;


import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.Author;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.impl.AuthorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewAuthorsCommand implements Command {
    private final AuthorService authorService;

    public ViewAuthorsCommand() {
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_AUTHORS;
        List<Author> existAuthors = authorService.findAll();
        request.setAttribute("authors", existAuthors);
        return page;
    }
}
