package com.restaurant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeRaider {
    public static String getCurrentDateTime() {

        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return currentDateTime.format(formatter);
    }
}

