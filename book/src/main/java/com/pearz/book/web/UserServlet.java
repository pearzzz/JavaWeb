package com.pearz.book.web;

import com.google.gson.Gson;
import com.pearz.book.pojo.User;
import com.pearz.book.service.UserService;
import com.pearz.book.service.impl.UserServiceImpl;
import com.pearz.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 20:08 2021/12/16
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void loginout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、销毁Session中用户登陆的信息/销毁Session
        req.getSession().invalidate();
        //2、重定向到首页
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用userService.login()登录处理业务
        User user = userService.login(new User(null, username, password, null));
        //如果等于null，说明登录失败
        if (user == null) {
            //把错误信息，和回显的表单项信息，保存到request域中
            req.setAttribute("msg", "用户名或密码不正确");
            req.setAttribute("username", username);
            //跳回登陆页面
            System.out.println("用户名或密码不正确，登陆失败");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登陆成功
            req.getSession().setAttribute("user", user);
            //跳转登陆成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    protected void ajaxExitsUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");

        boolean existsUsername = userService.existsUsername(username);

        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("existsUsername", existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(hashMap);

        resp.getWriter().write(json);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //2、删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        req.setAttribute("username", username);
        req.setAttribute("email", email);

        //2、检查 验证码是否正确  === 写死,要求验证码为:bnbnp
        if (token != null && token.equalsIgnoreCase(code)) {
            //3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                req.setAttribute("msg", "用户名已存在");
                System.out.println("用户名[" + username + "]已存在!");
                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //可用
                //调用Sservice保存到数据库
                userService.registUser(new User(null, username, password, email));

                //跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("msg", "验证码错误");

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
