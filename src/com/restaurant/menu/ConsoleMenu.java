package com.restaurant.menu;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItem.Drink;
import com.restaurant.menu.MenuItem.Food;

import java.util.Scanner;


public class ConsoleMenu {
    Scanner scanner = new Scanner(System.in);



    public void addMenuItem() {
        MenuItem product;
        while (true) {
            System.out.println("Моля изберете вид продукт, който искате да добавите:");
            System.out.println("1. Ястие ");
            System.out.println("2. Питие ");
            System.out.println(" ЗА ИЗХОД НАТИСНЕТЕ ПРОИЗВОЛЕН СИМВОЛ");

            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    addFood();
                    break;
                case "2":
                    addDrink();
                    break;
                default:
                    System.out.println("ИЗХОД");
                    break;
            }
        }
    }

    private void addDrink() {
        System.out.println("Моля изберете: ");
        Drink.Type[] drinkTypes = Drink.Type.values();

        for (int i = 0; i < drinkTypes.length; i++) {
            System.out.println((i + 1) + ". " + drinkTypes[i].name());
        }

        int typeChoice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Моля изберете: ");
            try {
                typeChoice = Integer.parseInt(scanner.nextLine());
                if (typeChoice >= 1 && typeChoice <= drinkTypes.length) {
                    validChoice = true;
                } else {
                    System.out.println("Моля въведете число между 1 и " + drinkTypes.length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Грешка! Моля изберете вида на напитката от менюто!");
            }
        }

        Drink.Type type = drinkTypes[typeChoice - 1];

        String name = "";

        while (name.isEmpty()) {
            System.out.print("Въведете наименование на напитка : ");
            name = scanner.nextLine();
        }

        int volume = 0;
        boolean validVolume = false;
        while (!validVolume) {
            System.out.print("Въведете грамаж : ");
            try {
                volume = Integer.parseInt(scanner.nextLine());
                validVolume = true;
            } catch (NumberFormatException e) {
                System.out.println("Моля въведете количеството коректно.");
            }
        }

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.println("Въведете цена :");
            try {
                price = Double.parseDouble(scanner.nextLine());
                validPrice = true;
            } catch (NumberFormatException e) {
                System.out.println("Моля въведете коректно цената.");
            }
        }

        scanner.close();

        Drink newDrink = new Drink(name, volume, type, price);

        MenuItemDataHandler.addMenuItem(newDrink);
    }


    private void addFood() {
        System.out.println("Моля изберете вид ястие, което искате да добавите:");
        Food.Type[] foodTypes = Food.Type.values();

        for (int i = 0; i < foodTypes.length; i++) {
            System.out.println((i + 1) + ". " + foodTypes[i].name());
        }

        int typeChoice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Моля изберете типа храна от менюто!");
            try {
                typeChoice = Integer.parseInt(scanner.nextLine());
                if (typeChoice >= 1 && typeChoice <= foodTypes.length) {
                    validChoice = true;
                } else {
                    System.out.println(translations.getProperty("Моля въведете число между 1 и " + foodTypes.length));
                }
            } catch (NumberFormatException e) {
                System.out.println(translations.getProperty("menu.select_food_type_error"));
            }
        }

        Food.Type type = foodTypes[typeChoice - 1];

        String name = "";

        while (name.isEmpty()) {
            System.out.println("Въведете наименование на ястие :");
            name = scanner.nextLine();
        }

        int quantity = 0;
        boolean validQuantity = false;
        while (!validQuantity) {
            System.out.println("Въведете грамаж :");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                validQuantity = true;
            } catch (NumberFormatException e) {
                System.out.println("Въведете грамажа коректно.");
            }
        }

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.println("Въведете цена :");
            try {
                price = Double.parseDouble(scanner.nextLine());
                validPrice = true;
            } catch (NumberFormatException e) {
                System.out.println("Моля въведете коректно цената.");
            }
        }

        scanner.close();

        Food newFood = new Food(name, quantity, type, price);

        MenuItemDataHandler.addMenuItem(newFood);
    }
}
