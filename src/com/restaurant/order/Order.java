package com.restaurant.order;

public class Order {
    private String waiterUserName;
    private String createData;
    private String finishData;
    private double totalPrice;
    private OrderStatus status;

    public Order(String waiterUserName, String createData, String finishData, double totalPrice, OrderStatus status) {
        this.waiterUserName = waiterUserName;
        this.createData = createData;
        this.finishData = finishData;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    public  Order() {

    }
}
