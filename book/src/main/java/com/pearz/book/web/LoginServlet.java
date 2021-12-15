package com.pearz.book.web;

import com.pearz.book.pojo.User;
import com.pearz.book.service.UserService;
import com.pearz.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pearz
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用userService.login()登录处理业务
        User user = userService.login(new User(null, username, password, null));
        //如果等于null，说明登录失败
        if (user == null) {
            //跳回登陆页面
            System.out.println("用户名或密码不正确，登陆失败");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        } else {
            //登陆成功
            //跳转登陆成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }
    }
}
