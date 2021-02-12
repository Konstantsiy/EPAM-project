package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.service.GenreService;
import com.epam.web.model.service.impl.GenreServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CheckGenreCommand implements Command {
    private static final Logger logger = LogManager.getLogger(CheckGenreCommand.class);
    private final GenreService genreService;

    public CheckGenreCommand() {
        this.genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String title_eng = request.getParameter(RequestParam.GENRE_TITLE_ENG);
        boolean exist = genreService.exists(title_eng);
        String result = exist ? "Unavailable" : "Available";
        return result;
    }
}
