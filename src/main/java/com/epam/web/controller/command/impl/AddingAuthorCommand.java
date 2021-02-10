package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Author;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddingAuthorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddingAuthorCommand.class);
    private final AuthorService authorService;

    public AddingAuthorCommand() {
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_HOME;
        String image = request.getParameter(RequestParam.AUTHOR_IMAGE);
        String name = request.getParameter(RequestParam.AUTHOR_NAME);
        String surname = request.getParameter(RequestParam.AUTHOR_SURNAME);
        if(authorService.add(image, name, surname)) {
            logger.debug("Added new author: " + name + " " + surname);
            List<Author> existAuthors = authorService.findAll();
            request.setAttribute("authors", existAuthors);
        } else {
            logger.debug("This author is already exists");
        }
        return page;
    }
}
