package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {

    public LogoutCommand() {}

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.INDEX;
//        request.getSession().invalidate();a
        return page;
    }
}