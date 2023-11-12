public class Cook extends User implements Changeable {
    public Cook(String userName, String password, String role) {
        super(userName, password, role);
    }

    public Cook() {
        super();
    }

    @Override
    public void changeOrderStatus(String status) {

    }
}
