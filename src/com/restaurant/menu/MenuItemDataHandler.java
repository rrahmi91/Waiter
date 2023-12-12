package com.restaurant.menu;

import com.restaurant.menu.MenuItem.Base.MenuItem;
import com.restaurant.menu.MenuItem.Drink;
import com.restaurant.menu.MenuItem.Food;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDataHandler {

    private static final String FILE_NAME = "menuitems.csv";

    public static void addMenuItem(MenuItem menuItem) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILE_NAME, true);
            fw.write(menuItem.toCSV() + "\n");
            System.out.println("Записан в файла");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null) {
                try {
                    fw.close();
                    System.out.println("Затворен файл");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void removeMenuItem(MenuItem menuItem) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File(FILE_NAME + ".temp");
        File bakFile = new File(FILE_NAME + ".bak");
        BufferedReader br = null;
        BufferedWriter bw = null;

        String lineToSkip = menuItem.toCSV();
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

    public static List<MenuItem> getMenuItems() {
        BufferedReader reader = null;

        List<MenuItem> menuItems = new ArrayList<MenuItem>();

        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");

                switch (values[0]) {
                    case "Food":
                        menuItems.add(new Food(values));
                        break;
                    case "Drink":
                        menuItems.add(new Drink(values));
                        break;
                    default:
                        System.out.println("Unknown menu item of type " + values[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return menuItems;
    }

}