package com.restaurant;

import com.restaurant.order.Order;
import com.restaurant.order.Table;
import com.restaurant.order.TableStatus;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final List<Table> tables;

    public Restaurant() {
        this.tables = new ArrayList<>();
        initializeTables();
    }

    private void initializeTables() {
        int numberOfTables = 10;
        for (int i = 0; i < numberOfTables; i++) {
            tables.add(new Table(TableStatus.FREE));
        }
    }

    public void assignOrderToTable(Order order, int tableNumber) {
        Table table = findTableByNumber(tableNumber);
        if (table != null) {
            if (table.getTableStatus().equals(TableStatus.FREE)) {
                table.assignOrder(order);
                table.setTableStatus(TableStatus.OCCUPIED);
            } else {
                System.out.println("Маса номер " + table.getTableNumber() + " е заета.");
            }
        } else {
            System.out.println("Не съществуваща маса");
        }
        System.out.println(tables);
    }

    private Table findTableByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.getTableNumber() == tableNumber)
                .findFirst()
                .orElse(null);
    }
}
