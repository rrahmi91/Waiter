public abstract class Dish extends Product {
    protected String name;
    protected String quantityUnit;

    public Dish(String name, int quantity, String quantityUnit, double price) {
        this.name = name;
        this.quantityUnit = quantityUnit;
        super(quantity, price);
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}