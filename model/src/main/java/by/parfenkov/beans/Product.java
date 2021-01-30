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
    private Container container;
    private int shippedMass;
    private int returnMass;
    private int price;

    public static Builder newBuilder() {
        return new Product().new Builder();
    }

    public class Builder {

        public Builder withName(String name) {
            Product.this.setName(name);
            return this;
        }

        public Builder withContainer(Container container) {
            Product.this.setContainer(container);
            return this;
        }

        public Builder withShippedMass(int shippedMass) {
            Product.this.setShippedMass(shippedMass);
            return this;
        }

        public Builder withReturnMass(int returnMass) {
            Product.this.setReturnMass(returnMass);
            return this;
        }

        public Builder withPrice(int price) {
            Product.this.setPrice(price);
            return this;
        }

        public Product build() {
            return Product.this;
        }

        private Builder() {

        }
    }
}
