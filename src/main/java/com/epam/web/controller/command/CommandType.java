package com.epam.web.controller.command;

import com.epam.web.controller.command.impl.*;

public enum CommandType {
    LOGIN(new LoginCommand(false)),
    LOGOUT(new LogoutCommand()),
    REGISTRATION(new RegistrationCommand()),

    ADMIN_LOGIN(new LoginCommand(true)),
    ADD_AUTHOR(new AddAuthorCommand()),
    ADD_GENRE(new AddGenreCommand()),
    ADD_BOOK(new AddBookCommand()),

    VIEW_ALL_AUTHORS(new ViewAuthorsCommand()),
    VIEW_ALL_USERS(new ViewUsersCommand()),
    VIEW_ALL_GENRES(new ViewGenresCommand()),
    VIEW_ALL_BOOKS(new ViewBooksCommand()),

    DELETE_GENRE(new DeleteGenreCommand()),
    DELETE_AUTHOR(new DeleteAuthorCommand()),

    CHECK_GENRE(new CheckGenreCommand()),
    CHECK_AUTHOR(new CheckAuthorCommand());

    private final Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}