package com.pearz1.hellohervlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author pearz
 */
public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet3的get请求");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet3的post请求");
    }
}
