package com.restaurant;

import com.restaurant.menu.Product.Base.Product;
import com.restaurant.menu.MealDataHandler;
import com.restaurant.menu.Product.Drink;

import java.util.List;

public class Main {
    protected static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        interactingWithConsole.restaurantMenageMainMenuInterface(scanner);
//        scanner.close();
//    }

        Drink drink1 = new Drink("tequila",0.50, Drink.Type.ALCOHOL,5.50);

        List<Product> products = MealDataHandler.getMeals();
        MealDataHandler.addMeal(drink1);
        MealDataHandler.removeMeal(drink1);

        for (Product product : products) {
            System.out.println(product);
        }
    }
}