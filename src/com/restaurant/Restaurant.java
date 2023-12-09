package com.restaurant;

import com.restaurant.FileHandler.FileHandler;
import com.restaurant.order.Order;
import com.restaurant.order.Table;
import com.restaurant.order.TableStatus;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    public Restaurant() {
        this.tables = new ArrayList<>();
        initializeTables();
    }

    private void initializeTables() {
        int numberOfTables = 10;
        for (int i = 0; i < numberOfTables; i++) {
            tables.add(new Table(TableStatus.FREE, null));
        }
    }

    public void assignOrderToTable(Order order, int tableNumber) {
        Table table = findTableByNumber(tableNumber);
        if (table != null) {
            if (table.getTableStatus().equals(TableStatus.FREE)) {
                table.setOrder(order);
                table.setTableStatus(TableStatus.OCCUPIED);
                System.out.println("Създадена поръчка към маса " + table.getTableNumber());
                System.out.println(table.getOrder());
            } else {
                System.out.println("Маса номер " + table.getTableNumber() + " е заета.");
            }
        } else {
            System.out.println("Не съществуваща маса");
        }
    }

    private Table findTableByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.getTableNumber() == tableNumber)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Маса=" + tables +
                '}';
    }
}
