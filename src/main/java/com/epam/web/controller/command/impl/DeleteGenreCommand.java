package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Genre1;
import com.epam.web.model.service.GenreService;
import com.epam.web.model.service.impl.GenreServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DeleteGenreCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeleteGenreCommand.class);
    private final GenreService genreService;

    public DeleteGenreCommand() {
        this.genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_GENRES;
        String id = request.getParameter(RequestParam.ID);
        logger.debug("Deleting genre with id " + id + "...");
        genreService.delete(Integer.parseInt(id));
        logger.debug("Genre was deleted");
        List<Genre1> existGenres = genreService.findAll();
        request.setAttribute("genres", existGenres);
        return page;
    }
}
