package com.restaurant;

import com.restaurant.menu.ConsoleMenu;
import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItemDataHandler;
import com.restaurant.menu.MenuItem.Drink;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        interactingWithConsole.restaurantMenageMainMenuInterface(scanner);
//        scanner.close();
//    }
        //Drink drink1 = new Drink("tequilaa",0.50, Drink.Type.ALCOHOL,5.50);
        List<MenuItem> menuItems = MenuItemDataHandler.getMenuItems();
        //MenuItemDataHandler.addMenuItem(drink1);
        //MenuItemDataHandler.removeMenuItem(drink1);
//        for (MenuItem menuItem : menuItems) {
//            System.out.printn(menuItem);
//        }
//        ConsoleMenu consoleMenu = new ConsoleMenu();
//        consoleMenu.addMenuItem();

    }
}