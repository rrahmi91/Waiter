package com.restaurant.menu;

import com.restaurant.menu.Product.Base.Meal;
import com.restaurant.menu.Product.Drink;
import com.restaurant.menu.Product.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MealDataHandler {

    private static final String FILE_NAME = "meals.csv";

    public static void addMeal(Meal meal) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILE_NAME, true);
            fw.write(meal.toCSV() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void removeMeal(Meal meal) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File(FILE_NAME + ".temp");
        File bakFile = new File(FILE_NAME + ".bak");
        BufferedReader br = null;
        BufferedWriter bw = null;

        String lineToSkip = meal.toCSV();

        try {
            br = new BufferedReader(new FileReader(inputFile));
            bw = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = br.readLine()) != null) {
                if (line.equals(lineToSkip)) {
                    continue;
                }

                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        boolean backupFileCreated = inputFile.renameTo(bakFile);
        boolean tempFileCopied = tempFile.renameTo(inputFile);
        boolean backupFileDeleted = bakFile.delete();

        if(!backupFileCreated || !tempFileCopied || !backupFileDeleted) {
            System.out.println("Unable to copy the file");
        }
    }

    public static List<Meal> getMeals() {
        BufferedReader reader = null;

        List<Meal> meals = new ArrayList<Meal>();

        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                switch (values[0]) {
                    case "Product.Base.Food":
                        meals.add(new Food(values));
                        break;
                    case "Product.Drink":
                        meals.add(new Drink(values));
                        break;
                    default:
                        System.out.println("Unknown meal of type " + values[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return meals;
    }
}
