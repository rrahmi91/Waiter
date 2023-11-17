public abstract class Drinks extends Product {
    protected String brand;
    protected String quantityUnit;

    public Drinks(String brand, int quantity, String quantityUnit, double price) {
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
