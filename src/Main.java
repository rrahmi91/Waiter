import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> personal=new ArrayList<>();
        personal.add(0,new Administrator("ADMIN","Admin123*","Administrator"));
        LoginManager loginManager=new LoginManager(personal);
        personal.add(loginManager.addWaiter());
        personal.add(loginManager.addCook());
    }
}