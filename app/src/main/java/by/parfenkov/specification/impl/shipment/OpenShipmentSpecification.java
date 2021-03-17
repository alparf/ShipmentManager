package by.parfenkov.specification.impl.shipment;

import by.parfenkov.beans.Shipment;
import by.parfenkov.specification.IHibernateSpecification;
import by.parfenkov.specification.ISpecification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class OpenShipmentSpecification implements ISpecification<Shipment>, IHibernateSpecification<Shipment> {
    @Override
    public CriteriaQuery<Shipment> getCriteriaQuery(EntityManager entityManager) {
        return null;
    }

    @Override
    public boolean isInvalid(Shipment shipment) {
        return false;
    }
}
