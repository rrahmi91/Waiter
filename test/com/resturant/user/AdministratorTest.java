package com.resturant.user;

import com.restaurant.user.Administrator;
import com.restaurant.user.User;
import com.restaurant.user.UserType;
import com.restaurant.user.Waiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdministratorTest {
    @Test
    void testAddUser() {
        // GIVEN
        Administrator administrator = new Administrator("admin", "adminPass", UserType.ADMINISTRATOR, new ArrayList<>());

        // WHEN
        administrator.addUser("1", "Rahmi", "Rahmi123*");

        // THEN
        assertEquals(1, administrator.getAllPersonal().size());
        assertTrue(administrator.getAllPersonal().get(0) instanceof Waiter);
    }

    @Test
    void testRemoveExistingUser() {
        // GIVEN
        Administrator administrator = new Administrator("Rahmi", "adminPass", UserType.ADMINISTRATOR);

        // WHEN
        administrator.removeUser("Rahmi");

        // THEN
        assertEquals(0, administrator.getAllPersonal().size());
    }

    @Test
    void testRemoveNonExistingUser() {
        // GIVEN
        Administrator administrator = new Administrator("admin", "adminPass", UserType.ADMINISTRATOR);
        // WHEN
        administrator.removeUser("несъществуващ");

        // THEN
        assertEquals(0, administrator.getAllPersonal().size());
    }
}
