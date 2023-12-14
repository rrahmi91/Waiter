package com.resturant.userLogin;

import com.restaurant.user.Administrator;
import com.restaurant.user.User;
import com.restaurant.user.UserType;
import com.restaurant.user.Waiter;
import com.restaurant.userLogin.LoginMenager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoginMenagerTest {

    private LoginMenager loginManager;
    private List<User> allPersonal;

    @BeforeEach
    void setUp() {
        allPersonal = new ArrayList<>();
        allPersonal.add(new Administrator("admin", "adminPass", UserType.ADMINISTRATOR));
        allPersonal.add(new Waiter("Rahmi", "Rahmi123*", UserType.WAITER));

        loginManager = new LoginMenager(allPersonal, "admin", "adminPass");
    }

    @Test
    void testLoginAdministrator() {
        // GIVEN
        String adminUserName = "admin";
        String adminPassword = "adminPass";

        // WHEN
        User loggedInUser = loginManager.login(adminUserName, adminPassword);

        // THEN
        assertNotNull(loggedInUser);
        assertEquals(UserType.ADMINISTRATOR, loggedInUser.getRole());
    }

    @Test
    void testLoginUser() {
        // GIVEN
        String userName = "Rahmi";
        String password = "Rahmi123*";

        // WHEN
        User loggedInUser = loginManager.login(userName, password);

        // THEN
        assertNotNull(loggedInUser);
        assertEquals(UserType.WAITER, loggedInUser.getRole());
    }

    @Test
    void testLoginInvalidCredentials() {
        // GIVEN
        String userName = "invalidUser";
        String password = "invalidPass";

        // WHEN
        User loggedInUser = loginManager.login(userName, password);

        // THEN
        assertNull(loggedInUser);
    }

    @Test
    void testLogoutUser() {
        // GIVEN
        String userName = "Rahmi";
        loginManager.login(userName, "userPass");

        // WHEN
        loginManager.logOut(userName);

        // THEN
        User loggedOutUser = allPersonal.stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst()
                .orElse(null);

        assertNotNull(loggedOutUser);
        assertFalse(loggedOutUser.isLoggedIn());
    }

}
