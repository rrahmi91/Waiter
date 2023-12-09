package com.restaurant.order;

import com.restaurant.menu.Product;

import java.util.List;

public class Order implements TotalPriceCalculatible{
    private String waiterUserName;
    private String orderCreateData;
    private String orderFinishData;
    private double totalPrice;
    private OrderStatus status;
    private List<Product> products;

    public Order(String waiterUserName, String orderCreateData, String orderFinishData, double totalPrice, OrderStatus status,List<Product>products) {
        setWaiterUserName(waiterUserName);
        setOrderCreateData(orderCreateData);
        setOrderFinishData(orderFinishData);
        setTotalPrice(totalPrice);
        this.status = status;
       setProducts(products);
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
        this.totalPrice = totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    @Override
    public void calculateTotalPrice() {
        for (Product product : products) {
            setTotalPrice(getTotalPrice()+product.getPrice());
        }
    }

    @Override
    public String toString() {
        return "Поръчката e " +
                " създаден от сервитьор --> '" + waiterUserName + '\'' +
                ",\nСъздадена на --> '" + orderCreateData + '\'' +
                ",\nПриключена на -->'" + orderFinishData + '\'' +
                ",\nтотална Цена=" + totalPrice +
                ",\nСтатус на поръчката --> " + status +
                ",\nПродукти --> " + products +
                '}';
    }


}
