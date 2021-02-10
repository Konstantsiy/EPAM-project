package com.epam.web.controller;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandProvider;
import com.epam.web.controller.command.PagePath;
import com.epam.web.controller.command.RequestParam;
import com.epam.web.model.entity.Author;
import com.epam.web.model.service.AuthorService;
import com.epam.web.model.service.impl.AuthorServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 16177215)
public class FileUploadController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(FileUploadController.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Command>  optionalCommand = CommandProvider.defineCommand(request.getParameter(RequestParam.COMMAND));

        Command command = optionalCommand.get();
        String page = command.execute(request);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
//        --------------


//        String name = request.getParameter(RequestParam.AUTHOR_NAME);
//        String surname = request.getParameter(RequestParam.AUTHOR_SURNAME);
//        InputStream inputStream = null;
//
//        Part filePart = request.getPart(RequestParam.AUTHOR_IMAGE);
//        if (filePart != null) {
//            logger.debug(filePart.getName());
//            logger.debug(filePart.getSize());
//            logger.debug(filePart.getContentType());
//            inputStream = filePart.getInputStream();
//            AuthorService authorService = new AuthorServiceImpl();
//            if(authorService.add(inputStream, name, surname)) {
//                List<Author> existAuthors = authorService.findAll();
//                request.setAttribute("authors", existAuthors);
//            }
//        }
//
//        getServletContext().getRequestDispatcher(PagePath.ADMIN_HOME).forward(request, response);
    }
}
