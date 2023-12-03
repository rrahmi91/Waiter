package com.restaurant;

import java.util.Scanner;

public class Main {
    protected static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        interactingWithConsole.userMenageInterfaceAddUser(scanner);
        scanner.close();
    }
}