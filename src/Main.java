import java.util.ArrayList;
import java.util.List;
public class Main {
    public static List<User> createUser(){
        ArrayList<User> personal = new ArrayList<>();
        Administrator administrator = new Administrator("ADMIN", "Admin123*", "Administrator", personal);
        administrator.addUser(Administrator.scanner);
        personal =administrator.getAllPersonal();

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
        System.out.println(createUser().size());
    }
}