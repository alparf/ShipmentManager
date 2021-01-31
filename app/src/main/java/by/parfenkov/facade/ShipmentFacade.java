package by.parfenkov.facade;

import by.parfenkov.beans.Shipment;
import by.parfenkov.service.ShipmentService;

import java.util.Optional;

public class ShipmentFacade {

    public static Optional<Shipment> newShipment(Shipment shipment) {
        return new ShipmentService().add(shipment);
    }

    public static Optional<Shipment> removeShipment(long shipmentId) {
        ShipmentService shipmentService = new ShipmentService();
        Optional<Shipment> shipment = shipmentService.get(shipmentId);
        shipment.ifPresent(shipmentService::remove);
        return shipment;
    }
}
