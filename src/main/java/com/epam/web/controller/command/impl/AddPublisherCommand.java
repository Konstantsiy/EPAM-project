package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Publisher;
import com.epam.web.model.service.PublisherService;
import com.epam.web.model.service.impl.PublisherServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AddPublisherCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddPublisherCommand.class);
    private final PublisherService publisherService;

    public AddPublisherCommand() {
        this.publisherService = new PublisherServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_PUBLISHERS;
        String title = request.getParameter(RequestParam.PUBLISHER_TITLE);
        if(publisherService.add(title)) {
            logger.debug("Publisher " + title + " was added");
            List<Publisher> existPublishers = publisherService.findAll();
            request.setAttribute("publishers", existPublishers);
        } else {
            logger.debug("Publisher " + title + " is already exists");
        }
        return page;
    }
}
