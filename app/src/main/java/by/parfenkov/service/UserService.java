package by.parfenkov.service;

import by.parfenkov.beans.User;
import by.parfenkov.repository.impl.UserRepository;
import by.parfenkov.specification.impl.AllUsersSpecification;

import java.util.List;
import java.util.Optional;

public class UserService {

    public Optional<User> add(User user) {
        return new UserRepository().add(user);
    }

    public Optional<User> set(User user) {
        return new UserRepository().set(user);
    }

    public Optional<User> remove(User user) {
        return new UserRepository().remove(user);
    }

    public Optional<User> get(String userName, String password) {
       return Optional.empty();
    }

    public Optional<User> get(long id) {
        return Optional.empty();
    }

    public List<User> getAll() {
        return new UserRepository().get(new AllUsersSpecification());
    }

    public boolean isNameHasUsed(String userName) {
        return false;
    }
}
