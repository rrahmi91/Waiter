package com.restaurant.user;

import java.util.ArrayList;
import java.util.Scanner;

public class InteractingWithConsole {
    public final ArrayList<User> personal = new ArrayList<>();
    public final Administrator administrator = new Administrator("ADMIN", "Admin123*", UserType.ADMINISTRATOR, personal);

    public void userMenageInterfaceAddUser(Scanner scanner) {
        String selection;
        label:
        while (true) {
            System.out.println("+----------------------------------------------------+");
            System.out.println("|         ИЗБЕРЕТЕ ЕДИН ОТ СЛЕДНИТЕ ОПЦИИ            |");
            System.out.println("|   1. За създаване на потребител сервитьор          |");
            System.out.println("|   2. За създаване на потребител готвач             |");
            System.out.println("|   3. За премахване потребител                      |");
            System.out.println("|   4. За принтиране на информация за потребители    |");
            System.out.println("|  За изход въведете произволен символ или символи.  |");
            System.out.println("+----------------------------------------------------+");
            selection = scanner.nextLine();
            switch (selection) {
                case "1":
                case "2":
                    administrator.addUser(selection);
                    break;
                case "3":
                    System.out.println("Моля въведете потребителско име, който искате да премахнете");
                    String userName = scanner.nextLine();
                    administrator.removeUser(userName);
                    break;
                case "4":
                    personal.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Избран изход");
                    break label;
            }
        }
    }
    public void mainRestaurantMenu(Scanner scanner){

    }
}