package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Container extends AbstractEntity {
    private String name;
    private int mass;

    public static Builder newBuilder() {
        return new Container().new Builder();
    }

    public class Builder {

        public Builder withName(String name) {
            Container.this.setName(name);
            return this;
        }

        public Builder withMass(int mass) {
            Container.this.setMass(mass);
            return this;
        }

        public Container build() {
            return Container.this;
        }

        private Builder() {

        }
    }
}
