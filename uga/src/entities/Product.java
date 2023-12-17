package entities;

public class Product {
    private String name;
    private double price;
    private Supplier supplier;

    public Product(String name, double price, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (" + supplier.getName() + ")";
    }
}
