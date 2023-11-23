package com.restaurant.user;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Main {
    public static List<User> createUser(){
        ArrayList<User> personal = new ArrayList<>();
        Administrator administrator = new Administrator("ADMIN", "Admin123*", "Administrator", personal);
        administrator.addUser(Administrator.scanner);
        personal = administrator.getAllPersonal();

        for (int i = 0; i < personal.size(); i++) {
            System.out.println("-".repeat(20));
            System.out.println(personal.get(i).getUserName());
            System.out.println(personal.get(i).getPassword());
            System.out.println(personal.get(i).getRole());
            System.out.println("-".repeat(20));
        }
        return personal;
    }
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Форматиране на датата и часа
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Извеждане на резултата
        System.out.println("Текуща дата и час: " + formattedDateTime);
    }
        //System.out.println(createUser().size());
    //}
}