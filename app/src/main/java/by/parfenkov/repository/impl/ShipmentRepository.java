package by.parfenkov.repository.impl;

import by.parfenkov.beans.Shipment;
import by.parfenkov.repository.IRepository;
import by.parfenkov.specification.ISpecification;

import java.util.List;
import java.util.Optional;

public class ShipmentRepository implements IRepository<Shipment> {
    @Override
    public Optional<Shipment> add(Shipment shipment) {
        return Optional.empty();
    }

    @Override
    public Optional<Shipment> set(Shipment shipment) {
        return Optional.empty();
    }

    @Override
    public Optional<Shipment> remove(Shipment shipment) {
        return Optional.empty();
    }

    @Override
    public List<Shipment> get(ISpecification<Shipment> specification) {
        return null;
    }
}
