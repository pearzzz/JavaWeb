package com.pearz.book.test;

import com.pearz.book.dao.BookDao;
import com.pearz.book.dao.impl.BookDaoImpl;
import com.pearz.book.pojo.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "好好学习", 99.99, "pearz", 9999, 666, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(23, "好好学习", 66.99, "pearz", 16666, 888, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(17));
    }

    @Test
    public void queryBook() {
        List<Book> books = bookDao.queryBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> books = bookDao.queryForPageItems(4, 4);
        for (Book book : books) {
            System.out.println();
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10, 50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        List<Book> books = bookDao.queryForPageItems(4, 4);
        for (Book book : books) {
            System.out.println();
            System.out.println(book);
        }
    }
}