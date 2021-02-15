package com.epam.web.controller.command.impl;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.PagePath;
import com.epam.web.model.entity.Publisher;
import com.epam.web.model.service.PublisherService;
import com.epam.web.model.service.impl.PublisherServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewPublishersCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ViewPublishersCommand.class);
    private final PublisherService publisherService;

    public ViewPublishersCommand() {
        this.publisherService = new PublisherServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_PUBLISHERS;
        List<Publisher> existPublishers = publisherService.findAll();
        request.setAttribute("publishers", existPublishers);
        return page;
    }
}
