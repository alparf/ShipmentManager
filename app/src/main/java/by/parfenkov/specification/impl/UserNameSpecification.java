package by.parfenkov.specification.impl;

import by.parfenkov.beans.User;
import by.parfenkov.specification.IHibernateSpecification;
import by.parfenkov.specification.ISpecification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserNameSpecification implements ISpecification<User>, IHibernateSpecification {
    private final String USER_NAME;

    public UserNameSpecification(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    @Override
    public CriteriaQuery<User> getCriteriaQuery(EntityManager entityManager) {
        final String USER_NAME_COLUMN = "user_name";
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(USER_NAME_COLUMN), this.USER_NAME));
    }

    @Override
    public boolean isInvalid(User user) {
        return !this.USER_NAME.equals(user.getUserName());
    }
}
