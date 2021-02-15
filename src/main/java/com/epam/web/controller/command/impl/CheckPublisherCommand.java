package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.service.PublisherService;
import com.epam.web.model.service.impl.PublisherServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class CheckPublisherCommand  implements Command {
    private static final Logger logger = LogManager.getLogger(CheckPublisherCommand.class);
    private final PublisherService publisherService;

    public CheckPublisherCommand() {
        this.publisherService = new PublisherServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_PUBLISHERS;
        String publisherTitle = request.getParameter(RequestParam.PUBLISHER_TITLE);
        boolean exist = publisherService.exists(publisherTitle);
        return exist ? "Unavailable" : "Available";
    }
}
