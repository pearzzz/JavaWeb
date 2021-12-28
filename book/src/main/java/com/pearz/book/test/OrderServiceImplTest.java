package com.pearz.book.test;

import com.pearz.book.pojo.Cart;
import com.pearz.book.pojo.CartItem;
import com.pearz.book.service.OrderService;
import com.pearz.book.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.zip.DeflaterOutputStream;

import static org.junit.Assert.*;

/**
 * @author pearz
 */
public class OrderServiceImplTest {

    @Test
    public void createOrder() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "Java学习", 2, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(1, "Java学习", 1, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(2, "JavaWeb学习", 3, BigDecimal.valueOf(57.6)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println(orderService.createOrder(cart, 1));
    }
}