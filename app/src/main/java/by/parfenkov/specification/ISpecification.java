package by.parfenkov.specification;

public interface ISpecification<T> {
    boolean specificity(T t);
}
