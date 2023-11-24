package com.restaurant.user;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InteractingWithConsole interactingWithConsole = new InteractingWithConsole();
        interactingWithConsole.userMenageInterfaceAddUser(scanner);
        scanner.close();
    }
}