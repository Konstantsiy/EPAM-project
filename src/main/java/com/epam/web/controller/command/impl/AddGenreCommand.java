package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.service.GenreService;
import com.epam.web.model.service.impl.GenreServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddGenreCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddGenreCommand.class);
    private final GenreService genreService;

    public AddGenreCommand() {
        this.genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_GENRES;

        String title = request.getParameter(RequestParam.GENRE_TITLE);

        if(genreService.add(title)) {
            logger.debug("Added new genre: " + title + " (" + title + ")");
            List<Genre> existGenres = genreService.findAll();
            request.setAttribute("genres", existGenres);
        } else {
            logger.debug("This genre is already exists");
        }
        return page;

    }
}
