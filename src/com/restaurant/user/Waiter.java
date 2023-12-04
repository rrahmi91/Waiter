package com.restaurant.user;
import com.restaurant.order.Addable;
import com.restaurant.order.Changeable;
import com.restaurant.order.Order;
import static com.restaurant.DateTimeRaider.getCurrentDateTime;

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

    public Order createOrder() {
        String currentDataAndTimeCreatedOrder = getCurrentDateTime();
        Order order = new Order(getUserName(),currentDataAndTimeCreatedOrder,"finishData",0.0, null);
        return order;
    }

    public void finishOrder() {

    }

    @Override
    public void addProduct() {


    }

    @Override
    public void removeProduct() {

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
