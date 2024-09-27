package org.nightfury.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.nightfury.entity.Product;

public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public void addProductToRepository(Product product) {
        this.productList.add(product);
    }

    public List<Product> getProductsFromRepository() {
        return productList;
    }

    public void removeAllProductsFromRepository() {
        this.productList.clear();
    }

    public static Product createProduct(String title, double cost) {
        return new Product(UUID.randomUUID(), title, cost);
    }
}
