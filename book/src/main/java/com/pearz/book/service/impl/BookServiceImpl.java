package com.pearz.book.service.impl;

import com.pearz.book.dao.BookDao;
import com.pearz.book.dao.impl.BookDaoImpl;
import com.pearz.book.pojo.Book;
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
}
