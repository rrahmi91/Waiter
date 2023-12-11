package com.restaurant.user;
public abstract class User{
    protected String userName;
    private String password;
    private UserType role;
    private boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }


    public User() {
        this.userName = "Not entered";
        this.password = "Not entered";
        this.role = UserType.ADMINISTRATOR;
        this.isLoggedIn = false;
    }

    public User(String userName, String password, UserType role) {
        setUserName(userName);
        setPassword(password);
        setRole(role);
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

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "Потребителско име --> '" + userName + '\'' +
                ", Парола --> '" + password + '\'' +
                ", Длъжност --> " + role +'\'' +
                ", LOGIN --> " + isLoggedIn +
                '}';
    }
}

