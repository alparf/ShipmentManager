package by.parfenkov.service;

import by.parfenkov.beans.Shipment;
import by.parfenkov.repository.IRepository;
import by.parfenkov.repository.impl.ShipmentRepository;
import by.parfenkov.specification.impl.shipment.AllShipmentSpecification;
import by.parfenkov.specification.impl.shipment.CloseShipmentSpecification;
import by.parfenkov.specification.impl.shipment.OpenShipmentSpecification;
import by.parfenkov.specification.impl.shipment.ShipmentIdSpecification;

import java.util.List;
import java.util.Optional;

public class ShipmentService {
    private static volatile ShipmentService instance;
    private final IRepository<Shipment> repository;

    {
        this.repository = new ShipmentRepository();
    }

    public static ShipmentService getService() {
        if (null == instance) {
            synchronized (ShipmentService.class) {
                if (null == instance) {
                    instance = new ShipmentService();
                }
            }
        }
        return instance;
    }

    public Optional<Shipment> add(Shipment shipment) {
        return this.repository.add(shipment);
    }

    public Optional<Shipment> set(Shipment shipment) {
        return this.repository.set(shipment);
    }

    public Optional<Shipment> remove(Shipment shipment) {
        return this.repository.remove(shipment);
    }

    public Optional<Shipment> get(long id) {
        return this.repository.get(new ShipmentIdSpecification(id)).stream().findFirst();
    }

    public List<Shipment> getIfOpen() {
        return this.repository.get(new OpenShipmentSpecification());
    }

    public List<Shipment> getIfClose() {
        return this.repository.get(new CloseShipmentSpecification());
    }

    public List<Shipment> getAll() {
        return this.repository.get(new AllShipmentSpecification());
    }

    private ShipmentService() {

    }
}
