package com.restaurant.menu;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItem.Food;

import java.util.Properties;
import java.util.Scanner;

import static com.restaurant.Main.loadTranslations;
import static com.restaurant.Main.translations;

public class ConsoleMenu {
    Scanner scanner = new Scanner(System.in);

//    public Product addFood() {
//        Product product = null;
//        while (true) {
//            System.out.println("Моля изберете вид ястие, което искате да добавите:");
//            System.out.println("1. ОСНОВНО");
//            System.out.println("2. ДЕСЕРТ");
//            System.out.println("3. СУПА");
//            System.out.println("4. САЛАТА");
//            System.out.println("За изход натиснете друго");
//
//            String selection = scanner.nextLine();
//            switch (selection) {
//                case "1":
//                    product = addSoup();
//                    break;
//                case "2":
//                    product = addSalad();
//                    break;
//                case "3":
//                    product = addMainCourse();
//                    break;
//                case "4":
//                    product = addDessert();
//                    break;
//                default:
//                    System.out.println("Изход от добавяне на ястие.");
//                    break;
//            }
//            if (product != null) {
//                System.out.println("Ястие добавено ");
//                break;
//            }
//        }
//        return product;
//    }


    public void addMenuItem() {
        MenuItem product;
        while (true) {
            System.out.println("Моля изберете вид продукт, който искате да добавите:");
            System.out.println("1. " + translations.getProperty("menu.food"));
            System.out.println("2. " + translations.getProperty("menu.drink"));
            System.out.println(translations.getProperty("menu.exit_long"));

            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    addFood();
                    break;
                case "2":
                    addDrink();
                    break;
                default:
                    System.out.println(translations.getProperty("menu.exit"));
                    break;
            }
        }
    }

    private void addDrink() {
        System.out.println(translations.getProperty("menu.select_menu_item_type"));
        Food.Type[] foodTypes = Food.Type.values();

        for (int i = 0; i < foodTypes.length; i++) {
            System.out.println((i + 1) + ". " + translations.getProperty("food.type." + foodTypes[i].name()));
        }

        int typeChoice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println(translations.getProperty("menu.select_food_type"));
            try {
                typeChoice = Integer.parseInt(scanner.nextLine());
                if (typeChoice >= 1 && typeChoice <= foodTypes.length) {
                    validChoice = true;
                } else {
                    System.out.println(translations.getProperty("menu.select_food_type_description") + foodTypes.length);
                }
            } catch (NumberFormatException e) {
                System.out.println(translations.getProperty("menu.select_food_type_error"));
            }
        }

        Food.Type type = foodTypes[typeChoice - 1];

        String name = "";

        while(name.isEmpty()) {
            System.out.println("Enter food name:");
            name = scanner.nextLine();
        }

        int calories = 0;
        boolean validCalories = false;
        while (!validCalories) {
            System.out.println("Enter calories:");
            try {
                calories = Integer.parseInt(scanner.nextLine());
                validCalories = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for calories.");
            }
        }

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.println("Enter price:");
            try {
                price = Double.parseDouble(scanner.nextLine());
                validPrice = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }

        scanner.close();

        Food newFood = new Food(name, calories, type, price);

        MenuItemDataHandler.addMenuItem(newFood);
    }
    }

    private void addFood() {
        System.out.println(translations.getProperty("menu.select_menu_item_type"));
        Food.Type[] foodTypes = Food.Type.values();

        for (int i = 0; i < foodTypes.length; i++) {
            System.out.println((i + 1) + ". " + translations.getProperty("food.type." + foodTypes[i].name()));
        }

        int typeChoice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println(translations.getProperty("menu.select_food_type"));
            try {
                typeChoice = Integer.parseInt(scanner.nextLine());
                if (typeChoice >= 1 && typeChoice <= foodTypes.length) {
                    validChoice = true;
                } else {
                    System.out.println(translations.getProperty("menu.select_food_type_description") + foodTypes.length);
                }
            } catch (NumberFormatException e) {
                System.out.println(translations.getProperty("menu.select_food_type_error"));
            }
        }

        Food.Type type = foodTypes[typeChoice - 1];

        String name = "";

        while(name.isEmpty()) {
            System.out.println("Enter food name:");
            name = scanner.nextLine();
        }

        int calories = 0;
        boolean validCalories = false;
        while (!validCalories) {
            System.out.println("Enter calories:");
            try {
                calories = Integer.parseInt(scanner.nextLine());
                validCalories = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for calories.");
            }
        }
        
        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.println("Enter price:");
            try {
                price = Double.parseDouble(scanner.nextLine());
                validPrice = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }

        scanner.close();

        Food newFood = new Food(name, calories, type, price);

        MenuItemDataHandler.addMenuItem(newFood);
    }
}
