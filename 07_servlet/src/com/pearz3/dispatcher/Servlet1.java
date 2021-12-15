package com.pearz3.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pearz
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("在servlet1中查看username：" + username);

        req.setAttribute("key", "value");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        requestDispatcher.forward(req, resp);
    }
}
