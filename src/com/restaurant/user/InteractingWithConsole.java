package com.restaurant.user;

import com.restaurant.user.UserVerifier.UserVerifier;

import java.util.ArrayList;
import java.util.Scanner;

public class InteractingWithConsole {
    public final ArrayList<User> personal = new ArrayList<>();
    public final Administrator administrator = new Administrator("ADMIN", "Admin123*", UserType.ADMINISTRATOR, personal);
    private final UserVerifier userVerifier = new UserVerifier();

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
                    String NewUserName = readUserNameFromConsole(scanner);
                    String password = readPasswordFromConsole(scanner);
                    administrator.addUser(selection, NewUserName, password);
                    break;
                case "3":
                    System.out.println("Моля въведете потребителско име, който искате да премахнете");
                    String userNameToDelete = scanner.nextLine();
                    administrator.removeUser(userNameToDelete);
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

    private String readUserNameFromConsole(Scanner scanner) {
        String userNameReaded;
        do {
            System.out.println("Моля въведете потребителско име");
            userNameReaded = scanner.nextLine();
        } while (userVerifier.createUserName(userNameReaded, personal) == null);
        return userNameReaded;
    }

    private String readPasswordFromConsole(Scanner scanner) {
        String passwordReaded;
        do {
            System.out.println("Моля въведете парола");
            passwordReaded = scanner.nextLine();
        } while (userVerifier.createPassword(passwordReaded) == null);
        return passwordReaded;
    }

    private void mainRestaurantMenu(Scanner scanner) {

    }
}