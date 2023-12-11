package com.restaurant.FileHandler;

import com.restaurant.order.Table;
import com.restaurant.user.Cook;
import com.restaurant.user.User;
import com.restaurant.user.UserType;
import com.restaurant.user.Waiter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements FileReadable, FileWritable {
    private static final String USER_FILE_PATH = "User_Data.txt";
    private static final String ORDER_FILE_PATH = "Order_Data.txt";
    public ArrayList<User> personal;
    private List<Table> tables;

    public FileHandler(ArrayList<User> personal) {
        this.personal = personal;
    }

    public FileHandler(List<Table> tables) {
        this.tables = tables;
    }

    public ArrayList<User> getPersonal() {
        return personal;
    }

    public List<Table> getTables() {
        return tables;
    }

    @Override
    public String readFile() {
        String line = "";
        StringBuilder resultText = new StringBuilder();
        try {
            File file = new File(USER_FILE_PATH);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    resultText.append(line).append("\n");
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultText.toString();
    }


    @Override
    public void writeToFile() {
        String userDataAsString = convertUserDataToString();
        FileWriter writer = null;
        try {
            writer = new FileWriter(USER_FILE_PATH);
            writer.write(userDataAsString);
            System.out.println("Файлът е създаден успешно.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Грешка при създаване на файла: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                    System.out.println("Затворен");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Грешка при затваряне на файла: " + e.getMessage());
            }
        }
    }

    private String convertUserDataToString() {
        StringBuilder dataToArchive = new StringBuilder();
        for (int i = 0; i < personal.size(); i++) {
            String userName = personal.get(i).getUserName();
            String password = personal.get(i).getPassword();
            String role = String.valueOf(personal.get(i).getRole());
            dataToArchive.append("userName:").append(userName)
                    .append(",password:").append(password)
                    .append(",role:").append(role)
                    .append("\n");
        }
        return dataToArchive.toString();
    }

    public void updatePersonalDataFromFile() {
        String userDataFromFile = readFile();
        List<User> userListFromFile = convertStringToUsers(userDataFromFile);

        List<User> anotherUserList = new ArrayList<>(userListFromFile);
        personal.clear();
        personal.addAll(anotherUserList);
    }

    private static List<User> convertStringToUsers(String data) {
        List<User> userList = new ArrayList<>();
        String[] userStrings = data.split("\n");

        for (String userString : userStrings) {
            User user = convertStringToUser(userString);
            if (user != null) {
                userList.add(user);
            }
        }

        return userList;
    }

    private static User convertStringToUser(String userString) {
        String[] userAttributes = userString.split(",");

        String userName = null;
        String password = null;
        String role = null;

        for (String attribute : userAttributes) {
            String[] parts = attribute.split(":");
            if (parts.length == 2) {
                String key = parts[0];
                String value = parts[1];

                switch (key) {
                    case "userName":
                        userName = value;
                        break;
                    case "password":
                        password = value;
                        break;
                    case "role":
                        role = value;
                        break;
                }
            }
        }

        if (userName != null && password != null && role != null) {
            return createUser(userName, password, UserType.valueOf(role));
        }

        return null;
    }

    private static User createUser(String userName, String password, UserType role) {
        switch (role) {
            case COOK:
                return new Cook(userName, password, role);
            case WAITER:
                return new Waiter(userName, password, role);
            default:
                throw new IllegalArgumentException("Неподдържана роля: " + role);
        }
    }
}
