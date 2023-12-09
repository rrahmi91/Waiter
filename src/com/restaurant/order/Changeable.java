package com.restaurant.order;

public interface Changeable {
    Order changeOrderStatus(Order order, int selection);
}
