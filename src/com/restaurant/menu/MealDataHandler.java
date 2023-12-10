package com.restaurant.menu;

import com.restaurant.menu.Product.Base.Product;
import com.restaurant.menu.Product.Drink;
import com.restaurant.menu.Product.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MealDataHandler {

    private static final String FILE_NAME = "meals.csv";

    public static void addMeal(Product product) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILE_NAME, true);
            fw.write(product.toCSV() + "\n");
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

    public static void removeMeal(Product product) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File(FILE_NAME + ".temp");
        File bakFile = new File(FILE_NAME + ".bak");
        BufferedReader br = null;
        BufferedWriter bw = null;

        String lineToSkip = product.toCSV();

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

    public static List<Product> getMeals() {
        BufferedReader reader = null;

        List<Product> products = new ArrayList<Product>();

        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                switch (values[0]) {
                    case "Product.Base.Food":
                        products.add(new Food(values));
                        break;
                    case "Product.Drink":
                        products.add(new Drink(values));
                        break;
                    default:
                        System.out.println("Unknown meal of type " + values[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
