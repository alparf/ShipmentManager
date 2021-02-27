package by.parfenkov.specification;

public interface ISpecification<T> {
    boolean isInvalid(T t);
}
