package shop;

import java.util.HashMap;
import java.util.Map;

public class OnlineStore3 {
    private String name;
    private Map<Product3, Double> products = new HashMap<>();

    public OnlineStore3(String name) { this.name = name; }

    public String getName() { return name; }
    public Map<Product3, Double> getProducts() { return products; }

    public void addProduct(Product3 p, double price) { products.put(p, price); }

    @Override
    public String toString() { return name; }
}