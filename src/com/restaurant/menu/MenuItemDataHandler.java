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
            System.out.println("Записан във файла");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
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
        BufferedReader br = null;

        String lineToSkip = menuItem.toCSV();
        System.out.println(lineToSkip);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(lineToSkip)) {
                    continue;
                }
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                    String newFileContents = stringBuilder.toString();
                    FileWriter fileWriterName = new FileWriter(FILE_NAME, false);
                    PrintWriter out = new PrintWriter(fileWriterName);
                    out.print(newFileContents);
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static List<MenuItem> getMenuItems() {
        BufferedReader reader = null;
        FileReader fileReader = null;
        List<MenuItem> menuItems = new ArrayList<MenuItem>();

        try {
            fileReader = new FileReader(FILE_NAME);
            reader = new BufferedReader(fileReader);
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
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                  e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return menuItems;
    }

}