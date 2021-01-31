package by.parfenkov.service;

import by.parfenkov.beans.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> add(User user) {
        return Optional.empty();
    }

    public Optional<User> set(User user) {
        return Optional.empty();
    }

    public Optional<User> remove(User user) {
        return Optional.empty();
    }

    public Optional<User> get(String userName, String password) {
       return Optional.empty();
    }

    public Optional<User> get(long id) {
        return Optional.empty();
    }

    public List<User> getAll() {
        return null;
    }

    public boolean isNameHasUsed(String userName) {
        return false;
    }
}
