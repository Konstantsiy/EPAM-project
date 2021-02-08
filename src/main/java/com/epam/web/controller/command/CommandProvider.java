package com.epam.web.controller.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Optional;

public class CommandProvider {
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);

    public static Optional<Command> defineCommand(String commandName) {
        Optional<Command> current;
        if(commandName == null || commandName.isBlank()) {
            return Optional.empty();
        }
        logger.debug("command: " + commandName);
        try {
            CommandType type = CommandType.valueOf(commandName.toUpperCase());
            current = Optional.of(type.getCommand());
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            current = Optional.empty();
        }
        return current;
    }
}
