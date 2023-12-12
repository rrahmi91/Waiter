package com.restaurant.order;

import com.restaurant.menu.MenuItem.Base.MenuItem;

import java.util.List;

public interface Addable {
    Order addProduct(Order order, List<MenuItem> menuItems,int indexProduct);

    Order removeProduct(Order order, List<Product>products);

}
