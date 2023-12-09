package com.restaurant.userLogin;

import com.restaurant.user.User;
public interface Loginable {

    public User login(String userName, String password);

    public void logOut(String userName);
}
