package com.restaurant.order;

import com.restaurant.menu.Product;

public interface Addable {
    Order addProduct(Order order, Product product);

    Order removeProduct(Order order,Product product);

}
