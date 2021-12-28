package com.pearz.book.dao;

import com.pearz.book.pojo.OrderItem;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 9:57 2021/12/28
 */
public interface OrderItemDao {

    /**
     * TODO 保存订单项
     * @param orderItem
     * @return: int
    */
    public int saveOrderItem(OrderItem orderItem);
}
