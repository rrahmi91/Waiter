package com.resturant.user;

import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;
import com.restaurant.user.Cook;
import com.restaurant.user.UserType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CookTest {

    @Test
    void testChangeOrderStatusCooked() {
        // GIVEN
        Cook cook = new Cook("Saliha", "Saliha123*", UserType.COOK);
        Order order = new Order("Saliha", "2023-01-01 12:00:00", "New Order", 0.0, OrderStatus.NEW_ORDER, null);

        // WHEN
        Order updatedOrder = cook.changeOrderStatus(order, 1);

        // THEN
        assertEquals(OrderStatus.COOKED, updatedOrder.getStatus());
    }

    @Test
    void testChangeOrderStatusBeingCooked() {
        // GIVEN
        Cook cook = new Cook("Saliha", "password", UserType.COOK);
        Order order = new Order("Saliha", "2023-01-01 12:00:00", "New Order", 0.0, OrderStatus.NEW_ORDER, null);

        // WHEN
        Order updatedOrder = cook.changeOrderStatus(order, 2);

        // THEN
        assertEquals(OrderStatus.BEING_COOKED, updatedOrder.getStatus());
    }

    @Test
    void testChangeOrderStatusInvalidSelection() {
        // GIVEN
        Cook cook = new Cook("Saliha", "password", UserType.COOK);
        Order order = new Order("Saliha", "2023-01-01 12:00:00", "New Order", 0.0, OrderStatus.NEW_ORDER, null);

        // WHEN
        Order updatedOrder = cook.changeOrderStatus(order, 0);

        // THEN
        assertEquals(OrderStatus.NEW_ORDER, updatedOrder.getStatus());
    }
}
