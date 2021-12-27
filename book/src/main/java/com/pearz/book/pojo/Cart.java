package com.pearz.book.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 购物车对象
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:21 2021/12/25
 */
public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());

        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCount(int id, int count) {
        CartItem item = items.get(id);

        if (item != null) {
            item.setCount(count);
        }
    }

    public Integer getTotalCount() {
        int totalCount = 0;
        for (Map.Entry<Integer, CartItem> itemEntry : items.entrySet()) {
            totalCount += itemEntry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        for (Map.Entry<Integer, CartItem> itemEntry : items.entrySet()) {
            totalPrice = totalPrice.add(itemEntry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
