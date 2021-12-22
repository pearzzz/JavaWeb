package com.pearz.book.dao.impl;

import com.pearz.book.dao.BookDao;
import com.pearz.book.dao.UserDao;
import com.pearz.book.pojo.Book;
import com.pearz.book.pojo.User;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 17:23 2021/12/17
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    public int addBook(Book book) {
        String sql = "insert into t_book(name,price,author,sales,stock,img_path)values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath());
    }

    public int deleteBookById(int id) {
        String sql = "delete from t_book where id=?";
        return update(sql, id);
    }

    public int updateBook(Book book) {
        String sql = "update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    public Book queryBookById(int id) {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    public List<Book> queryBook() {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath from t_book";
        return queryForList(Book.class, sql);
    }

    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath from t_book limit ?,?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }

    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select id,name,price,author,sales,stock,img_path imgPath from t_book" +
                " where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }
}
