package com.pearz.book.service;

import com.pearz.book.pojo.Book;
import com.pearz.book.pojo.Page;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:37 2021/12/18
 */
public interface BookService {
    /**
     * TODO 添加书
     * @param book 书
     */
    public void addBook(Book book);

    /**
     * TODO 删除书
     * @param id id
     */
    public void deleteBookById(int id);

    /**
     * TODO 修改书籍信息
     * @param book 书
     */
    public void updateBook(Book book);

    /**
     * TODO 通过id查询书籍信息
     * @param id id
     * @return: com.pearz.book.pojo.Book 返回书籍信息
     */
    public Book queryBookById(int id);

    /**
     * TODO 查询所有书籍信息
     * @return: java.util.List<com.pearz.book.pojo.Book> 返回所有书组成的list列表
     */
    public List<Book> queryBook();

    /**
     * TODO 查询当前page
     * @param pageNo
     * @param pageSize
     * @return: com.pearz.book.pojo.Page<com.pearz.book.pojo.Book>
    */
    public Page<Book> page(int pageNo, int pageSize);

    /**
     * TODO 按价格查询当前page
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return: com.pearz.book.pojo.Page<com.pearz.book.pojo.Book>
    */
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
