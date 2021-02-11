package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddBookCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddBookCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
