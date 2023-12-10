package com.restaurant;

import com.restaurant.menu.Product.Base.Meal;
import com.restaurant.menu.MealDataHandler;
import com.restaurant.menu.Product.Drink;

import java.util.ArrayList;
import java.util.List;

public class Main {
    protected static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        interactingWithConsole.restaurantMenageMainMenuInterface(scanner);
//        scanner.close();
//    }

        Drink drink1 = new Drink("tequila",0.50, Drink.Type.ALCOHOL,5.50);

        List<Meal> meals = new ArrayList<>();
        MealDataHandler.addMeal(drink1);

//          MealDataHandler.getMeals();
//        for (Meal meal : meals) {
//            System.out.println(meal);
//        }
    }
}