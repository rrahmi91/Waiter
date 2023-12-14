package com.resturant;
import com.restaurant.Restaurant;
import com.restaurant.order.Order;
import com.restaurant.order.OrderStatus;
import com.restaurant.order.Table;
import com.restaurant.order.TableStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    @Test
    void testAssignOrderToTable() {
        // GIVEN
        Restaurant restaurant = new Restaurant();
        Order order = new Order("Rahmi", "2023-01-01 12:00:00", null, 0.0, OrderStatus.NEW_ORDER, new ArrayList<>());
        int tableNumber = 1;

        // WHEN
        restaurant.assignOrderToTable(order, tableNumber);

        // THEN
        Table table = restaurant.findTableByNumber(tableNumber);
        assertNotNull(table);
        assertEquals(TableStatus.OCCUPIED, table.getTableStatus());
        assertEquals(order, table.getOrder());
    }

    @Test
    void testAssignOrderToOccupiedTable() {
        // GIVEN
        Restaurant restaurant = new Restaurant();
        Order order1 = new Order("Rahmi", "2023-01-01 12:00:00", null, 0.0, OrderStatus.NEW_ORDER, new ArrayList<>());
        Order order2 = new Order("Rahmi", "2023-01-01 13:00:00", null, 0.0, OrderStatus.NEW_ORDER, new ArrayList<>());
        int tableNumber = 2;

        // WHEN
        restaurant.assignOrderToTable(order1, tableNumber);
        restaurant.assignOrderToTable(order2, tableNumber);

        // THEN
        Table table = restaurant.findTableByNumber(tableNumber);
        if(table !=null){
            assertEquals(TableStatus.OCCUPIED, table.getTableStatus());
            assertEquals(order1, table.getOrder());
        }
    }

    @Test
    void testRemoveFinishedOrder() {
        // GIVEN
        Restaurant restaurant = new Restaurant();
        Order paidOrder = new Order("Rahmi", "2023-01-01 12:00:00", null, 0.0, OrderStatus.PAID, new ArrayList<>());
        Order newOrder = new Order("Rahmi", "2023-01-01 13:00:00", null, 0.0, OrderStatus.NEW_ORDER, new ArrayList<>());
        int tableNumber = 3;
        restaurant.assignOrderToTable(paidOrder, tableNumber);
        restaurant.assignOrderToTable(newOrder, tableNumber);

        // WHEN
        restaurant.removeFinishedOrder(restaurant.getTables());

        // THEN
        Table table = restaurant.findTableByNumber(tableNumber);
        if(table !=null){
            assertEquals(TableStatus.FREE, table.getTableStatus());
            assertNull(table.getOrder());
        }
    }
}
