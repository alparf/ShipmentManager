package by.parfenkov.specification;

import by.parfenkov.beans.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public interface IHibernateSpecification {
    CriteriaQuery<User> getCriteriaQuery(EntityManager entityManager);
}
