package by.parfenkov.service;

import by.parfenkov.beans.Store;

import java.util.List;
import java.util.Optional;

public class StoreService {
    private static volatile StoreService instance;

    public static StoreService getService() {
        if (null == instance) {
            synchronized (StoreService.class) {
                if (null == instance) {
                    instance = new StoreService();
                }
            }
        }
        return instance;
    }

    public Optional<Store> add(Store store) {
        return Optional.empty();
    }

    public Optional<Store> set(Store store) {
        return Optional.empty();
    }

    public Optional<Store> remove(Store store) {
        return Optional.empty();
    }

    public Optional<Store> get(long id) {
        return Optional.empty();
    }

    public List<Store> getAll() {
        return null;
    }

    private StoreService() {

    }
}
