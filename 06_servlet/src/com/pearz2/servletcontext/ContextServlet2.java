package com.pearz2.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author pearz
 */
@WebServlet(name = "ContextServlet2", value = "/ContextServlet2")
public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        System.out.println("3:" + context.getAttribute("key"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
