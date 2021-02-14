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

public class DeleteAuthorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeleteGenreCommand.class);
    private final AuthorService authorService;

    public DeleteAuthorCommand() {
        this.authorService = new AuthorServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_AUTHORS;
        String id = request.getParameter(RequestParam.ID);
        authorService.delete(Integer.parseInt(id));
        List<Author> existAuthors = authorService.findAll();
        request.setAttribute("authors", existAuthors);
        return page;
    }
}
