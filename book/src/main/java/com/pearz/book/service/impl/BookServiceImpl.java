package com.pearz.book.service.impl;

import com.pearz.book.dao.BookDao;
import com.pearz.book.dao.impl.BookDaoImpl;
import com.pearz.book.pojo.Book;
import com.pearz.book.pojo.Page;
import com.pearz.book.service.BookService;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:39 2021/12/18
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public Book queryBookById(int id) {
        return bookDao.queryBookById(id);
    }

    public List<Book> queryBook() {
        return bookDao.queryBook();
    }

    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        //设置每页显示数量
        page.setPageSize(pageSize);

        //设置总记录数量
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        //设置总页数
        int pageTotal = (pageTotalCount / pageSize) + ((pageTotalCount % pageSize == 0) ? 0 : 1);
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> books = bookDao.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(books);

        return page;
    }

    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        //设置每页显示数量
        page.setPageSize(pageSize);

        //设置总记录数量
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);

        //设置总页数
        int pageTotal = (pageTotalCount / pageSize) + ((pageTotalCount % pageSize == 0) ? 0 : 1);
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> books = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        //设置当前页数据
        page.setItems(books);

        return page;
    }
}
