package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Shipment extends AbstractEntity {
    private List<Product> products;
    private Store store;
    private Employee seller;
    private LocalDate shippingDate;
    private int proceeds;
    private User whoOpen;
    private User whoClose;

    /**
     *
     * @return
     */

    public int getBalance() {
        int sold = products.stream()
                .mapToInt(product -> product.getSold())
                .sum();
        return proceeds - sold;
    }

    public static Builder newBuilder() {
        return new Shipment().new Builder();
    }

    public class Builder {

        public Builder withId(long id) {
            Shipment.this.setId(id);
            return this;
        }

        public Builder withProducts(List<Product> products) {
            Shipment.this.setProducts(products);
            return this;
        }

        public Builder withStore(Store store) {
            Shipment.this.setStore(store);
            return this;
        }

        public Builder withEmployee(Employee employee) {
            Shipment.this.setSeller(employee);
            return this;
        }

        public Builder withShippingDate(LocalDate shippingDate) {
            Shipment.this.setShippingDate(shippingDate);
            return this;
        }

        public Builder withProceeds(int proceeds) {
            Shipment.this.setProceeds(proceeds);
            return this;
        }

        public Builder withWhoOpen(User user) {
            Shipment.this.setWhoOpen(user);
            return this;
        }

        public Builder withWhoClose(User user) {
            Shipment.this.setWhoClose(user);
            return this;
        }

        public Shipment build() {
            return Shipment.this;
        }

        private Builder() {

        }
    }
}
