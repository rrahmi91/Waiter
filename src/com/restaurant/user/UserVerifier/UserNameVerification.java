package com.restaurant.user.UserVerifier;

import com.restaurant.user.User;

import java.util.List;

public class UserNameVerification {
    protected boolean verificationUserName(String userName, List<User> allPersonal) {
        boolean valid = true;
        if (userName.trim().isEmpty() || userName.length() < 4) {
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
}
