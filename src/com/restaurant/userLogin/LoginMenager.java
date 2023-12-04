package com.restaurant.userLogin;

import com.restaurant.user.User;
import com.restaurant.user.UserType;

import java.util.List;
import java.util.Optional;

public class LoginMenager implements Loginable {
    protected List<User> allPersonal;
    private String userNameAdministrator;
    private String passwordAdministrator;

    public LoginMenager(List<User> allPersonal, String userNameAdministrator, String passwordAdministrator) {
        setAllPersonal(allPersonal);
        setUserUserNameAdministrator(userNameAdministrator);
        setPasswordAdministrator(passwordAdministrator);
    }

    public List<User> getAllPersonal() {
        return allPersonal;
    }

    public void setAllPersonal(List<User> allPersonal) {
        this.allPersonal = allPersonal;
    }

    public String getUserNameAdministrator() {
        return userNameAdministrator;
    }

    public void setUserUserNameAdministrator(String userUserNameAdministrator) {
        this.userNameAdministrator = userUserNameAdministrator;
    }

    public String getPasswordAdministrator() {
        return passwordAdministrator;
    }

    public void setPasswordAdministrator(String passwordAdministrator) {
        this.passwordAdministrator = passwordAdministrator;
    }

    @Override
    public UserType login(String userNameFromConsole, String passwordFromConsole) {
        UserType userType = null;
        if (getUserNameAdministrator().equals(userNameFromConsole) && getPasswordAdministrator().equals(passwordFromConsole)) {
            userType = UserType.ADMINISTRATOR;
            System.out.println("Успешен вход като администратор: ");

        } else {
            for (int i = 0; i < getAllPersonal().size(); i++) {
                if (getAllPersonal().get(i).getUserName().equals(userNameFromConsole) && getAllPersonal().get(i).getPassword().equals(passwordFromConsole)) {
                    getAllPersonal().get(i).setLoggedIn(true);
                    userType = getAllPersonal().get(i).getRole();
                    System.out.println("Успешен вход за потребител: " + getAllPersonal().get(i).getUserName());
                    break;
                }
            }
        }
        if (userType == null) {
            System.out.println("\u001B[31m Грешно потребителско име или парола\u001B[0m\n");
        }
        return userType;
    }

    @Override
    public void logOut(String userName) {
        Optional<User> userLogOut = getAllPersonal()
                .stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst();

        if (userLogOut.isPresent()) {
            User userToLogOut = userLogOut.get();
            userToLogOut.setLoggedIn(false);
            System.out.println("Потребител " + userName + " е отписан");
        } else {
            System.out.println("Този потребител не съществува");
        }
    }

}
