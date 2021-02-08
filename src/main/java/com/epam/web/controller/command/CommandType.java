package com.epam.web.controller.command;

import com.epam.web.controller.command.impl.LoginCommand;
import com.epam.web.controller.command.impl.LogoutCommand;
import com.epam.web.controller.command.impl.RegistrationCommand;

public enum CommandType {
    LOGIN(new LoginCommand(false)),
    LOGOUT(new LogoutCommand()),
    REGISTRATION(new RegistrationCommand()),

    ADMIN_LOGIN(new LoginCommand(true));

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}