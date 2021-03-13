package by.parfenkov.service;

import by.parfenkov.beans.Shipment;

import java.util.List;
import java.util.Optional;

public class ShipmentService {
    private static volatile ShipmentService instance;

    public static ShipmentService getService() {
        if (null == instance) {
            synchronized (UserService.class) {
                if (null == instance) {
                    instance = new ShipmentService();
                }
            }
        }
        return instance;
    }

    public Optional<Shipment> add(Shipment shipment) {
        return Optional.empty();
    }

    public Optional<Shipment> set(Shipment shipment) {
        return Optional.empty();
    }

    public Optional<Shipment> remove(Shipment shipment) {
        return Optional.empty();
    }

    public Optional<Shipment> get(long id) {
        return Optional.empty();
    }

    public List<Shipment> getIfOpen() {
        return null;
    }

    public List<Shipment> getIfClose() {
        return null;
    }

    public List<Shipment> getAll() {
        return null;
    }

    private ShipmentService() {

    }
}
