package com.restaurant.user;

import com.restaurant.order.Changeable;
import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;

public class Cook extends User implements Changeable {
    public Cook(String userName, String password, UserType role) {
        super(userName, password, role);
    }

    public Cook() {
        super();
    }

    @Override
    public Order changeOrderStatus(Order order, int selection) {
        switch (selection) {
            case 1 -> order.setStatus(OrderStatus.COOKED);
            case 2 -> order.setStatus(OrderStatus.BEING_COOKED);
            default -> System.out.println("Избрахте невалиден статус");
        }
        return order;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
