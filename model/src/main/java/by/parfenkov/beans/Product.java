package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Product extends AbstractEntity {
    private String name;
    private int shippedMass;
    private int returnMass;
    private int price;
}
