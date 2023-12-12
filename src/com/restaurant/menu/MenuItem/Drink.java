package com.restaurant.menu.MenuItem;
import com.restaurant.menu.MenuItem.Base.MenuItem;

public class Drink implements MenuItem {

    public enum Type {
        SODA,
        JUICE,
        WATER,
        ALCOHOL,
        CARBONATED
    }

    private String name;
    private double volume;
    private Type type;
    private double price;

    public Drink(String name, double volume, Type type, double price) {
        this.name = name;
        this.volume = volume;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
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
                getVolume() + "," +
                getType().name() + "," +
                getPrice();
    }

    public Drink(String[] values) throws UnsupportedOperationException {
        if(!values[0].equals(this.getClass().getSimpleName())) {
            throw new UnsupportedOperationException("Wrong object type provided");
        }

        this.name = values[1];
        this.volume = Double.parseDouble(values[2]);
        this.type = Type.valueOf(values[3]);
        this.price = Double.parseDouble(values[4]);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
