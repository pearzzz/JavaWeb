package com.pearz.book.test;

import com.pearz.book.dao.OrderDao;
import com.pearz.book.dao.impl.OrderDaoImpl;
import com.pearz.book.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author pearz
 */
public class OrderDaoImplTest {

    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("123456789", new Date(), new BigDecimal(99.9), 0, 3));
    }
}