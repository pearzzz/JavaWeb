package com.pearz.book.web;

import com.pearz.book.pojo.Cart;
import com.pearz.book.pojo.User;
import com.pearz.book.service.OrderService;
import com.pearz.book.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 12:03 2021/12/28
 */
public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    public void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }

        String orderId = orderService.createOrder(cart, user.getId());

        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
