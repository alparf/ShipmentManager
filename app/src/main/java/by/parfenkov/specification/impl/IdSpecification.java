package by.parfenkov.specification.impl;

import by.parfenkov.beans.User;
import by.parfenkov.specification.IHibernateSpecification;
import by.parfenkov.specification.ISpecification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class IdSpecification implements ISpecification<User>, IHibernateSpecification {
    private final long ID;

    public IdSpecification(long ID) {
        this.ID = ID;
    }

    @Override
    public CriteriaQuery<User> getQuery(EntityManager entityManager) {
        final String ID_COLUMN = "id";
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(ID_COLUMN), this.ID));
    }

    @Override
    public boolean isInvalid(User user) {
        return this.ID != user.getId();
    }
}
