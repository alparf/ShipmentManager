package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "products")
public class Product extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "container_id", referencedColumnName = "id")
    private Container container;
    @Column(name = "number_of_container")
    private int numberOfContainer;
    @Column(name = "shipped_mass")
    private int shippedMass;
    @Column(name = "return_mass")
    private int returnMass;
    @Column(name = "price")
    private int price;

    public static Builder newBuilder() {
        return new Product().new Builder();
    }

    /**
     *
     * @return
     */

    public int getSold() {
        int sold = 0;
        if (null != container) {
            sold = price * (shippedMass - returnMass - (numberOfContainer * container.getMass()));
        }
        return sold;
    }

    /**
     *
     * @return
     */

    public int getCost() {
        int cost = 0;
        if (null != container) {
            cost = price * (shippedMass - (numberOfContainer * container.getMass()));
        }
        return cost;
    }

    public class Builder {

        public Builder withId(long id) {
            Product.this.setId(id);
            return this;
        }

        public Builder withName(String name) {
            Product.this.setName(name);
            return this;
        }

        public Builder withContainer(Container container) {
            Product.this.setContainer(container);
            return this;
        }

        public Builder withNumberOfContainer(int numberOfContainer) {
            Product.this.setNumberOfContainer(numberOfContainer);
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
