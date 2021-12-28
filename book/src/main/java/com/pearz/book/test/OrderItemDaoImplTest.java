package com.pearz.book.test;

import com.pearz.book.dao.OrderItemDao;
import com.pearz.book.dao.impl.OrderDaoImpl;
import com.pearz.book.dao.impl.OrderItemDaoImpl;
import com.pearz.book.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author pearz
 */
public class OrderItemDaoImplTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null, "Java编程思想", 2, new BigDecimal(33.3),
                "123456789"));
    }
}