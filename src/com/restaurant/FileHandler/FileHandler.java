package com.restaurant.FileHandler;

import com.restaurant.order.Table;
import com.restaurant.user.User;
import org.w3c.dom.ls.LSOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements FileReadable,FileWritable{
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


        return null;
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
        }finally {
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
    private String convertUserDataToString(){
        StringBuilder dataToArchive = new StringBuilder();
        for (int i = 0; i <personal.size(); i++) {
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
}
