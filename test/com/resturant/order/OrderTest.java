package com.resturant.order;
import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItem.Drink;
import com.restaurant.menu.MenuItem.Food;
import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testCreateOrder() {
        // GIVEN
        String waiterUserName = "Rahmi";
        String orderCreateData = "2023-01-01 12:00:00";
        String orderFinishData = "2023-01-01 13:00:00";
        double totalPrice = 50.0;
        OrderStatus status = OrderStatus.PAID;

        // WHEN
        List<MenuItem> orderProducts = new ArrayList<>();
        MenuItem drink = new Drink("Cola",250,Drink.Type.CARBONATED, 2.5);
        MenuItem food = new Food("Burger", 1,Food.Type.MAIN_COURSE, 10.0);
        orderProducts.add(drink);
        orderProducts.add(food);

        Order order = new Order(waiterUserName, orderCreateData, orderFinishData, totalPrice, status, orderProducts);

        // THEN
        assertEquals(waiterUserName, order.getWaiterUserName());
        assertEquals(orderCreateData, order.getOrderCreateData());
        assertEquals(orderFinishData, order.getOrderFinishData());
        assertEquals(totalPrice, order.getTotalPrice());
        assertEquals(status, order.getStatus());
        assertEquals(orderProducts, order.getOrderProducts());
    }

    @Test
    void testCreateOrderWithNullProducts() {
        // GIVEN
        String waiterUserName = "Rahmi";
        String orderCreateData = "2023-01-01 12:00:00";
        String orderFinishData = "2023-01-01 13:00:00";
        double totalPrice = 50.0;
        OrderStatus status = OrderStatus.PAID;

        // WHEN
        Order order = new Order(waiterUserName, orderCreateData, orderFinishData, totalPrice, status, null);

        // THEN
        assertEquals(waiterUserName, order.getWaiterUserName());
        assertEquals(orderCreateData, order.getOrderCreateData());
        assertEquals(orderFinishData, order.getOrderFinishData());
        assertEquals(totalPrice, order.getTotalPrice());
        assertEquals(status, order.getStatus());
        assertNotNull(order.getOrderProducts());
        assertTrue(order.getOrderProducts().isEmpty());
    }

    @Test
    void testAddProduct() {
        // GIVEN
        Order order = new Order("Rahmi", "2023-01-01 12:00:00", null, 0.0, OrderStatus.NEW_ORDER, new ArrayList<>());
        MenuItem drink = new Drink("Cola",250,Drink.Type.CARBONATED, 2.5);

        // WHEN
        order.addProduct(drink);

        // THEN
        assertTrue(order.getOrderProducts().contains(drink));
    }

    @Test
    void testCalculateTotalPrice() {
        // GIVEN
        Order order = new Order("John", "2023-01-01 12:00:00", null, 0.0, OrderStatus.NEW_ORDER, new ArrayList<>());
        MenuItem drink = new Drink("Cola",250,Drink.Type.CARBONATED, 2.5);
        MenuItem food = new Food("Burger", 1,Food.Type.MAIN_COURSE, 10.0);
        order.addProduct(drink);
        order.addProduct(food);

        // WHEN
        order.calculateTotalPrice();

        // THEN
        assertEquals(12.5, order.getTotalPrice());
    }

    @Test
    void testCalculateTotalPriceWithNoProducts() {
        // GIVEN
        Order order = new Order("Rahmi", "2023-01-01 12:00:00", null, 0.0, OrderStatus.NEW_ORDER, new ArrayList<>());

        // WHEN
        order.calculateTotalPrice();

        // THEN
        assertEquals(0.0, order.getTotalPrice());
    }
}
