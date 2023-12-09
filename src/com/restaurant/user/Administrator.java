package com.restaurant.user;

import java.util.ArrayList;
import java.util.Optional;

public class Administrator extends User implements UserManageable {
    protected ArrayList<User> allPersonal;

    public Administrator(String userName, String password, UserType role, ArrayList<User> allPersonal) {
        super(userName, password, role);
        this.allPersonal = allPersonal;
    }
    public Administrator(String userName, String password, UserType role) {
        super(userName, password, role);
    }

    public ArrayList<User> getAllPersonal() {
        return allPersonal;
    }

    public void addUser(String selection,String userName, String password) {
        User newUser = createUser(selection,userName,password);
        if (newUser != null) {
            this.allPersonal.add(getAllPersonal().size(), newUser);
        }
    }

    private User createUser(String selection,String userName, String password) {
        UserType role = getUserType(selection);
        if (role != null) {
            switch (role) {
                case WAITER:
                    return new Waiter(userName, password, role);
                case COOK:
                    return new Cook(userName, password, role);
                default:
                    return null;
            }
        }

        return null;
    }

    private UserType getUserType(String selection) {
        switch (selection) {
            case "1":
                return UserType.WAITER;
            case "2":
                return UserType.COOK;
            default:
                return null;
        }
    }

    public void removeUser(String userName) {
        Optional<User> userToRemove = getAllPersonal()
                .stream()
                .filter(user -> user.getUserName().equals(userName))
                .findFirst();

        if (userToRemove.isPresent()) {
            getAllPersonal().remove(userToRemove.get());
            System.out.println("Потребител " + userName + " е изтрит");
        } else {
            System.out.println("Този потребител не съществува");
        }
    }
}
