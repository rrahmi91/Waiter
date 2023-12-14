package com.restaurant;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItemDataHandler;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        interactingWithConsole.restaurantMenageMainMenuInterface(scanner);

    }
}