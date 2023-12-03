package com.restaurant.userLogin;

import com.restaurant.user.User;

import java.util.List;

public class LoginMenager implements Loginable{
    protected String userName;
    protected String password;
    protected List<User> allPersonal;

    public LoginMenager(String userName, String password, List<User> allPersonal) {
        this.userName = userName;
        this.password = password;
        this.allPersonal = allPersonal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getAllPersonal() {
        return allPersonal;
    }

    public void setAllPersonal(List<User> allPersonal) {
        this.allPersonal = allPersonal;
    }

    @Override
    public void login(String userName, String password) {
        boolean found = false;
        for (int i = 0; i < getAllPersonal().size(); i++) {
            if(getAllPersonal().get(i).getUserName().equals(userName) && getAllPersonal().get(i).getPassword().equals(password)){
                getAllPersonal().get(i).setLoggedIn(true);
                found = true;
                System.out.println("Успешен вход за потребител: " + getAllPersonal().get(i).getUserName());
                break;
            }
        }
        if (!found) {
            System.out.println("Грешно потребителско име или парола");
        }

    }

    @Override
    public void logOut(String userName, String password) {

    }

}
