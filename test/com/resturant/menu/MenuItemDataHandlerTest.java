package com.resturant.menu;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItem.Drink;
import com.restaurant.menu.MenuItem.Food;
import com.restaurant.menu.MenuItemDataHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemDataHandlerTest {

    private static final String TEST_FILE_NAME = "testmenuitems.csv";

    @BeforeEach
    void setUp() {
        File testFile = new File(TEST_FILE_NAME);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void testAddMenuItem() {
        // GIVEN
        MenuItem menuItem = new Drink("Test Drink", 200, Drink.Type.SODA, 2.5);

        // WHEN
        MenuItemDataHandler.addMenuItem(menuItem);

        // THEN
        List<MenuItem> menuItems = MenuItemDataHandler.getMenuItems(TEST_FILE_NAME);
        assertNotNull(menuItems);
        assertFalse(menuItems.isEmpty());
        assertEquals(1, menuItems.size());
        assertEquals(menuItem, menuItems.get(0));
    }

    @Test
    void testRemoveMenuItem() {
        // GIVEN
        MenuItem menuItem = new Drink("Test Drink", 200, Drink.Type.SODA, 2.5);
        MenuItemDataHandler.addMenuItem(menuItem);

        // WHEN
        MenuItemDataHandler.removeMenuItem(menuItem);

        // THEN
        List<MenuItem> menuItems = MenuItemDataHandler.getMenuItems(TEST_FILE_NAME);
        assertNotNull(menuItems);
        assertTrue(menuItems.isEmpty());
    }

    @Test
    void testGetMenuItems() {
        // GIVEN
        MenuItem menuItem1 = new Drink("Test Drink 1", 200, Drink.Type.SODA, 2.5);
        MenuItem menuItem2 = new Food("Test Food 2", 300, Food.Type.SOUP, 8.0);
        MenuItemDataHandler.addMenuItem(menuItem1);
        MenuItemDataHandler.addMenuItem(menuItem2);

        // WHEN
        List<MenuItem> menuItems = MenuItemDataHandler.getMenuItems(TEST_FILE_NAME);

        // THEN
        assertNotNull(menuItems);
        assertFalse(menuItems.isEmpty());
        assertEquals(2, menuItems.size());
        assertTrue(menuItems.contains(menuItem1));
        assertTrue(menuItems.contains(menuItem2));
    }
}
