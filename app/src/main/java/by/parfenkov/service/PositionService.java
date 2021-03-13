package by.parfenkov.service;

import by.parfenkov.beans.Position;

import java.util.List;
import java.util.Optional;

public class PositionService {
    private static volatile PositionService instance;

    public static PositionService getService() {
        if (null == instance) {
            synchronized (UserService.class) {
                if (null == instance) {
                    instance = new PositionService();
                }
            }
        }
        return instance;
    }

    public Optional<Position> add(Position position) {
        return Optional.empty();
    }

    public Optional<Position> set(Position position) {
        return Optional.empty();
    }

    public Optional<Position> remove(Position position) {
        return Optional.empty();
    }

    public Optional<Position> get(long id) {
        return Optional.empty();
    }

    public List<Position> getAll() {
        return null;
    }

    private PositionService() {

    }
}
