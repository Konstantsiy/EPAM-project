package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.User;
import com.epam.web.model.service.UserService;
import com.epam.web.model.service.impl.UserServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    private final String PARAM_EMAIL = "email";
    private final String PARAM_PASSWORD = "password";
    private final UserService userService;
    boolean isAdmin;

    public LoginCommand(boolean isAdmin) {
        userService = new UserServiceImpl();
        this.isAdmin = isAdmin;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page;

        String emailValue = request.getParameter(PARAM_EMAIL);
        String passwordValue = request.getParameter(PARAM_PASSWORD);

//        HttpSession session = request.getSession();
        if(isAdmin) {
            logger.debug("user try login as admin");
            if(!userService.adminVerification(emailValue, passwordValue)) {
                logger.error("user is not an admin");
                return PagePath.HOME; // if user authenticated yet
            }
        }

        Optional<User> userOptional = userService.login(emailValue, passwordValue);

        if(userOptional.isPresent()) {
            User user = userOptional.get();
            request.setAttribute("username", user.getUsername());
            if(isAdmin) {
                List<User> existUsers = userService.findAllUsers();
                request.setAttribute("users", existUsers);
            }
            page = isAdmin ? PagePath.ADMIN_HOME : PagePath.HOME;
        } else {
            logger.error("there are no such user in database");
            page = PagePath.LOGIN;
        }
        return page;
    }
}