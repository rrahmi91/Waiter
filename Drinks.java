public abstract class Drinks extends Product {
    String brand;
    String quantityUnit;

    public Drinks(String brand, String quantityUnit, double price) {
        this.brand = brand;
        this.quantityUnit = quantityUnit;
        super(price);
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
}
