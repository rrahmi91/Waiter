public abstract class Dish extends Product {
   protected String quantityUnit;
   protected String name;

    public Dish(String quantityUnit, String name, double price) {
        this.quantityUnit = quantityUnit;
        this.name = name;
        super(price);
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
