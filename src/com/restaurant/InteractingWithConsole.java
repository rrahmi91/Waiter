package com.restaurant;

import com.restaurant.FileHandler.FileHandler;
import com.restaurant.menu.Product;
import com.restaurant.order.Changeable;
import com.restaurant.order.Order;

import com.restaurant.order.TableStatus;
import com.restaurant.user.*;
import com.restaurant.user.UserVerifier.UserVerifier;
import com.restaurant.userLogin.LoginMenager;
import com.restaurant.userLogin.Loginable;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class InteractingWithConsole {
    public final ArrayList<User> personal = new ArrayList<>();
    private final Restaurant restaurant = new Restaurant();
    public final Administrator administrator = new Administrator("Admin", "Admin123*", UserType.ADMINISTRATOR, personal);
    private final UserVerifier userVerifier = new UserVerifier();
    private final Loginable loginable = new LoginMenager(personal, administrator.getUserName(), administrator.getPassword());
    private final Changeable changeableWaiter = new Waiter();
    private final Changeable changeableCook = new Cook();
    private static User loginedUser = null;

    public void restaurantMenageMainMenuInterface(Scanner scanner) {
        administrator.addUser("1", "Rahmi", "Rahmi123*"); // TODO: 4.12.2023 г. за тест изтрий после
        administrator.addUser("2", "Saliha", "Saliha123*");// TODO: 4.12.2023 г. за тест изтрий после
        String selection;
        label:
        while (true) {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|                  ГУРМЕ РЕСТОРАНТ\"ЕКСПЛОЗИЯ\"                      |");
            System.out.println("|                   1. Вписване   (Login)                          |");
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
                    interfaceForReadOnLogin(scanner);
                    return;
                case "2":
                    return;
                default:
                    System.out.println("Избран изход");
                    break label;
            }
        }
    }

    private void userMenageInterfaceAddUser(Scanner scanner) {
        String selection;
        label:
        while (true) {
            System.out.println("+----------------------------------------------------------------+");
            System.out.println("|               ИЗБЕРЕТЕ ЕДИН ОТ СЛЕДНИТЕ ОПЦИИ                   |");
            System.out.println("|           1. За създаване на потребител сервитьор              |");
            System.out.println("|           2. За създаване на потребител готвач                 |");
            System.out.println("|           3. За премахване потребител                          |");
            System.out.println("|           4. За принтиране на информация за потребители        |");
            System.out.println("|  За отписване въведете произволен символ или символи.          |");
            System.out.println("+----------------------------------------------------------------+");
            selection = scanner.nextLine();
            switch (selection) {
                case "1":
                case "2":
                    String newUserName = readUserNameFromConsole(scanner);
                    String password = readPasswordFromConsole(scanner);
                    administrator.addUser(selection, newUserName, password);
                    break;
                case "3":
                    System.out.println("Моля въведете потребителско име, който искате да премахнете");
                    String userNameToDelete = scanner.next();
                    administrator.removeUser(userNameToDelete);
                    break;
                case "4":
                    personal.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Избран изход");
                    FileHandler userdata = new FileHandler(personal);
                    userdata.writeToFile();
                    administrator.setLoggedIn(false);
                    restaurantMenageMainMenuInterface(scanner);
                    loginedUser = null;
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

    private void interfaceForReadOnLogin(Scanner scanner) {
        String userName = interfaceForReadOnLoginUsername(scanner);
        String password = interfaceForReadOnLoginPassword(scanner);
        loginedUser = loginable.login(userName, password);

        if (!(loginedUser == null)) {
            if (loginedUser.getRole().equals(UserType.ADMINISTRATOR)) {
                administrator.setLoggedIn(true);
                userMenageInterfaceAddUser(scanner);
            } else if (loginedUser.getRole().equals(UserType.WAITER)) {
                interfaceWaiter(scanner, loginedUser.getUserName());
            } else if (loginedUser.getRole().equals(UserType.COOK)) {
                interfaceCook(scanner, loginedUser.getUserName());
            }
        } else {
            interfaceForReadOnLogin(scanner);;
        }
    }

    //***********************************************************************************
    private void interfaceAddProductToOrder(Scanner scanner) {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|               ИЗБЕРЕТЕ ЕДИН ОТ СЛЕДНИТЕ ОПЦИИ                   |");
        System.out.println("|           1. Ястия                                             |");
        System.out.println("|           2. Питиета                                           |");
        System.out.println("|  За стъпка назад въведете произволен символ или символи.       |");
        System.out.println("+----------------------------------------------------------------+");
        String readResponse = scanner.nextLine();
        if (readResponse.equals("1")) {
            interfaceAddDish(scanner);
        } else if (readResponse.equals("2")) {
            interfaceAddDrinks(scanner);
        } else {
            interfaceWaiter(scanner, loginedUser.getUserName());
        }
    }

    private void interfaceAddDish(Scanner scanner) {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|               ИЗБЕРЕТЕ ЕДИН ОТ СЛЕДНИТЕ ОПЦИИ                   |");
        System.out.println("|           1. Осноно меню                                       |");
        System.out.println("|           2. Супа                                              |");
        System.out.println("|           3. Саладка                                           |");
        System.out.println("|           4. Десерт                                            |");
        System.out.println("|  За стъпка назад въведете произволен символ или символи.       |");
        System.out.println("+----------------------------------------------------------------+");
        String selection = scanner.nextLine();
        switch (selection) {
            case "1":
                break;
            case "2":
                break;
            case "3":

                break;
            case "4":

                break;
            case "5":
            default:
                interfaceAddProductToOrder(scanner);
        }
    }

    private void interfaceAddDrinks(Scanner scanner) {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|               ИЗБЕРЕТЕ ЕДИН ОТ СЛЕДНИТЕ ОПЦИИ                   |");
        System.out.println("|           1. Алкохолни                                         |");
        System.out.println("|           3. Топли напитки                                     |");
        System.out.println("|           4. Сокове                                            |");
        System.out.println("|           5. Води                                              |");
        System.out.println("|  За стъпка назад въведете произволен символ или символи.       |");
        System.out.println("+----------------------------------------------------------------+");
        String selection = scanner.nextLine();
        switch (selection) {
            case "1":
                break;
            case "2":

                break;
            case "3":

                break;
            case "4":

                break;
            case "5":
            default:
                interfaceAddProductToOrder(scanner);
        }
    }

    //***********************************************************************************
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
        int index = findUserIndex(activUserName);
        label:
        while (true) {
            System.out.println("+-------------------------------------------------------------------------------+");
            System.out.println("|                  ГУРМЕ РЕСТОРАНТ\"ЕКСПЛОЗИЯ\"                                   |");
            System.out.println("|                   1. Създаване на поръчка                                     |");
            System.out.println("|                   2. Преглед на поръчки                                       |");
            System.out.println("|                   3. Редактиране на поръчка                                   |");
            System.out.println("|                   4. Преглед на меню                                          |");
            System.out.println("|                   5. Редактиране на меню                                      |");
            System.out.println("|       За отписване въведете произволен символ или символи.                    |");
            System.out.println("+-------------------------------------------------------------------------------+");
            System.out.println("\nВъведете вашия избор: ");
            selection = scanner.nextLine();
            switch (selection) {
                case "1":
                    Waiter waiter = (Waiter) personal.get(index);
                    Order newOrder = waiter.createOrder();
                    interfaceCreateOrder(scanner, newOrder);
                    break;
                case "2":
                    printActivOrder();
                    break;
                case "3":
                    interfaceWaiterEditOrder(scanner);
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
                    loginedUser = null;
                    break label;
            }
        }
    }

    private void interfaceWaiterEditOrder(Scanner scanner) {
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("|                  ГУРМЕ РЕСТОРАНТ\"ЕКСПЛОЗИЯ\"                      |");
        System.out.println("|                   1. Добавяне на продтукт                        |");
        System.out.println("|                   2. Премахване на продукт                       |");
        System.out.println("|                   3. Смяна на статуса на поръчка                 |");
        System.out.println("|        За стъпка НАЗАД въведете произволен символ или символи.   |");
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("\nВъведете вашия избор: ");
        String selection = scanner.nextLine();
        switch (selection) {
            case "1":
                break;
            case "2":

                break;
            case "3":
                editOrderStatusInterface(scanner);
            default:
                System.out.println("Избран стъпка назад");
                interfaceWaiter(scanner, loginedUser.getUserName());
        }
    }

    private void interfaceCook(Scanner scanner, String activUserName) {
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
                    printActivOrder();
                    break;
                case "2":
                    editOrderStatusInterface(scanner);
                    break;
                default:
                    System.out.println("Избран изход");
                    loginable.logOut(activUserName);
                    restaurantMenageMainMenuInterface(scanner);
                    loginedUser = null;
                    break label;
            }
        }
    }

    private void interfaceCreateOrder(Scanner scanner, Order order) {
        int readTableNumber = readTableNumberFromUser(scanner);
        restaurant.assignOrderToTable(order, readTableNumber);
        interfaceWaiter(scanner, loginedUser.getUserName());
    }

    private int findUserIndex(String userName) {
        for (int i = 0; i < personal.size(); i++) {
            if (personal.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return 0;
    }

    private void printActivOrder() {
        restaurant.getTables().stream()
                .filter(table -> table.getTableStatus() != TableStatus.FREE)
                .forEach(System.out::println);
        if (restaurant.getTables().stream().noneMatch(table -> table.getTableStatus() != TableStatus.FREE)) {
            System.out.println("Няма активни поръчки.");
        }
    }

    private void editOrderStatusInterface(Scanner scanner) {
        int selectedTableNumber = readTableNumberFromUser(scanner);

        if (selectedTableNumber >= 0 && selectedTableNumber <= restaurant.getTables().size()) {
            if (restaurant.getTables().get(selectedTableNumber).getTableStatus() != null) {
                System.out.println(restaurant.getTables().get(selectedTableNumber));
                updateOrderStatusForTable(scanner, selectedTableNumber);
            } else {
                System.out.println("В тази маса няма създадена поръчка и не може да се редактира");
            }
        } else {
            System.out.println("Не съшествуваща маса");
        }
    }

    private int readTableNumberFromUser(Scanner scanner) {
        System.out.println("Моля въведете номер на маса");
        String tableNumberReadFromUser = scanner.nextLine();
        return validateInputFromUser(tableNumberReadFromUser);
    }

    private int validateInputFromUser(String input) {
        try {
            int integerInput = Integer.parseInt(input);
            if (integerInput >= 0 && integerInput <= restaurant.getTables().size()) {
                if (restaurant.getTables().get(integerInput - 1).getTableStatus() != null) {
                    return restaurant.getTables().get(integerInput - 1).getTableNumber();
                } else {
                    System.out.println("В тази маса няма създадена поръчка и не може да се редактира");
                    return -1;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Невалиден вход за избор. Възникна грешка: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Индексът е извън границите на списъка. Възникна грешка: " + e.getMessage());
        }
        return -1;
    }

    private void updateOrderStatusForTable(Scanner scanner, int tableNumber) {

        System.out.println("Моля изберете един от следните опции");

        if (loginedUser.getRole().equals(UserType.COOK)) {
            System.out.println("\u001B[32m1. Сготвено");
            System.out.println("2. Готви се\u001B[0m");
        } else if (loginedUser.getRole().equals(UserType.WAITER)) {
            System.out.println("\u001B[32m1. Сервиран");
            System.out.println("2. Платен\u001B[0m");
        }
        String readSelection = scanner.nextLine();
        try {
            int selectedStatus = Integer.parseInt(readSelection);
            Order order = restaurant.getTables().get(tableNumber).getOrder();
            order = changeOrderStatusBasedOnRole(loginedUser.getRole(), order, selectedStatus);
            restaurant.getTables().get(tableNumber).setOrder(order);
        } catch (NumberFormatException e) {
            System.out.println("Невалиден вход за избор. Възникна грешка: " + e.getMessage());
        }

    }

    private Order changeOrderStatusBasedOnRole(UserType role, Order order, int selectedStatus) {

        if (role.equals(UserType.WAITER)) {
            return changeableWaiter.changeOrderStatus(order, selectedStatus);
        } else if (role.equals(UserType.COOK)) {
            return changeableCook.changeOrderStatus(order, selectedStatus);
        } else {
            return order;
        }
    }

}