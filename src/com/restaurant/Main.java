package com.restaurant;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItemDataHandler;
import com.restaurant.menu.MenuItem.Drink;

import java.util.List;

public class Main {
    protected static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        interactingWithConsole.restaurantMenageMainMenuInterface(scanner);
//        scanner.close();
//    }

        Drink drink1 = new Drink("tequila",0.50, Drink.Type.ALCOHOL,5.50);

        List<MenuItem> menuItems = MenuItemDataHandler.getMeals();
        MenuItemDataHandler.addMeal(drink1);
        MenuItemDataHandler.removeMeal(drink1);

        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }
}