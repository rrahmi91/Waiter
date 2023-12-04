package com.restaurant.userLogin;

import com.restaurant.user.UserType;

public interface Loginable {

    public UserType login(String userName, String password);

    public void logOut(String userName);
}
