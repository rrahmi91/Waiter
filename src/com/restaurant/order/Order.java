package com.restaurant.order;

import com.restaurant.menu.Product;

import java.util.List;

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

    @Override
    public String toString() {
        return "Поръчка{" +
                "Създаден от сервитьор='" + waiterUserName + '\'' +
                ", createData='" + createData + '\'' +
                ", finishData='" + finishData + '\'' +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}'+"\n";
    }
}
