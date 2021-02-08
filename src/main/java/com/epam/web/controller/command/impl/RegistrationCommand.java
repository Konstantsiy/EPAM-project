package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.dao.impl.UserDaoImpl;
import com.epam.web.model.entity.User;
import com.epam.web.model.service.UserService;
import com.epam.web.model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RegistrationCommand implements Command {
    private final String PARAM_USERNAME = "username";
    private final String PARAM_AGE = "age";
    private final String PARAM_EMAIL = "email";
    private final String PARAM_PASSWORD = "password";
    private UserService userService;

    public RegistrationCommand() {
        userService = new UserServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.LOGIN;

        String usernameValue = request.getParameter(PARAM_USERNAME);
        String ageValue = request.getParameter(PARAM_AGE);
        String emailValue = request.getParameter(PARAM_EMAIL);
        String passwordValue = request.getParameter(PARAM_PASSWORD);

        if(!userService.registration(usernameValue, ageValue, emailValue, passwordValue)) {
            request.setAttribute("errorRegistrationPassMessage","This user is already registered");
        }

        List<User> users = UserDaoImpl.getInstance().findAll();
        request.setAttribute("users", users);
        page = PagePath.HOME;

        return page;
    }
}