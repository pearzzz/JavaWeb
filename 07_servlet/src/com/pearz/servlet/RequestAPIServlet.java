package com.pearz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        i. getRequestURI() 获取请求的资源路径
        System.out.println("URI ==> " + req.getRequestURI());
//        ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("URL ==> " + req.getRequestURL());
//        iii. getRemoteHost() 获取客户端的ip 地址
        /* 在IDEA 中，使用localhost 访问时，得到的客户端ip 地址是===>>> 127.0.0.1(ipv4) 0:0:0:0:0:0:0:1(ipv6)<br/>
           在IDEA 中，使用127.0.0.1 访问时，得到的客户端ip 地址是===>>> 127.0.0.1(ipv4) 0:0:0:0:0:0:0:1(ipv6)<br/>
           在IDEA 中，使用真实ip 访问时，得到的客户端ip 地址是===>>> 真实的客户端ip 地址<br/> */
        System.out.println("ip ==> " + req.getRemoteHost());
//        iv. getHeader() 获取请求头
        System.out.println("请求头User-Agent ==> " + req.getHeader("User-Agent"));
//        vii. getMethod() 获取请求的方式GET 或POST
        System.out.println("请求的方式 ==> " + req.getMethod());
    }
}
