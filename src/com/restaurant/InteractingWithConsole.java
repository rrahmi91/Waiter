package com.restaurant;

import com.restaurant.user.Administrator;
import com.restaurant.user.User;
import com.restaurant.user.UserType;
import com.restaurant.user.UserVerifier.UserVerifier;
import com.restaurant.userLogin.LoginMenager;
import com.restaurant.userLogin.Loginable;

import java.util.ArrayList;
import java.util.Scanner;

public class InteractingWithConsole {
    public final ArrayList<User> personal = new ArrayList<>();
    public final Administrator administrator = new Administrator("Admin", "Admin123*", UserType.ADMINISTRATOR, personal);
    private final UserVerifier userVerifier = new UserVerifier();
    private final Loginable loginable = new LoginMenager(personal, administrator.getUserName(), administrator.getPassword());

    public void restaurantMenageMainMenuInterface(Scanner scanner) {
        String selection;
        label:
        while (true) {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|                  ГУРМЕ РЕСТОРАНТ\"ЕКСПЛОЗИЯ\"                       |");
            System.out.println("|                   1. Вписване   (Login)                          |");
            System.out.println("|                   2. Отписване  (LogOut)                         |");
            System.out.println("|  За изход от програмата въведете произволен символ или символи.  |");
            System.out.println("+------------------------------------------------------------------+");
            if (personal.isEmpty()) {
                System.out.println("\u001B[31mСистемата няма регистриран персонал.\u001B[0m\n" +
                        "\u001B[33mЗа да добавите персонал моля се влезте като администратор и създайте сервитьор и готвач.\u001B[0m");
            }
            System.out.println("\nВъведете вашия избор: ");
            selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    interfaceForReadOnLogin(scanner); return;
                case "2":
                    return;
                default:
                    System.out.println("Избран изход");
                    break label;

            }
        }
    }

    public void userMenageInterfaceAddUser(Scanner scanner) {
        String selection;
        label:
        while (true) {
            System.out.println("+----------------------------------------------------------------+");
            System.out.println("|               ИЗБЕРЕТЕ ЕДИН ОТ СЛЕДНИТЕ ОПЦИИ                  |");
            System.out.println("|           1. За създаване на потребител сервитьор              |");
            System.out.println("|           2. За създаване на потребител готвач                 |");
            System.out.println("|           3. За премахване потребител                          |");
            System.out.println("|           4. За принтиране на информация за потребители        |");
            System.out.println("|  За отписване и изход въведете произволен символ или символи.  |");
            System.out.println("+----------------------------------------------------------------+");
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
                    administrator.setLoggedIn(false);
                    restaurantMenageMainMenuInterface(scanner);
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

    public void interfaceForReadOnLogin(Scanner scanner) {
        String userName = interfaceForReadOnLoginUsername(scanner);
        String password = interfaceForReadOnLoginPassword(scanner);
        UserType userType = loginable.login(userName, password);
        if (!(userType == null)) {
            if (userType.equals(UserType.ADMINISTRATOR)) {
                administrator.setLoggedIn(true);
                userMenageInterfaceAddUser(scanner);
            } else if (userType.equals(UserType.WAITER)) {
                interfaceWaiter(scanner, userName);
            } else if (userType.equals(UserType.COOK)) {
                interfaceCook(scanner);
            }
        } else {
            interfaceForReadOnLogin(scanner);// TODO: 4.12.2023 г. да се ръща пак в начало;
        }

    }

    private String interfaceForReadOnLoginUsername(Scanner scanner) {
        System.out.println("\t\t\t\"МОЛЯ ВЪВЕДЕТЕ ПОТРЕБИТЕЛСКО ИМЕ\"");
        return scanner.nextLine();
    }

    private String interfaceForReadOnLoginPassword(Scanner scanner) {
        System.out.println("\t\t\t\"МОЛЯ ВЪВЕДЕТЕ ПАРОЛА\"");
        return scanner.nextLine();
    }

    private void interfaceWaiter(Scanner scanner, String activUserName) {
        String selection;
        label:
        while (true) {
            System.out.println("+-------------------------------------------------------------------------------+");
            System.out.println("|                  ГУРМЕ РЕСТОРАНТ\"ЕКСПЛОЗИЯ\"                                 |");
            System.out.println("|                   1. Създаване на поръчка                                     |");
            System.out.println("|                   2. Преглед на поръчки                                       |");
            System.out.println("|                   3. Редактиране на поръчка                                   |");
            System.out.println("|                   4. Преглед на меню                                          |");
            System.out.println("|                   5. Редактиране на меню                                      |");
            System.out.println("|  За изход от програмата и отписване въведете произволен символ или символи.   |");
            System.out.println("+-------------------------------------------------------------------------------+");
            System.out.println("\nВъведете вашия избор: ");
            selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    // TODO: 4.12.2023 г. Tуka ще идва метода за създаване на поръзка
                    break;
                case "2":
                    // TODO: 4.12.2023 г. Tуka ще идва метода за преглед
                    break;
                case "3":
                    // TODO: 4.12.2023 г. Тука ще идва метода за редактиране на поръчка
                    break;
                case "4":
                    // TODO: 4.12.2023 г. Тука ще идва метода преглед на меню
                    break;
                case "5":
                    // TODO: 4.12.2023 г. Тука ще идва метода за редактиране на меню
                    break;
                default:
                    System.out.println("Избран изход");
                    loginable.logOut(activUserName);
                    restaurantMenageMainMenuInterface(scanner);
                    break label;
            }
        }
    }

    private void interfaceCook(Scanner scanner) {
        String selection;
        label:
        while (true) {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|                  ГУРМЕ РЕСТОРАНТ\"ЕКСПЛОЗИЯ\"                       |");
            System.out.println("|                   1. Преглед на поръчки                           |");
            System.out.println("|                   2. Редактиране на поръчка                       |");
            System.out.println("|  За изход от програмата въведете произволен символ или символи.   |");
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("\nВъведете вашия избор: ");
            selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    // TODO: 4.12.2023 г. Tуka ще идва метода за предглед поръчки
                    break ;
                case "2":
                    // TODO: 4.12.2023 г. Tуka ще идва метода смяна на статуса
                    break ;
                default:
                    System.out.println("Избран изход");
                    break label;

            }
        }
    }
}