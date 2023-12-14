package com.restaurant;

import com.restaurant.menu.ConsoleMenu;
import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;
import com.restaurant.order.Table;
import com.restaurant.order.TableStatus;
import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItemDataHandler;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<MenuItem> menuItems;
    private List<Table> tables;
    ConsoleMenu consoleMenu = new ConsoleMenu();

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Restaurant() {
        this.tables = new ArrayList<>();
        initializeTables();
        this.menuItems = MenuItemDataHandler.getMenuItems();
    }

    private void initializeTables() {
        int numberOfTables = 10;
        for (int i = 0; i < numberOfTables; i++) {
            tables.add(new Table(TableStatus.FREE, null));
        }
    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
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

    public List<Table> removeFinishedOrder(List<Table> tables) {
        for (Table table : tables) {
            if (table.getOrder() != null) {
                if (table.getOrder().getStatus().equals(OrderStatus.PAID)) {
                    table.setOrder(null);
                    table.setTableStatus(TableStatus.FREE);
                }
            }
        }
        return tables;
    }

    public Table findTableByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.getTableNumber() == tableNumber)
                .findFirst()
                .orElse(null);
    }
    public void printMenu(){
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i+":"+menuItems.get(i));
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "Маса=" + tables +
                '}';
    }
}
