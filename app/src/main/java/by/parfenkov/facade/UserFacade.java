package by.parfenkov.facade;

import by.parfenkov.beans.User;
import by.parfenkov.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserFacade {
    public static Optional<User> signIn(String userName, String password) {
        return UserService.getService().get(userName, password);
    }

    public static Optional<User> newUser(User user) {
        UserService userService = UserService.getService();
        Optional<User> optional = Optional.empty();
        synchronized (UserService.class) {
            if (!userService.isNameHasUsed(user.getUserName())) {
                optional = userService.add(user);
            }
        }
        return optional;
    }

    public static Optional<User> updateUser(User user) {
        return UserService.getService().set(user);
    }

    public static Optional<User> removeUser(long userId) {
        UserService userService = UserService.getService();
        Optional<User> user = userService.get(userId);
        user.ifPresent(userService::remove);
        return user;
    }

    public static List<User> getAll() {
        return UserService.getService().getAll();
    }
}
