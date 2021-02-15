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

public class DeletePublisherCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DeletePublisherCommand.class);
    private final PublisherService publisherService;

    public DeletePublisherCommand() {
        this.publisherService = new PublisherServiceImpl();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = PagePath.ADMIN_PUBLISHERS;
        String id = request.getParameter(RequestParam.ID);
        publisherService.delete(Integer.parseInt(id));
        List<Publisher> existPublishers = publisherService.findAll();
        request.setAttribute("publishers", existPublishers);
        return page;
    }
}
