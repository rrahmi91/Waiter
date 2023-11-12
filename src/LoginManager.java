import java.util.List;

public class LoginManager {  // TODO: 12.11.2023 г. дали няма да е по добре да не е клас!!! 
    public void addUser(User user) {

    }
    private String createUserName(){
        return "userName"; // TODO: 12.11.2023 г. Запъни после метода 
    }
    private String createPassword(){
        String password="";
        return password;
    }

    public void removeUser(List<User> users,String userName) {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(userName)){}
            users.remove(i);
        }


    }
    public boolean authenticateUser(String username, String password) {
        // TODO: 12.11.2023 г.   тука ще се направи проверкa

        return true;
    }
}
