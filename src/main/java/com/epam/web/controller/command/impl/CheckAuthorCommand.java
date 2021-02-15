package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CheckAuthorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(CheckAuthorCommand.class);
    private final AuthorService authorService;

    public CheckAuthorCommand() {
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(RequestParam.AUTHOR_NAME);
        String surname = request.getParameter(RequestParam.AUTHOR_SURNAME);
        boolean exists = authorService.exists(name, surname);
        return exists ? "Unavailable" : "Available";
    }
}
