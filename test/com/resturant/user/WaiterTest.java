package com.resturant.user;
import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;
import com.restaurant.user.UserType;
import com.restaurant.user.Waiter;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaiterTest {

    @Test
    void testCreateWaiter() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);

        // THEN
        assertEquals("Rahmi", waiter.getUserName());
        assertEquals("password", waiter.getPassword());
        assertEquals(UserType.WAITER, waiter.getRole());
    }

    @Test
    void testChangeOrderStatusServe() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        Order updatedOrder = waiter.changeOrderStatus(order, 1);

        // THEN
        assertEquals(OrderStatus.SERVED, updatedOrder.getStatus());
    }

    @Test
    void testChangeOrderStatusPaid() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        Order updatedOrder = waiter.changeOrderStatus(order, 2);

        // THEN
        assertEquals(OrderStatus.PAID, updatedOrder.getStatus());
    }

    @Test
    void testChangeOrderStatusInvalidSelection() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        Order updatedOrder = waiter.changeOrderStatus(order, 0);

        // THEN
        assertEquals(OrderStatus.NEW_ORDER, updatedOrder.getStatus());
    }

    @Test
    void testCreateOrder() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);

        // WHEN
        Order order = waiter.createOrder();

        // THEN
        assertEquals("Rahmi", order.getWaiterUserName());
        assertEquals(OrderStatus.NEW_ORDER, order.getStatus());
    }

    @Test
    void testFinishOrder() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        waiter.finishOrder(order);

        // THEN
        assertNotNull(order.getOrderFinishData());
        assertTrue(order.getTotalPrice() >= 0.0);
    }

    @Test
    void testAddProduct() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();
        List<MenuItem> menuItems = new ArrayList<>();
        MenuItem menuItem = new MenuItemStub("TestItem", 1, 10.0);
        menuItems.add(menuItem);

        // WHEN
        Order updatedOrder = waiter.addProduct(order, menuItems, 0);

        // THEN
        assertTrue(updatedOrder.getOrderProducts().contains(menuItem));

    }

    @Test
    void testAddProductInvalidIndex() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();
        List<MenuItem> menuItems = new ArrayList<>();
        MenuItem menuItem = new MenuItemStub("TestItem", 1, 10.0);
        menuItems.add(menuItem);

        // WHEN
        Order updatedOrder = waiter.addProduct(order, menuItems, 1);

        // THEN
        assertFalse(updatedOrder.getOrderProducts().contains(menuItem));
        assertEquals(0.0, updatedOrder.getTotalPrice());
    }

    @Test
    void testRemoveProduct() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();
        MenuItem menuItem = new MenuItemStub("TestItem", 1, 10.0);
        order.addProduct(menuItem);

        // WHEN
        Order updatedOrder = waiter.removeProduct(order, 0);

        // THEN
        assertFalse(updatedOrder.getOrderProducts().contains(menuItem));
        assertEquals(0.0, updatedOrder.getTotalPrice());
    }

    @Test
    void testRemoveProductInvalidIndex() {
        // GIVEN
        Waiter waiter = new Waiter("Rahmi", "password", UserType.WAITER);
        Order order = waiter.createOrder();

        // WHEN
        Order updatedOrder = waiter.removeProduct(order, 0);

        // THEN
        assertEquals(0.0, updatedOrder.getTotalPrice());
    }

    private static class MenuItemStub implements MenuItem {
        private final String name;
        private final int quantity;
        private final double price;

        public MenuItemStub(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }


        @Override
        public String toCSV() {
            return String.format("%s,%d,%.2f", name, quantity, price);
        }
    }
}
