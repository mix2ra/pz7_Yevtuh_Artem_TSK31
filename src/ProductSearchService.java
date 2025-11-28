package shop;

import java.util.*;

public class ProductSearchService {
    private List<OnlineStore> stores = new ArrayList<>();

    public void addStore(OnlineStore store) { stores.add(store); }

    public double findMinPrice(Product target) {
        double min = Double.MAX_VALUE;
        for (OnlineStore store : stores) {
            if (store.getProducts().containsKey(target)) {
                double price = store.getProducts().get(target);
                if (price < min) min = price;
            }
        }
        return min;
    }

    public List<OnlineStore> storesWithMinPrice(Product target) {
        List<OnlineStore> result = new ArrayList<>();
        double minPrice = findMinPrice(target);
        for (OnlineStore store : stores) {
            if (store.getProducts().containsKey(target) && store.getProducts().get(target) == minPrice) {
                result.add(store);
            }
        }
        return result;
    }

    public boolean hasAllProductsCheaper() {
        for (OnlineStore store : stores) {
            boolean allCheaper = true;
            for (Map.Entry<Product, Double> entry : store.getProducts().entrySet()) {
                if (entry.getValue() >= entry.getKey().getRecommendedPrice()) {
                    allCheaper = false;
                    break;
                }
            }
            if (allCheaper) return true;
        }
        return false;
    }
}