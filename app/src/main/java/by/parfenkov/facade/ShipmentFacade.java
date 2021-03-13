package by.parfenkov.facade;

import by.parfenkov.beans.Shipment;
import by.parfenkov.service.ProductService;
import by.parfenkov.service.ShipmentService;

import java.util.Optional;

public class ShipmentFacade {

    public static Optional<Shipment> newShipment(Shipment shipment) {
        return ShipmentService.getService().add(shipment);
    }

    public static Optional<Shipment> removeShipment(long shipmentId) {
        ShipmentService shipmentService = ShipmentService.getService();
        ProductService productService = ProductService.getService();
        Optional<Shipment> shipment = shipmentService.get(shipmentId);
        shipment.ifPresent(sh -> sh.getProducts().stream().map(productService::remove));
        shipment.ifPresent(shipmentService::remove);
        return shipment;
    }

    public static Optional<Shipment> updateShipment(Shipment shipment) {
        return ShipmentService.getService().set(shipment);
    }
}
