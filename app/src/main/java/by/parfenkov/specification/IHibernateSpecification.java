package by.parfenkov.specification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public interface IHibernateSpecification<T> {
    CriteriaQuery<T> getCriteriaQuery(EntityManager entityManager);
}
