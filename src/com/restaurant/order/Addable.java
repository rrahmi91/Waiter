package com.restaurant.order;

import com.restaurant.menu.Product;
import com.restaurant.order.Order;

public interface Addable {
    Order addProduct(Order order, Product product);

    Order removeProduct(Order order,Product product);

}
