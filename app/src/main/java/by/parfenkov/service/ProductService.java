package by.parfenkov.service;

import by.parfenkov.beans.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {
    private static volatile ProductService instance;

    public static ProductService getService() {
        if (null == instance) {
            synchronized (ProductService.class) {
                if (null == instance) {
                    instance = new ProductService();
                }
            }
        }
        return instance;
    }

    public Optional<Product> add(Product product) {
        return Optional.empty();
    }

    public Optional<Product> set(Product product) {
        return Optional.empty();
    }

    public Optional<Product> remove(Product product) {
        return Optional.empty();
    }

    public Optional<Product> get(long id) {
        return Optional.empty();
    }

    public List<Product> getAll() {
        return null;
    }

    private ProductService() {

    }
}
