public class Cook extends User {
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
