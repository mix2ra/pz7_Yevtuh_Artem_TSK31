package shop;

import java.util.HashMap;
import java.util.Map;

public class OnlineStore2 {
    private String name;
    private Map<Product2, Double> products = new HashMap<>();

    public OnlineStore2(String name) { this.name = name; }

    public String getName() { return name; }
    public Map<Product2, Double> getProducts() { return products; }

    public void addProduct(Product2 p, double price) { products.put(p, price); }

    @Override
    public String toString() { return name; }
}