package com.restaurant.order;

import com.restaurant.menu.MenuItem.Base.MenuItem;

import java.awt.*;
import java.util.List;

public class Order implements TotalPriceCalculatible{
    private String waiterUserName;
    private String orderCreateData;
    private String orderFinishData;
    private double totalPrice;
    private OrderStatus status;
    private List<MenuItem> orderProducts;


    public List<MenuItem> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<MenuItem> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Order(String waiterUserName, String orderCreateData, String orderFinishData, double totalPrice, OrderStatus status, List<MenuItem>orderProducts) {
        setWaiterUserName(waiterUserName);
        setOrderCreateData(orderCreateData);
        setOrderFinishData(orderFinishData);
        setTotalPrice(totalPrice);
        this.status = status;
        setOrderProducts(orderProducts);
    }
    public String getOrderCreateData() {
        return orderCreateData;
    }

    public void setOrderCreateData(String orderCreateData) {
        this.orderCreateData = orderCreateData;
    }

    public String getOrderFinishData() {
        return orderFinishData;
    }

    public void setOrderFinishData(String orderFinishData) {
        this.orderFinishData = orderFinishData;
    }
    public String getWaiterUserName() {
        return waiterUserName;
    }

    public void setWaiterUserName(String waiterUserName) {
        this.waiterUserName = waiterUserName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        if(totalPrice>0){
            this.totalPrice = totalPrice;
        }

    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public void calculateTotalPrice() {
//        for (MenuItem product : products) {
//            setTotalPrice(getTotalPrice()+products;);
//        }

//        for (int i = 0; i <products.size(); i++) {
//            products.
//
//        }
    }

    @Override
    public String toString() {
        return "Поръчката e " +
                " създаден от сервитьор --> '" + waiterUserName + '\'' +
                ",\nСъздадена на --> '" + orderCreateData + '\'' +
                ",\nПриключена на -->'" + orderFinishData + '\'' +
                ",\nтотална Цена=" + totalPrice +
                ",\nСтатус на поръчката --> " + status +
                ",\nПродукти --> " + orderProducts +
                '}';
    }



}
