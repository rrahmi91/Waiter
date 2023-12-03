package com.restaurant;

import com.restaurant.user.Administrator;
import com.restaurant.user.User;
import com.restaurant.user.UserType;
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

    public String restaurantMenageMainMenuInterface(Scanner scanner) {
        System.out.println("+----------------------------------------------------+");
        System.out.println("|          ГУРМЕ РЕСТОРАНТ\"ЕКПЛОЗИЯ\"               |");
        System.out.println("|                 1. Вписване   (Login)              |");
        System.out.println("|                 2. Отписване  (LogOut)             |");
        System.out.println("|  За изход въведете произволен символ или символи.  |");
        System.out.println("+----------------------------------------------------+");
        if(personal.isEmpty()){
            System.out.println("\u001B[31mСистемата няма регистриран персонал.\u001B[0m\n" +
                    "\u001B[33mЗа да добавите персонал моля се влезте като администратор и създайте сервитьор и готвач.\u001B[0m");
        }else {
            return scanner.nextLine();
        }
        return null;
    }

    public String interfaceForReadOnLoginUsername(Scanner scanner){
        System.out.println("\t\t\t\"МОЛЯ ВЪВЕДЕТЕ ПОТРЕБИТЕЛСКО ИМЕ\"");
        return scanner.nextLine();
    }
    public String interfaceForReadOnLoginPassword(Scanner scanner){
        System.out.println("\t\t\t\"МОЛЯ ВЪВЕДЕТЕ ПАРОЛА\"");
        return scanner.nextLine();
    }
}