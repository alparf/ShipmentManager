package by.parfenkov.specification.impl;

import by.parfenkov.beans.User;
import by.parfenkov.specification.IHibernateSpecification;
import by.parfenkov.specification.ISpecification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserNameAndPasswordSpecification implements ISpecification<User>, IHibernateSpecification {
    final private String userName;
    final private String password;

    public UserNameAndPasswordSpecification(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public CriteriaQuery<User> getQuery(EntityManager entityManager) {
        final String USER_NAME = "userName";
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(USER_NAME), this.userName));
    }

    @Override
    public boolean specificity(User user) {
        return this.password.equals(user.getPassword());
    }
}
