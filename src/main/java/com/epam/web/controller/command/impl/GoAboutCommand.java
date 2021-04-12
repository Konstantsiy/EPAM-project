package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class GoAboutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.ABOUT;
    }
}
