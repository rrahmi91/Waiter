package com.restaurant.user;
public interface UserManageable {
    void addUser(String selection,String userName, String password);
    void removeUser(String userName);
}
