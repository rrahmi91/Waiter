package com.restaurant.user;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItemDataHandler;
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
        List<MenuItem> products = MenuItemDataHandler.getMenuItems();
        Order order = new Order(getUserName(), currentDataAndTimeCreatedOrder, "Поръчката е активна", 0.0, OrderStatus.NEW_ORDER, null);
        return order;
    }

    public void finishOrder(Order order) {
        order.setOrderFinishData(getCurrentDateTime());
    }

    @Override
    public Order addProduct(Order order, List<MenuItem> menuItems,int indexProduct) {
        menuItems.get(indexProduct);

        //order.;
        return order;
    }

    @Override
    public Order removeProduct(Order order, List<Product> products) {
        return null;
    }

//for (int i = 0; i < menuItems.size(); i++) {
//            System.out.println("Индекс "+i+" "+menuItems.get(i));
//        }
    private MenuItem selectorItemFromMenu(List<MenuItem> menuItems,int indexProduct) {
         menuItems = MenuItemDataHandler.getMenuItems();

        return menuItems.get(indexProduct);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
