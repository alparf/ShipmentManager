package by.parfenkov.service;

import by.parfenkov.beans.Container;

import java.util.List;
import java.util.Optional;

public class ContainerService {
    private static volatile ContainerService instance;

    public static ContainerService getService() {
        if (null == instance) {
            synchronized (UserService.class) {
                if (null == instance) {
                    instance = new ContainerService();
                }
            }
        }
        return instance;
    }

    public Optional<Container> add(Container container) {
        return Optional.empty();
    }

    public Optional<Container> set(Container container) {
        return Optional.empty();
    }

    public Optional<Container> remove(Container container) {
        return Optional.empty();
    }

    public Optional<Container> get(long id) {
        return Optional.empty();
    }

    public List<Optional> getAll() {
        return null;
    }

    public ContainerService() {

    }
}
