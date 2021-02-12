package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.Genre;
import com.epam.web.model.service.GenreService;
import com.epam.web.model.service.impl.GenreServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewGenresCommand implements Command {
    private final GenreService genreService;

    public ViewGenresCommand() {
        this.genreService = new GenreServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_GENRES;
        List<Genre> existGenres = genreService.findAll();
        request.setAttribute("genres", existGenres);
        return page;
    }
}
