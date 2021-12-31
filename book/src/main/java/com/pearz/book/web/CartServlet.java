package com.pearz.book.web;

import com.google.gson.Gson;
import com.pearz.book.pojo.Book;
import com.pearz.book.pojo.Cart;
import com.pearz.book.pojo.CartItem;
import com.pearz.book.service.BookService;
import com.pearz.book.service.impl.BookServiceImpl;
import com.pearz.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 20:15 2021/12/25
 */
public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.updateCount(id, count);
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * TODO 清空购物车
     * @param req
     * @param resp
     * @return: void
    */
    protected void clearItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * TODO 购物车删除商品
     * @param req
     * @param resp
     * @return: void
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * TODO 加入购物车
     * @param req
     * @param resp
     * @return: void
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, BigDecimal.valueOf(book.getPrice()));
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName", book.getName());

        // 重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * TODO 加入购物车
     * @param req
     * @param resp
     * @return: void
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, BigDecimal.valueOf(book.getPrice()));
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName", book.getName());

        Map<String, Object> resultMap = new HashMap<String, Object>();

        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastname", cartItem.getName());

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);
    }
}
