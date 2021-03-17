package by.parfenkov.specification.impl.shipment;

import by.parfenkov.beans.Shipment;
import by.parfenkov.specification.IHibernateSpecification;
import by.parfenkov.specification.ISpecification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class ShipmentIdSpecification implements ISpecification<Shipment>, IHibernateSpecification<Shipment> {
    private final long id;

    public ShipmentIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public CriteriaQuery<Shipment> getCriteriaQuery(EntityManager entityManager) {
        return null;
    }

    @Override
    public boolean isInvalid(Shipment shipment) {
        return this.id != shipment.getId();
    }
}
