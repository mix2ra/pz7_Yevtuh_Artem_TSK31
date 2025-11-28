package shop;

import java.util.*;

public class ProductSearchService3 {
    private List<OnlineStore3> stores = new ArrayList<>();

    public void addStore(OnlineStore3 store) { stores.add(store); }

    public double findMinPrice(Product3 target) {
        double min = Double.MAX_VALUE;
        Iterator<OnlineStore3> itStores = stores.iterator();
        while (itStores.hasNext()) {
            OnlineStore3 store = itStores.next();
            if (store.getProducts().containsKey(target)) {
                double price = store.getProducts().get(target);
                if (price < min) min = price;
            }
        }
        return min;
    }

    public List<OnlineStore3> storesWithMinPrice(Product3 target) {
        List<OnlineStore3> result = new ArrayList<>();
        double minPrice = findMinPrice(target);
        Iterator<OnlineStore3> itStores = stores.iterator();
        while (itStores.hasNext()) {
            OnlineStore3 store = itStores.next();
            if (store.getProducts().containsKey(target) && store.getProducts().get(target) == minPrice) {
                result.add(store);
            }
        }
        return result;
    }

    public boolean hasAllProductsCheaper() {
        for (OnlineStore3 store : stores) {
            boolean allCheaper = true;
            for (Map.Entry<Product3, Double> entry : store.getProducts().entrySet()) {
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