package com.restaurant.order;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItem.Drink;
import com.restaurant.menu.MenuItem.Food;
import java.util.ArrayList;
import java.util.List;

public class Order implements TotalPriceCalculatible {
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

    public Order(String waiterUserName, String orderCreateData, String orderFinishData, double totalPrice, OrderStatus status, List<MenuItem> orderProducts) {
        setWaiterUserName(waiterUserName);
        setOrderCreateData(orderCreateData);
        setOrderFinishData(orderFinishData);
        setTotalPrice(totalPrice);
        this.status = status;
        this.orderProducts = new ArrayList<>();
        if (orderProducts != null) {
            this.orderProducts.addAll(orderProducts);
        }
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
        if (totalPrice >= 0) {
            this.totalPrice = totalPrice;
        }

    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addProduct(MenuItem product) {
        this.orderProducts.add(product);
    }

    @Override
    public void calculateTotalPrice() {
        setTotalPrice(0);

        for (int i = 0; i < orderProducts.size(); i++) {
            MenuItem menuItem = orderProducts.get(i);

            if (menuItem instanceof Drink drink) {
                double drinkPrice = drink.getPrice();
                setTotalPrice(getTotalPrice() + drinkPrice);
            }

            if (menuItem instanceof Food food) {
                double foodPrice = food.getPrice();
                setTotalPrice(getTotalPrice() + foodPrice);
            }
        }
    }


    public String toString() {
        StringBuilder result = new StringBuilder("Поръчката e " +
                " създаден от сервитьор --> '" + waiterUserName + '\'' +
                ",\nСъздадена на --> '" + orderCreateData + '\'' +
                ",\nПриключена на -->'" + orderFinishData + '\'' +
                ",\nтотална Цена=" + totalPrice +
                ",\nСтатус на поръчката --> " + status +
                ",\nПродукти --> ");

        for (int i = 0; i < orderProducts.size(); i++) {
            result.append("\n").append((i + 1)).append(". ").append(orderProducts.get(i));
        }

        return result.toString();
    }

}
