package com.resturant;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.restaurant.DateTimeRaider.getCurrentDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTimeRaiderTest {
    @Test
    void testGetCurrentDateTime() {
        // GIVEN

        // WHEN
        String result = getCurrentDateTime();

        // THEN
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String expectedDateTime = currentDateTime.format(formatter);

        assertEquals(expectedDateTime, result);
    }
}
