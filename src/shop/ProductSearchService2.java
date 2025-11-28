package shop;

import java.util.*;

public class ProductSearchService2 {
    private List<OnlineStore2> stores = new ArrayList<>();

    public void addStore(OnlineStore2 store) { stores.add(store); }

    // 1) мінімальна ціна
    public double findMinPrice(Product2 target) {
        double min = Double.MAX_VALUE;
        Iterator itStores = stores.iterator();
        while (itStores.hasNext()) {
            OnlineStore2 store = (OnlineStore2) itStores.next();
            if (store.getProducts().containsKey(target)) {
                double price = store.getProducts().get(target);
                if (price < min) min = price;
            }
        }
        return min;
    }

    // 2) магазини з мінімальною ціною
    public List<OnlineStore2> storesWithMinPrice(Product2 target) {
        List<OnlineStore2> result = new ArrayList<>();
        double minPrice = findMinPrice(target);

        Iterator itStores = stores.iterator();
        while (itStores.hasNext()) {
            OnlineStore2 store = (OnlineStore2) itStores.next();
            if (store.getProducts().containsKey(target) && store.getProducts().get(target) == minPrice) {
                result.add(store);
            }
        }
        return result;
    }

    // 3) магазин з усіма товарами дешевше рекомендованої ціни
    public boolean hasAllProductsCheaper() {
        Iterator itStores = stores.iterator();
        while (itStores.hasNext()) {
            OnlineStore2 store = (OnlineStore2) itStores.next();
            boolean allCheaper = true;

            Iterator itProducts = store.getProducts().entrySet().iterator();
            while (itProducts.hasNext()) {
                Map.Entry entry = (Map.Entry) itProducts.next();
                Product2 p = (Product2) entry.getKey();
                double price = (double) entry.getValue();
                if (price >= p.getRecommendedPrice()) {
                    allCheaper = false;
                    break;
                }
            }

            if (allCheaper) return true;
        }
        return false;
    }
}