package com.restaurant.user;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.order.*;
import java.util.List;

import static com.restaurant.DateTimeRaider.getCurrentDateTime;

public class Waiter extends User implements Addable, Changeable {

    public Waiter(String userName, String password, UserType role) {
        super(userName, password, role);
    }

    public Waiter() {
        super();
    }

    public Order changeOrderStatus(Order order, int selection) {
        switch (selection) {
            case 1 -> order.setStatus(OrderStatus.SERVED);
            case 2 -> {
                order.setStatus(OrderStatus.PAID);
                finishOrder(order);
                System.out.println(order);
            }
            default -> System.out.println("Избрахте невалиден статус");
        }
        return order;
    }

    public Order createOrder() {
        String currentDataAndTimeCreatedOrder = getCurrentDateTime();
        Order order = new Order(getUserName(), currentDataAndTimeCreatedOrder, "Поръчката е активна", 0.0, OrderStatus.NEW_ORDER,null);
        return order;
    }

    public void finishOrder(Order order) {
        order.setOrderFinishData(getCurrentDateTime());
        order.calculateTotalPrice();
    }

    @Override
    public Order addProduct(Order order, List<MenuItem> menuItems,int indexProduct) {
        if (indexProduct >= 0 && indexProduct < menuItems.size()) {
            MenuItem item = menuItems.get(indexProduct);
            order.addProduct(item);
            order.calculateTotalPrice();
        } else {
            System.out.println("Невалиден индекс за продукт в менюто.");
        }

        return order;
    }

    @Override
    public Order removeProduct(Order order,int indexProduct) {
        try {
            order.getOrderProducts().remove(indexProduct);
            System.out.println("\u001B[32mПродуктът беше успешно премахнат от поръчката.\u001B[0m");
            order.calculateTotalPrice();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\u001B[31mГрешка: Невалиден индекс за премахване на продукт от поръчката.\u001B[0m");

        }

        return order;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
