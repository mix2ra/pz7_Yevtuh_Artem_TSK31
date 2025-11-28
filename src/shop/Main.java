package shop;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ======== Варіант 1 (for-each) ========
        Product p1 = new Product("Laptop", 1000);
        Product p2 = new Product("Phone", 600);

        OnlineStore store1 = new OnlineStore("StoreA");
        store1.addProduct(p1, 950);
        store1.addProduct(p2, 550);

        OnlineStore store2 = new OnlineStore("StoreB");
        store2.addProduct(p1, 970);
        store2.addProduct(p2, 580);

        ProductSearchService service1 = new ProductSearchService();
        service1.addStore(store1);
        service1.addStore(store2);

        System.out.println("=== Варіант 1 (for-each) ===");
        System.out.println("Мінімальна ціна Laptop: " + service1.findMinPrice(p1));
        System.out.println("Магазини з мінімальною ціною Laptop: " + service1.storesWithMinPrice(p1));
        System.out.println("Є магазин з усіма товарами дешевше рекомендованої ціни? " + service1.hasAllProductsCheaper());

        // ======== Варіант 2 (нетипізований ітератор) ========
        Product2 p21 = new Product2("Laptop", 1000);
        Product2 p22 = new Product2("Phone", 600);

        OnlineStore2 store21 = new OnlineStore2("StoreA");
        store21.addProduct(p21, 950);
        store21.addProduct(p22, 550);

        OnlineStore2 store22 = new OnlineStore2("StoreB");
        store22.addProduct(p21, 970);
        store22.addProduct(p22, 580);

        ProductSearchService2 service2 = new ProductSearchService2();
        service2.addStore(store21);
        service2.addStore(store22);

        System.out.println("\n=== Варіант 2 (нетипізований ітератор) ===");
        System.out.println("Мінімальна ціна Laptop: " + service2.findMinPrice(p21));
        System.out.println("Магазини з мінімальною ціною Laptop: " + service2.storesWithMinPrice(p21));
        System.out.println("Є магазин з усіма товарами дешевше рекомендованої ціни? " + service2.hasAllProductsCheaper());

        // ======== Варіант 3 (типізований ітератор) ========
        Product3 p31 = new Product3("Laptop", 1000);
        Product3 p32 = new Product3("Phone", 600);

        OnlineStore3 store31 = new OnlineStore3("StoreA");
        store31.addProduct(p31, 950);
        store31.addProduct(p32, 550);

        OnlineStore3 store32 = new OnlineStore3("StoreB");
        store32.addProduct(p31, 970);
        store32.addProduct(p32, 580);

        ProductSearchService3 service3 = new ProductSearchService3();
        service3.addStore(store31);
        service3.addStore(store32);

        System.out.println("\n=== Варіант 3 (типізований ітератор) ===");
        System.out.println("Мінімальна ціна Laptop: " + service3.findMinPrice(p31));
        System.out.println("Магазини з мінімальною ціною Laptop: " + service3.storesWithMinPrice(p31));
        System.out.println("Є магазин з усіма товарами дешевше рекомендованої ціни? " + service3.hasAllProductsCheaper());
    }
}