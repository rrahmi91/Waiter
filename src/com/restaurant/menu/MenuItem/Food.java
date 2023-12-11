package com.restaurant.menu.MenuItem;


import com.restaurant.menu.MenuItem.Base.MenuItem;

public class Food implements MenuItem {
    public enum Type {
        MAIN_COURSE,
        DESSERT,
        SOUP,
        SALAD
    }

    private String name;
    private int quantity;
    private Type type;
    private double price;

    public Food(String name, int quantity, Type type, double price) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toCSV() {
        return this.getClass().getSimpleName() + "," +
                getName() + "," +
                getQuantity() + "," +
                getType().name();
    }

    public Food(String[] values) throws UnsupportedOperationException {
        if(!values[0].equals(this.getClass().getSimpleName())) {
            throw new UnsupportedOperationException("Wrong object type provided");
        }

        this.name = values[1];
        this.quantity = Integer.parseInt(values[2]);
        this.type = Type.valueOf(values[3]);
        this.price = Double.parseDouble(values[4]);
    }

    @Override
    public String toString() {
        return "Food {" +
                "  name ='" + name + "'," +
                "  quantity =" + quantity + "," +
                "  type =" + type.name() + "," +
                "}";
    }
}
