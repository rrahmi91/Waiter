public class Waiter extends User implements Addable{
    public Waiter(String userName, String password, String role) {
        super(userName, password, role);
    }

    public Waiter() {
        super();
    }

    @Override
    public void changeOrderStatus(String status) {

    }

    public static void createOrder(){

    }
    public static void finishOrder(){

    }

    @Override
    public void addProduct() {

    }

    @Override
    public void removeRemove() {

    }
}
