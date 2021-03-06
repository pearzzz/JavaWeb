package com.pearz.book.dao;

import com.pearz.book.pojo.Book;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 17:12 2021/12/17
 */
public interface BookDao {
    /**
     * TODO 添加书
     * @param book 书
     * @return: int 返回0代表添加失败，返回其他代表影响的行数
    */
    public int addBook(Book book);

    /**
     * TODO 删除书
     * @param id id
     * @return: int 返回0代表添加失败，返回其他代表影响的行数
    */
    public int deleteBookById(int id);

    /**
     * TODO 修改书籍信息
     * @param book 书
     * @return: int 返回0代表添加失败，返回其他代表影响的行数
    */
    public int updateBook(Book book);

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
     * TODO 查询共多少条书籍信息
     * @param
     * @return: java.lang.Integer
    */
    public Integer queryForPageTotalCount();

    /**
     * TODO 查询当前页的书籍信息
     * @param begin
     * @param pageSize
     * @return: java.util.List<com.pearz.book.pojo.Book>
    */
    public List<Book> queryForPageItems(int begin, int pageSize);

    /**
     * TODO 按价格查询共多少条书籍信息
     * @param min
     * @param max
     * @return: java.lang.Integer
    */
    public Integer queryForPageTotalCountByPrice(int min, int max);

    /**
     * TODO 按价格查询当前页的书籍信息
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return: java.util.List<com.pearz.book.pojo.Book>
    */
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
