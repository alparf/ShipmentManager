package by.parfenkov.repository;

import by.parfenkov.specification.ISpecification;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    Optional<T> add(T t);
    Optional<T> set(T t);
    Optional<T> remove(T t);
    List<T> get(ISpecification<T> s);
}
