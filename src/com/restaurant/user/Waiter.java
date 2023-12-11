package com.restaurant.user;

import com.restaurant.menu.Alcohol;
import com.restaurant.menu.Product;
import com.restaurant.menu.Salad;
import com.restaurant.order.Addable;
import com.restaurant.order.Changeable;
import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;

import java.util.ArrayList;
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
        ArrayList<Product> products = new ArrayList<>();
        Order order = new Order(getUserName(), currentDataAndTimeCreatedOrder, "Поръчката е активна", 0.0, OrderStatus.NEW_ORDER, products);
        products.add(new Alcohol("Bira", 500, 2.3));
        products.add(new Salad("Шопска", 680, 6.8));
        order.calculateTotalPrice();

        return order;
    }

    public void finishOrder(Order order) {
        order.setOrderFinishData(getCurrentDateTime());
    }

    @Override
    public Order addProduct(Order order, Product product) {
        List<Product> products = order.getProducts();
        products.add(product);
        order.setProducts(products);
        return order;
    }

    @Override
    public Order removeProduct(Order order, Product product) {
        List<Product> products = order.getProducts();
        products.remove(product);
        order.setProducts(products);
        return order;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
