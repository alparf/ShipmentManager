package by.parfenkov.facade;

import by.parfenkov.beans.Product;
import by.parfenkov.beans.Shipment;
import by.parfenkov.service.ProductService;
import by.parfenkov.service.ShipmentService;

import java.util.Optional;

public class ShipmentFacade {

    public static Optional<Shipment> newShipment(Shipment shipment) {
        return ShipmentService.getService().add(shipment);
    }

    public static Optional<Shipment> removeShipment(long shipmentId) {
        Optional<Shipment> shipment = ShipmentService.getService().get(shipmentId);
        shipment.ifPresent(sh -> sh.getProducts().stream().map(ProductService.getService()::remove));
        shipment.ifPresent(ShipmentService.getService()::remove);
        return shipment;
    }

    public static Optional<Shipment> updateShipment(Shipment shipment) {
        return ShipmentService.getService().set(shipment);
    }

    public static Optional<Product> addProduct(Product product) {

    }
}
