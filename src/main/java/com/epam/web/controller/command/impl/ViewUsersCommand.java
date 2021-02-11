package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.User;
import com.epam.web.model.service.UserService;
import com.epam.web.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewUsersCommand implements Command {
    private final UserService userService;

    public ViewUsersCommand() {
        this.userService = new UserServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_USERS;
        List<User> existUsers = userService.findAll();
        request.setAttribute("users", existUsers);
        return page;
    }
}
