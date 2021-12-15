package com.pearz2.servletcontext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author pearz
 */
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        //1、获取web.xml 中配置的上下文参数context-param
        System.out.println("context-param的参数name的值为：" + context.getInitParameter("name"));
        System.out.println("context-param的参数password的值为：" + context.getInitParameter("password"));
        //2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前的工程路径为:" + context.getContextPath());
        //3、获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署后在服务器硬盘上的绝对路径为:" + context.getRealPath("/"));
        //4、像Map 一样存取数据
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
