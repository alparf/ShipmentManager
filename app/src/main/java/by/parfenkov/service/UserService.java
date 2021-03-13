package by.parfenkov.service;

import by.parfenkov.beans.User;
import by.parfenkov.repository.IRepository;
import by.parfenkov.repository.impl.UserRepository;
import by.parfenkov.specification.impl.AllUsersSpecification;
import by.parfenkov.specification.impl.IdSpecification;
import by.parfenkov.specification.impl.UserNameAndPasswordSpecification;
import by.parfenkov.specification.impl.UserNameSpecification;

import java.util.List;
import java.util.Optional;

public class UserService {
    private static volatile UserService instance;
    private final IRepository<User> repository;

    {
        this.repository = new UserRepository();
    }

    public static UserService getService() {
        if (null == instance) {
            synchronized (UserService.class) {
                if (null == instance) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    public Optional<User> add(User user) {
        return this.repository.add(user);
    }

    public Optional<User> set(User user) {
        return this.repository.set(user);
    }

    public Optional<User> remove(User user) {
        return this.repository.remove(user);
    }

    public Optional<User> get(String userName, String password) {
        return this.repository.get(new UserNameAndPasswordSpecification(userName, password)).stream()
                .findFirst();
    }

    public Optional<User> get(long id) {
        return this.repository.get(new IdSpecification(id)).stream()
                .findFirst();
    }

    public List<User> getAll() {
        return this.repository.get(new AllUsersSpecification());
    }

    public boolean isUserNameFree(String userName) {
        return this.repository.get(new UserNameSpecification(userName)).isEmpty();
    }

    private UserService() {

    }
}
