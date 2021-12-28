package com.pearz.book.dao.impl;

import com.pearz.book.dao.OrderItemDao;
import com.pearz.book.pojo.OrderItem;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:15 2021/12/28
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(id,name,count,price,total_price,order_id) value(?,?,?,?,?,?)";
        return update(sql, null, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(),
                orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
