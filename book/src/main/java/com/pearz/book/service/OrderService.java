package com.pearz.book.service;

import com.pearz.book.pojo.Cart;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:56 2021/12/28
 */
public interface OrderService {

    /**
     * TODO 创建订单
     * @param cart 购物车
     * @param userId 用户id
     * @return: String 返回订单号
    */
    public String createOrder(Cart cart, int userId);
}
