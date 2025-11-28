package shop;

import java.util.HashMap;
import java.util.Map;

public class OnlineStore {
    private String name;
    private Map<Product, Double> products = new HashMap<>();

    public OnlineStore(String name) { this.name = name; }

    public String getName() { return name; }
    public Map<Product, Double> getProducts() { return products; }

    public void addProduct(Product p, double price) { products.put(p, price); }

    @Override
    public String toString() { return name; }
}