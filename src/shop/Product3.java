package shop;

public class Product3 {
    private String name;
    private double recommendedPrice;

    public Product3(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    public String getName() { return name; }
    public double getRecommendedPrice() { return recommendedPrice; }

    @Override
    public String toString() { return name + " (" + recommendedPrice + ")"; }
}