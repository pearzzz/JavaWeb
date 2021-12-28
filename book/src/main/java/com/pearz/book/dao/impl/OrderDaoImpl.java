package com.pearz.book.dao.impl;

import com.pearz.book.dao.OrderDao;
import com.pearz.book.pojo.Order;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:02 2021/12/28
 */
public class OrderDaoImpl extends BaseDao implements OrderDao{

    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) value(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
