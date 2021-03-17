package by.parfenkov.specification.impl.shipment;

import by.parfenkov.beans.Shipment;
import by.parfenkov.specification.IHibernateSpecification;
import by.parfenkov.specification.ISpecification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AllShipmentSpecification implements ISpecification<Shipment>, IHibernateSpecification<Shipment> {
    @Override
    public CriteriaQuery<Shipment> getCriteriaQuery(EntityManager entityManager) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shipment> criteriaQuery = criteriaBuilder.createQuery(Shipment.class);
        Root<Shipment> root = criteriaQuery.from(Shipment.class);
        return criteriaQuery.select(root);
    }

    @Override
    public boolean isInvalid(Shipment shipment) {
        return false;
    }
}
