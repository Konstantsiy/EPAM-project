package com.epam.web.controller.command;

import com.epam.web.controller.command.impl.*;

public enum CommandType {
    LOGIN(new LoginCommand(false)),
    LOGOUT(new LogoutCommand()),
    REGISTRATION(new RegistrationCommand()),

    ADMIN_LOGIN(new LoginCommand(true)),
    ADMIN_ADD_AUTHOR(new AddAuthorCommand()),
    ADMIN_ADD_GENRE(new AddGenreCommand()),

    VIEW_ALL_AUTHORS(new ViewAuthorsCommand()),
    VIEW_ALL_USERS(new ViewUsersCommand()),
    VIEW_ALL_GENRES(new ViewGenresCommand()),

    CHECK_GENRE(new CheckGenreCommand());
//    VIEW_ALL_PUBLISHERS();

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}