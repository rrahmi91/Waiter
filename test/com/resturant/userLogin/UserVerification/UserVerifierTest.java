package com.resturant.userLogin.UserVerification;

import com.restaurant.user.Cook;
import com.restaurant.user.User;
import com.restaurant.user.UserVerifier.UserVerifier;
import com.restaurant.user.Waiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserVerifierTest {

    @Test
    void testCreateValidUserName() {
        // GIVEN
        UserVerifier userVerifier = new UserVerifier();
        List<User> allPersonal = new ArrayList<>();
        allPersonal.add(new Cook("Saliha", "password", null));

        // WHEN
        String validUserName = userVerifier.createUserName("Petranka", allPersonal);

        // THEN
        assertNotNull(validUserName);
        assertEquals("Petranka", validUserName);
    }

    @Test
    void testCreateInvalidUserName() {
        // GIVEN
        UserVerifier userVerifier = new UserVerifier();
        List<User> allPersonal = new ArrayList<>();
        allPersonal.add(new Waiter("Rahmi", "password", null));

        // WHEN
        String invalidUserName = userVerifier.createUserName("Rahmi", allPersonal);

        // THEN
        assertNull(invalidUserName);
    }

    @Test
    void testCreateValidPassword() {
        // GIVEN
        UserVerifier userVerifier = new UserVerifier();

        // WHEN
        String validPassword = userVerifier.createPassword("Rahmi123*");

        // THEN
        assertNotNull(validPassword);
        assertEquals("Rahmi123*", validPassword);
    }

    @Test
    void testCreateInvalidPassword() {
        // GIVEN
        UserVerifier userVerifier = new UserVerifier();

        // WHEN
        String invalidPassword = userVerifier.createPassword("short");

        // THEN
        assertNull(invalidPassword);
    }
}
