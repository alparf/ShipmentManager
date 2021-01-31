package by.parfenkov.facade;

import by.parfenkov.beans.User;
import by.parfenkov.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserFacade {

    public static Optional<User> signIn(String userName, String password) {
        return new UserService().get(userName, password);
    }

    public static Optional<User> newUser(User user) {
        UserService userService = new UserService();
        Optional<User> optional = Optional.empty();
        synchronized (UserService.class) {
            if (userService.isNameHasUsed(user.getUserName())) {
                optional = userService.add(user);
            }
        }
        return optional;
    }

    public static Optional<User> updateUser(User user) {
        return new UserService().set(user);
    }

    public static Optional<User> removeUser(long userId) {
        UserService userService = new UserService();
        Optional<User> user = userService.get(userId);
        user.ifPresent(userService::remove);
        return user;
    }

    public static List<User> getAll() {
        return new UserService().getAll();
    }
}
