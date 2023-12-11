package com.restaurant;

import com.restaurant.menu.ConsoleMenu;
import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItemDataHandler;
import com.restaurant.menu.MenuItem.Drink;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

public class Main {
    protected static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();

    private static final String TRANSLATIONS_FILE = "bulgarian.properties";
    public static Properties translations = loadTranslations();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        interactingWithConsole.restaurantMenageMainMenuInterface(scanner);
//        scanner.close();
//    }

//        Drink drink1 = new Drink("tequilaa",0.50, Drink.Type.ALCOHOL,5.50);
//
//        List<MenuItem> menuItems = MenuItemDataHandler.getMenuItems();
//        MenuItemDataHandler.addMenuItem(drink1);
//        MenuItemDataHandler.removeMenuItem(drink1);
//
//        for (MenuItem menuItem : menuItems) {
//            System.out.println(menuItem);
//        }

        ConsoleMenu consoleMenu = new ConsoleMenu();

        consoleMenu.addMenuItem();
    }

    public static Properties loadTranslations() {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(TRANSLATIONS_FILE);
             InputStreamReader reader = new InputStreamReader(input, StandardCharsets.UTF_8)) {
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}