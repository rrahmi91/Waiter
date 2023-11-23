package com.restaurant.user;

import com.restaurant.order.Order;

import java.util.ArrayList;

public class Waiter extends User implements Addable, Changeable {
    public Waiter(String userName, String password, UserType role) {
        super(userName, password, role);
    }

    public Waiter() {
        super();
    }

    @Override
    public void changeOrderStatus(String status) {

    }

    public void createOrder() {
    }

    public void finishOrder() {

    }

    @Override
    public void addProduct() {

    }

    @Override
    public void removeProduct() {
    }
}
