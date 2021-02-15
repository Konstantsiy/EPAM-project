package com.epam.web.controller;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandProvider;
import com.epam.web.controller.command.RequestParam;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/check")
public class CheckingController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(CheckingController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<Command> optionalCommand = CommandProvider.defineCommand(request.getParameter(RequestParam.COMMAND));
        Command command = optionalCommand.get();
        logger.debug("checking...");
        String result = command.execute(request);
        logger.info("result of checking: " + result);
        response.getWriter().write(result);
//        logger.debug("checking...");
//        String result = "Gghsghfgsdhfsdhf";
//        OutputStream outStream = response.getOutputStream();
//        outStream.write(result.getBytes(StandardCharsets.UTF_8));
//        outStream.flush();
//        outStream.close();
    }
}
