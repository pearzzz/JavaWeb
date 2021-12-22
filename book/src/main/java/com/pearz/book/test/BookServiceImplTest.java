package com.pearz.book.test;

import com.pearz.book.pojo.Book;
import com.pearz.book.service.BookService;
import com.pearz.book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "天天向上", 99.99, "pearz", 9999, 666, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24, "好好学习", 66.66, "pearz", 9999, 666, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(6));
    }

    @Test
    public void queryBook() {
        List<Book> books = bookService.queryBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        System.out.println(bookService.page(3, 4));
    }
}