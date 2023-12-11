package com.restaurant;

import com.restaurant.menu.ConsoleMenu;
import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItemDataHandler;
import com.restaurant.menu.MenuItem.Drink;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;


import java.util.Scanner;


public class Main {
    protected static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();

    private static final String TRANSLATIONS_FILE = "bulgarian.properties";
    public static Properties translations = loadTranslations();

    public static void main(String[] args) {

    }

//        Drink drink1 = new Drink("tequila",0.50, Drink.Type.ALCOHOL,5.50);
//
//        List<MenuItem> menuItems = MenuItemDataHandler.getMeals();
//        MenuItemDataHandler.addMeal(drink1);
//        MenuItemDataHandler.removeMeal(drink1);
//
//        for (MenuItem menuItem : menuItems) {
//            System.out.println(menuItem);
//        }
//    }
}