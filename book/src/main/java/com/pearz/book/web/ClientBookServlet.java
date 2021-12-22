package com.pearz.book.web;

import com.pearz.book.pojo.Book;
import com.pearz.book.pojo.Page;
import com.pearz.book.service.BookService;
import com.pearz.book.service.impl.BookServiceImpl;
import com.pearz.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:31 2021/12/21
 */
public class ClientBookServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用bookService.page(pageNo, pageSize)获取page对象
        Page<Book> page = bookService.page(pageNo, pageSize);

        page.setUrl("client/bookServlet?action=page");

        //3、保存page对象到Request域
        req.setAttribute("page", page);
        //4、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    public void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        //2、调用bookService.page(pageNo, pageSize)获取page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());

        //3、保存page对象到Request域
        req.setAttribute("page", page);
        //4、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
