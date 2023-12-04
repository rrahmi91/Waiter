package com.restaurant.user.UserVerifier;

import com.restaurant.user.User;

import java.util.List;


public class UserVerifier  {
    protected final PasswordVerification passwordVerification = new PasswordVerification();
    protected final UserNameVerification userNameVerification = new UserNameVerification();
    public String createUserName(String userName, List<User> getAllPersonal) {

            if (userNameVerification.verificationUserName(userName,getAllPersonal)) {
                return userName;
            }else{
                System.out.println("\u001B[31mНевалидно потребителско име или съществуващ.\u001B[0m");
                return null;
            }
    }

    public String createPassword(String password) {

        if (passwordVerification.verificationPassword(password)){
            return password;
        }else{
            return null;
        }
    }
}
