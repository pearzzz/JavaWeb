package com.pearz.book.service.impl;

import com.pearz.book.dao.BookDao;
import com.pearz.book.dao.OrderDao;
import com.pearz.book.dao.OrderItemDao;
import com.pearz.book.dao.impl.BookDaoImpl;
import com.pearz.book.dao.impl.OrderDaoImpl;
import com.pearz.book.dao.impl.OrderItemDaoImpl;
import com.pearz.book.pojo.*;
import com.pearz.book.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:58 2021/12/28
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    public String createOrder(Cart cart, int userId) {

        String orderId = System.currentTimeMillis() + userId + "";
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> cartItemEntry : cart.getItems().entrySet()) {
            CartItem cartItem = cartItemEntry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(),
                    cartItem.getPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            //更新销量和库存
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;
    }
}
