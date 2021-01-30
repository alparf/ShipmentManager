package by.parfenkov.beans;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void getCost() {
        Product product = Product.newBuilder()
                .withPrice(100)
                .withShippedMass(100_000)
                .withNumberOfContainer(2)
                .withContainer(
                        Container.newBuilder()
                                .withMass(2500)
                                .build())
                .build();
        assertEquals(9_500_000, product.getCost());
    }
}