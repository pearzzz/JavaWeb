package com.pearz.book.web;

import com.pearz.book.pojo.Book;
import com.pearz.book.service.BookService;
import com.pearz.book.service.impl.BookServiceImpl;
import com.pearz.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:59 2021/12/18
 */
public class BookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、获取请求的参数封装成Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3、跳转到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、获取请求的参数id，图书编程
        int id = Integer.parseInt(req.getParameter("id"));
        //2、调用bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        //3、重定向回图书列表管理页面/book/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数图书编号
        int id = Integer.parseInt(req.getParameter("id"));
        //2、调用bookService.queryBookById()查询图书
        Book book = bookService.queryBookById(id);
        //3、保存图书到Request域中
        req.setAttribute("book", book);
        //4、请求转发到/pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1、获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、调用BookService.updateBook(book)修改图书
        bookService.updateBook(book);
        //3、重定向回图书列表管理页面 地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、通过BookService查询全部图书
        List<Book> books = bookService.queryBook();
        //2、把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
