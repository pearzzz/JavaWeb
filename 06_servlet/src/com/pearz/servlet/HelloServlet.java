package com.pearz.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1.构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.init");

        //ServletConfig的作用：
        //1.可以获取Servlet程序的别名servlet-name的值
        System.out.println("servlet的别名是：" + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("servlet的初始化参数为：" + servletConfig.getInitParameter("username"));
        //3.获取ServletContext的对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.Hello Servlet被访问了");

        //HttpServletRequest是ServletRequest的子类，有getMethod()方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String method = httpServletRequest.getMethod();

        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }
    }

    /*
    * 做get请求的方法
    * */
    public void doGet() {
        System.out.println("post请求");
        System.out.println("post请求");
    }

    public void doPost() {
        System.out.println("get请求");
        System.out.println("get请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.destroy方法");
    }
}
