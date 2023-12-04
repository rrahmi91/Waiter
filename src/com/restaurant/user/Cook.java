package com.restaurant.user;

public class Cook extends User implements Changeable {
    public Cook(String userName, String password, UserType role) {
        super(userName, password, role);
    }

    public Cook() {
        super();
    }

    @Override
    public void changeOrderStatus(String status) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
