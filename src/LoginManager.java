import java.util.List;
import java.util.Scanner;

public class LoginManager {  // TODO: 12.11.2023 г. дали няма да е по добре да не е клас!!!
    Scanner scanner = new Scanner(System.in);
    private List<User> allPersonal;
    public List<User> getAllPersonal() {
        return allPersonal;
    }

    public void setAllPersonal(List<User> allPersonal) {
        this.allPersonal = allPersonal;
    }
    public LoginManager(List<User> allPersonal) {
        this.allPersonal = allPersonal;
    }

    public User addWaiter() {
        String userName = createUserName(scanner);
        String password = createPassword(scanner);
        String role = "waiter";
        return new Waiter(userName,password,role);
    }
    public User addCook() {
        String userName = createUserName(scanner);
        String password = createPassword(scanner);
        String role = "cook";
        return new Cook(userName,password,role);
    }


    private String createUserName(Scanner scanner) {
        String userName;
        while(true){
        System.out.println("Моля въвдете потребителско име");
            userName = scanner.nextLine();
            if(verificationUserName(getAllPersonal(),userName)){
                break;
            }
            System.out.println("Невалидно потребителско име или съществуващ");
        }


        return userName; // TODO: 12.11.2023 г. направи верификация
    }

    private String createPassword(Scanner scanner) {
        String password;
        do {
            System.out.println("Моля въведете парола");
            password = scanner.nextLine();                       // TODO: 12.11.2023 г.  Измисли начин за съобщение, че не коректна паролата.
        } while (!verificationPassword(password));

        return password;
    }

    private boolean verificationUserName(List<User> allPersonal, String userName) {
        boolean valid = true;
        for (int i = 0; i < allPersonal.size(); i++) {
            if (allPersonal.get(i).getUserName().equals(userName) || userName.length() < 4) {// TODO: 12.11.2023 г. тука е добре да се направи с exception.Може би
                valid = false;
                break;
            }
        }
        return valid;
    }

    private boolean verificationPassword(String password) {
        boolean valid = false;
        if (password.length() > 8) {
            valid = true;
        }
        return valid; // TODO: 12.11.2023 г. Напиши верификация
    }

    public void removeUser(List<User> allPersonal, String userName) {
        for (int i = 0; i < allPersonal.size(); i++) {
            if (allPersonal.get(i).getUserName().equals(userName)) {
                allPersonal.remove(i);
            }
        }
    }

}
