package com.epam.web.controller.filter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class SessionLocaleFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(SessionLocaleFilter.class);

    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        if (req.getParameter("sessionLocale") != null) {
//            req.getSession(true).setAttribute("locale", req.getParameter("sessionLocale"));
//            logger.info("change locale " + "session ID: " + req.getSession().getId());
//        } else {
//            logger.info("init locale");
//            req.getSession(true).setAttribute("locale", "en");
//        }
//        chain.doFilter(request, response);
    }

    public void destroy() {}
}
