package com.restaurant.order;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private static int nextTableNumber = 1;
    private int tableNumber;
    private TableStatus tableStatus;
    private List<Order> orders;

    public Table(TableStatus status) {
        this.tableNumber = nextTableNumber++;
        this.tableStatus = status;
        this.orders = new ArrayList<>();
    }
    public List<Order> getOrders() {
        return orders;
    }
    public  int getTableNumber() {
        return tableNumber;
    }
    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    public void assignOrder(Order order) {
        orders.add(order);
        System.out.println("Създадена поръчка към маса " + tableNumber);
    }

    @Override
    public String toString() {
        return "Маса Номер: " + getTableNumber() +'\'' +
                " Статус на масата -->" + tableStatus +
                ", Поръчка към масата -->" + orders +
                '}';
    }
}
