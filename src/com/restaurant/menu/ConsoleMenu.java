package com.restaurant.menu;

import java.util.Scanner;

public class ConsoleMenu {
    Scanner scanner = new Scanner(System.in);

    public Soup addSoup() {
        Soup soup = null;
        while (true) {
            System.out.print("Въведете вид супа: ");
            String name = scanner.nextLine();
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Въведете грамаж: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            soup = new Soup(name,quantity,price);
            break;
        }
        return soup;
    }


    private Salad addSalad() {
        Salad salad = null;
        while (true) {
            System.out.print("Въведете вид салата: ");
            String name = scanner.nextLine();
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Въведете грамаж: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            salad = new Salad(name,quantity,price);
            break;
        }
        return salad;
    }

    private MainCourse addMainCourse() {
        MainCourse mainCourse = null;
        while (true) {
            System.out.print("Въведете вид основно ястие: ");
            String name = scanner.nextLine();
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Въведете грамаж: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            mainCourse = new MainCourse(name,quantity,price);
            break;
        }
        return mainCourse;
    }

    private Dessert addDessert() {
        Dessert dessert = null;
        while (true) {
            System.out.print("Въведете вид десерт: ");
            String name = scanner.nextLine();
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Въведете грамаж: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            dessert = new Dessert(name,quantity,price);
            break;
        }
        return dessert;
    }

    private Water addWater() {
        Water water = null;
        while (true) {
            System.out.print("Въведете марка вода: ");
            String brand = scanner.nextLine();
            System.out.println("Въведете количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());

            water = new Water(brand, quantity, price);
            break;
        }
        return water;
    }

    private Alcohol addAlcohol() {
        Alcohol alcohol = null;
        while (true) {
            System.out.print("Въведете вид / марка алкохол: ");
            String brand = scanner.nextLine();
            System.out.println("Въведете количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());

            alcohol = new Alcohol(brand,quantity,price);
            break;
        }
        return alcohol;
    }

    private HotDrinks addHotDrinks() {
        HotDrinks hotDrinks = null;
        while (true) {
            System.out.print("Въведете вид топла напитка: ");
            String brand = scanner.nextLine();
            System.out.println("Въведете количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());

            hotDrinks = new HotDrinks(brand, quantity, price);
            break;
        }
        return hotDrinks;
    }

    private SoftDrinks addSoftDrinks() {
        SoftDrinks softDrinks = null;
        while (true) {
            System.out.print("Въведете безалкохолно: ");
            String brand = scanner.nextLine();
            System.out.println("Въведете количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());

            softDrinks = new SoftDrinks(brand, quantity, price);
            break;
        }
        return softDrinks;
    }

    private Juice addJuice() {
        Juice juice = null;
        while (true) {
            System.out.print("Въведете вид натурален сок: ");
            String brand = scanner.nextLine();
            System.out.println("Въведете количество: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Въведете цена:");
            double price = Double.parseDouble(scanner.nextLine());

            juice = new Juice(brand, quantity, price);
            break;
        }
        return juice;
    }

    private Product addDrink() {
        Product product = null;
        while (true) {
            System.out.println("Моля изберете вид ястие, което искате да добавите:");
            System.out.println("1. ВОДА");
            System.out.println("2. АЛКОХОЛ");
            System.out.println("3. ТОПЛА НАПИТКА");
            System.out.println("4. БЕЗАЛКОХОЛНО");
            System.out.println("5. НАТУРАЛЕН СОК");
            System.out.println("За изход - натиснете друго");

            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    product = addWater();
                    break;
                case "2":
                    product = addAlcohol();
                    break;
                case "3":
                    product = addHotDrinks();
                    break;
                case "4":
                    product = addSoftDrinks();
                    break;
                case "5":
                    product = addJuice();
                    break;
                default:
                    System.out.println("Изход от добавяне");
                    break;
            }
            if (product != null) {
                System.out.println("Напитка добавена: ");
                break;
            }
        }
        return product;
    }


    public Product addFood() {
        Product product = null;
        while (true) {
            System.out.println("Моля изберете вид ястие, което искате да добавите:");
            System.out.println("1. ОСНОВНО");
            System.out.println("2. ДЕСЕРТ");
            System.out.println("3. СУПА");
            System.out.println("4. САЛАТА");
            System.out.println("За изход натиснете друго");

            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    product = addSoup();
                    break;
                case "2":
                    product = addSalad();
                    break;
                case "3":
                    product = addMainCourse();
                    break;
                case "4":
                    product = addDessert();
                    break;
                default:
                    System.out.println("Изход от добавяне на ястие.");
                    break;
            }
            if (product != null) {
                System.out.println("Ястие добавено ");
                break;
            }
        }
        return product;
    }


    public Product addProduct() {
        Product product;
        while (true) {
            System.out.println("Моля изберете вид продукт, който искате да добавите:");
            System.out.println("1. Ястие");
            System.out.println("2. Напитка");
            System.out.println("За изход въведете произволен символ или символи.");

            String selection = scanner.nextLine();

            switch (selection) {
                case "1":
                    product = addFood();
                    break;
                case "2":
                    product = addDrink();
                    break;
                default:
                    System.out.println("Изход");
                    break;
            }
        }
    }

}

