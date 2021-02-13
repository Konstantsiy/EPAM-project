package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.service.GenreService;
import com.epam.web.model.service.impl.GenreServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CheckGenreCommand implements Command {
    private static final Logger logger = LogManager.getLogger(CheckGenreCommand.class);
    private final GenreService genreService;

    private final String ENGLISH = "eng";

    public CheckGenreCommand() {
        this.genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String title = request.getParameter(RequestParam.GENRE_TITLE);
        String lang = request.getParameter(RequestParam.LANG);
        boolean isEng = lang.equals(ENGLISH);
        boolean exist = genreService.exists(title, isEng);
        String result = exist ? "Unavailable" : "Available";
        return result;
    }
}
