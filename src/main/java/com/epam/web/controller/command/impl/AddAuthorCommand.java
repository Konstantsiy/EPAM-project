package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Author;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public class AddAuthorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddAuthorCommand.class);
    private final AuthorService authorService;

    public AddAuthorCommand() {
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_AUTHORS;

        String name = request.getParameter(RequestParam.AUTHOR_NAME);
        String surname = request.getParameter(RequestParam.AUTHOR_SURNAME);
        String bio = request.getParameter(RequestParam.AUTHOR_BIOGRAPHY);

        Part filePart;
        try {
            filePart = request.getPart(RequestParam.AUTHOR_IMAGE);
        } catch (IOException | ServletException e) {
            logger.error(e.getMessage());
            return page;
        }

        logger.debug("Params form jsp: " + name + " " + surname);
        if(authorService.add(filePart, name, surname, bio)) {
            logger.debug("Added new author: " + name + " " + surname);
            List<Author> existAuthors = authorService.findAll();
            request.setAttribute("authors", existAuthors);
        } else {
            logger.debug("This author is already exists");
        }
        return page;
    }
}
