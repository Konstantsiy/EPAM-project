package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Book;
import com.epam.web.model.fabric.BookFabric;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;

public class AddBookCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddBookCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_BOOKS;

        String title = request.getParameter(RequestParam.BOOK_TITLE);
        String authorId = request.getParameter(RequestParam.BOOK_AUTHOR_ID);
        String genre1Id = request.getParameter(RequestParam.BOOK_GENRE1_ID);
        String genre2Id = request.getParameter(RequestParam.BOOK_GENRE2_ID);
        String genre3Id = request.getParameter(RequestParam.BOOK_GENRE3_ID);
        String cover = request.getParameter(RequestParam.BOOK_COVER);
        String year = request.getParameter(RequestParam.BOOK_PUBLISHING_YEAR);
        String size = request.getParameter(RequestParam.BOOK_SIZE);
        String price = request.getParameter(RequestParam.BOOK_PRICE);
        String desc = request.getParameter(RequestParam.BOOK_DESCRIPTION);

        Part filePart;
        try {
            filePart = request.getPart(RequestParam.BOOK_IMAGE);
        } catch (ServletException | IOException e) {
            logger.error(e.getMessage());
        }

        return null;




    }
}
