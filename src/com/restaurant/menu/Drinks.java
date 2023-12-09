package com.restaurant.menu;

public abstract class Drinks extends Product {
    protected String brand;
    protected String quantityUnit;

    Drinks(String brand, int quantity, String quantityUnit, double price) {
        super(quantity, price);
        this.brand = brand;
        this.quantityUnit = quantityUnit;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    @Override
    public String toString() {
        return "\nПитие{" +
                "Марка='" + brand + '\'' +
                ",количество в ='" + quantityUnit + '\'' +
                "} " + super.toString();
    }
}