package com.restaurant.user;
import java.util.ArrayList;
import java.util.Scanner;

public class Administrator extends User implements UserManageable {
    public static Scanner scanner = new Scanner(System.in);
    protected ArrayList<User> allPersonal;
    public Administrator(String userName, String password, UserType role, ArrayList<User> allPersonal) {
        super(userName, password, role);
        this.allPersonal = allPersonal;
    }

    public ArrayList<User> getAllPersonal() {
        return allPersonal;
    }
    public void addUser(Scanner scanner) {
        User newUser;
        while (true) {
            System.out.println("Моля изберете вид персонал, който искате да добавите:");
            System.out.println("1. За сервитьор");
            System.out.println("2. За готвач");
            System.out.println("За изход въведете произволен символ или символи.");

            String selection = scanner.nextLine();

            if (selection.equals("1")) {
                newUser = addWaiter();
            } else if (selection.equals("2")) {
                newUser = addCook();
            } else {
                System.out.println("Избран изход.");
                break;
            }
            this.allPersonal.add(getAllPersonal().size(), newUser);
        }
    }
    private User addWaiter() {
        String userName = createUserName(scanner);
        String password = createPassword(scanner);
        UserType role=UserType.WAITER;

        return new Waiter(userName, password, role);
    }
    private User addCook() {
        String userName = createUserName(scanner);
        String password = createPassword(scanner);
        String role = "Готвач";

        return new Cook(userName, password, role);
    }
    private String createUserName(Scanner scanner) {
        String userName;
        while (true) {
            System.out.println("Моля въвдете потребителско име");
            userName = scanner.nextLine();
            if (verificationUserName(userName)) {
                break;
            }
            System.out.println("\u001B[31mНевалидно потребителско име или съществуващ.\u001B[0m");
        }

        return userName;
    }
    private String createPassword(Scanner scanner) {
        String password;
        do {
            System.out.println("Моля въведете парола");
            password = scanner.nextLine();
        } while (!verificationPassword(password));

        return password;
    }
    private boolean verificationUserName(String userName) {
        boolean valid = true;

        if (userName.trim().isEmpty() || userName.length() <4) {
            valid = false;
        } else {
            for (User user : allPersonal) {
                if (user.getUserName().equals(userName)) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
    private boolean verificationPassword(String password) {
        boolean valid = false;
        try {
            if (password == null || password.trim().isEmpty()) {
                throw new IllegalArgumentException("\u001B[33mНеможе да създадете парола с интервал\u001B[0m");
            }
            if (password.length() <= 8) {
                throw new IllegalArgumentException("\u001B[33mДължината на поролата трябва да е >=8\u001B[0m");
            }
            valid = verificationPasswordCharacters(password);

            if (!valid) {
                throw new IllegalArgumentException("\u001B[33mПоролата трябва да съдържа поне една главна и малка буква и символ\u001B[0m");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\u001B[33mНевалидна парола: \u001B[0m" + e.getMessage());
        }
        return valid;
    }
    private boolean verificationPasswordCharacters(String password) {
        boolean charValid = false;
        boolean uppercaseValid = false;
        boolean lowercaseValid = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                uppercaseValid = true;
            }
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                charValid = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                lowercaseValid = true;
            }
        }

        return charValid && uppercaseValid && lowercaseValid;
    }
    public void removeUser(String userName) {
        for (int i = 0; i < getAllPersonal().size(); i++) {
            if (getAllPersonal().get(i).getUserName().equals(userName)) {
                System.out.println("Потребител "+getAllPersonal().get(i).getUserName()+" е изтрит");
                getAllPersonal().remove(i);
            }else{
                System.out.println("Този потребител не съществува");
            }
        }
    }
}
