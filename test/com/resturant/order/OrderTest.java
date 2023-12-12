package com.resturant.order;

import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    @Test
    void testCalculateTotalPriceWithEmptyProductList() {
        // GIVEN
        List<Product> products = new ArrayList<>();
        Order order = new Order("JohnDoe", "2023-01-01 12:00:00", "2023-01-01 13:00:00", 0.0, OrderStatus.PAID, products);

        // WHEN
        order.calculateTotalPrice();

        // THEN
        assertEquals(0.0, order.getTotalPrice());
    }

    @Test
    void testCalculateTotalPriceWithPositivePrices() {
        // GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Alcohol("Bira", 500, 2.3));
        products.add(new Salad("Шопска", 680, 6.8));
        Order order = new Order("JohnDoe", "2023-01-01 12:00:00", "2023-01-01 13:00:00", 0.0, OrderStatus.PAID, products);

        // WHEN
        order.calculateTotalPrice();

        // THEN
        assertEquals(9.1, order.getTotalPrice(), 0.001);
    }

    @Test
    void testCalculateTotalPriceWithNegativePrices() {
        // GIVEN
        List<Product> products = new ArrayList<>();
        products.add(new Alcohol("Bira", 500, -2.3));
        products.add(new Salad("Шопска", 680, -6.8));
        Order order = new Order("JohnDoe", "2023-01-01 12:00:00", "2023-01-01 13:00:00", 0.0, OrderStatus.PAID, products);

        // WHEN
        order.calculateTotalPrice();

        // THEN
        assertEquals(0.0, order.getTotalPrice(), 0.001);
    }
}

