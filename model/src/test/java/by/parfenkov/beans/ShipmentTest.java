package by.parfenkov.beans;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ShipmentTest {

    @Test
    public void getBalance() {
        Product product = Product.newBuilder()
                .withPrice(100)
                .withShippedMass(100_000)
                .withNumberOfContainer(2)
                .withContainer(
                        Container.newBuilder()
                                .withMass(2500)
                                .build())
                .build();
        List<Product> products = new LinkedList<>();
        products.add(product);
        products.add(product);
        Shipment shipment = Shipment.newBuilder()
                .withProducts(products)
                .withProceeds(19_000_000)
                .build();
        assertEquals(0, shipment.getBalance());
    }
}