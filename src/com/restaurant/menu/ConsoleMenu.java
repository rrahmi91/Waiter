package com.restaurant.menu;
import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItem.Drink;
import com.restaurant.menu.MenuItem.Food;
import java.util.List;
import static com.restaurant.Main.scanner;

public class ConsoleMenu {

    public void addMenuItem() {
        while (true) {
            System.out.println("Моля изберете вид продукт, който искате да добавите:");
            System.out.println("1. Ястие ");
            System.out.println("2. Питие ");
            System.out.println(" ЗА ИЗХОД НАТИСНЕТЕ ПРОИЗВОЛЕН СИМВОЛ");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    addFood();
                    return;
                case "2":
                    addDrink();
                    return;
                default:
                    System.out.println("ИЗХОД");
                    return;
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
                    System.out.println("Моля въведете число между 1 и " + foodTypes.length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Грешка! Моля изберете вида ястие от менюто!");
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

        Food newFood = new Food(name, quantity, type, price);
        MenuItemDataHandler.addMenuItem(newFood);

    }

    public void removeMenuItem(List<MenuItem>menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i+":"+menuItems.get(i));
        }
        System.out.println("Моля изберете продукт от менюто, който искате да премахнете:");
        int itemIndex=0;
        boolean indexChoice = false;
        while (!indexChoice) {
        try {
            itemIndex = Integer.parseInt(scanner.nextLine());
            indexChoice = true;
        } catch (NumberFormatException e) {
            System.out.println("Въведете коректно номера на продукта от менюто. ");
        }
    }

        MenuItem menuItem = menuItems.get(itemIndex);
        MenuItemDataHandler.removeMenuItem( menuItem);
    }
}