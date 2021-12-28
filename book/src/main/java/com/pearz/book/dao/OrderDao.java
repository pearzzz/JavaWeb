package com.pearz.book.dao;

import com.pearz.book.pojo.Order;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 9:56 2021/12/28
 */
public interface OrderDao {

    /**
     * TODO 保存订单
     * @param order
     * @return: int
    */
    public int saveOrder(Order order);
}
