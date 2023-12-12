package com.resturant.user;

import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;
import com.restaurant.user.UserType;
import com.restaurant.user.Waiter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WaiterTest {
    @Test
    void testChangeOrderStatusToServed() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        Order updatedOrder = waiter.changeOrderStatus(order, 1);

        // THEN
        assertEquals(OrderStatus.SERVED, updatedOrder.getStatus());
    }

    @Test
    void testChangeOrderStatusToPaid() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        Order updatedOrder = waiter.changeOrderStatus(order, 2);

        // THEN
        assertEquals(OrderStatus.PAID, updatedOrder.getStatus());
        assertTrue(updatedOrder.getOrderFinishData().startsWith("20"));
    }

    @Test
    void testChangeOrderStatusWithInvalidSelection() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        Order updatedOrder = waiter.changeOrderStatus(order, 3);

        // THEN
        assertEquals(OrderStatus.NEW_ORDER, updatedOrder.getStatus());
    }

    @Test
    void testCreateOrder() {
        // GIVEN
        Waiter waiter = new Waiter("JohnDoe", "password", UserType.WAITER);

        // WHEN
        Order order = waiter.createOrder();

        // THEN
        assertEquals(OrderStatus.NEW_ORDER, order.getStatus());
        assertTrue(order.getProducts().size() > 0);
    }

    @Test
    void testFinishOrder() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        waiter.finishOrder(order);

        // THEN
        assertEquals(OrderStatus.PAID, order.getStatus());
    }


    @Test
    void testAddProductToOrder() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();
        Product product = new Alcohol("Vodka", 250, 5.0);

        // WHEN
        Order updatedOrder = waiter.addProduct(order, product);

        // THEN
        assertTrue(updatedOrder.getProducts().contains(product));
    }

    @Test
    void testRemoveProductFromOrder() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();
        Product product1 = new Salad("Шопска", 500, 8.0);
        Product product2 = new Salad("Шопска", 500, 8.0);
        waiter.addProduct(order, product1);
        waiter.addProduct(order, product2);
        // WHEN
        Order updatedOrder = waiter.removeProduct(order, product1);

        // THEN
        List<Product> updatedProducts = updatedOrder.getProducts();
        assertFalse(updatedProducts.contains(product1));
        assertEquals(order.getProducts().size() - 1, updatedProducts.size());
    }

}
