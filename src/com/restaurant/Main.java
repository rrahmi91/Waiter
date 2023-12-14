package com.restaurant;
import java.util.Scanner;

public class Main {
    public static final InteractingWithConsole interactingWithConsole = new InteractingWithConsole();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        interactingWithConsole.restaurantMenageMainMenuInterface(scanner);
    }
}