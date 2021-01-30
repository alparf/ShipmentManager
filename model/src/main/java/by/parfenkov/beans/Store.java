package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Store extends AbstractEntity {
    private String name;
    private String mode;
    private String address;

    public static Builder newBuilder() {
        return new Store().new Builder();
    }

    public class Builder {

        public Builder withId(long id) {
            Store.this.setId(id);
            return this;
        }

        public Builder withName(String name) {
            Store.this.setName(name);
            return this;
        }

        public Builder withMode(String mode) {
            Store.this.setMode(mode);
            return this;
        }

        public Builder withAddress(String address) {
            Store.this.setAddress(address);
            return this;
        }

        public Store build() {
            return Store.this;
        }

        private Builder() {

        }
    }
}
