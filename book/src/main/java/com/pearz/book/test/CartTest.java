package com.pearz.book.test;

import com.pearz.book.pojo.Cart;
import com.pearz.book.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author pearz
 */
public class CartTest {

    Cart cart = new Cart();

    @Test
    public void addItem() {
        cart.addItem(new CartItem(1, "Java学习", 2, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(1, "Java学习", 1, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(2, "JavaWeb学习", 3, BigDecimal.valueOf(57.6)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(1, "Java学习", 2, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(1, "Java学习", 1, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(2, "JavaWeb学习", 3, BigDecimal.valueOf(57.6)));

        cart.deleteItem(2);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1, "Java学习", 2, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(1, "Java学习", 1, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(2, "JavaWeb学习", 3, BigDecimal.valueOf(57.6)));

        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1, "Java学习", 2, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(1, "Java学习", 1, BigDecimal.valueOf(66.6)));
        cart.addItem(new CartItem(2, "JavaWeb学习", 3, BigDecimal.valueOf(57.6)));

        cart.updateCount(1, 1);

        System.out.println(cart);
    }
}