package com.restaurant.order;
public class Table {
    private static int nextTableNumber = 1;
    private final int tableNumber;
    private TableStatus tableStatus;
    private Order order;

    public Table(TableStatus status,Order order) {
        this.tableNumber = nextTableNumber++;
        setTableStatus(status);
        setOrder(order);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public  int getTableNumber() {
        return tableNumber;
    }
    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    @Override
    public String toString() {
        return "\n\u001B[36mМаса Номер: " + getTableNumber() +'\'' +"\u001B[0m"+
                "\nСтатус на масата -->" + tableStatus +
                ",\nПоръчка към масата -->" + order +
                '}';
    }
}
