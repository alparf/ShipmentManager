package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Container extends AbstractEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "mass")
    private int mass;

    public static Builder newBuilder() {
        return new Container().new Builder();
    }

    public class Builder {

        public Builder withId(long id) {
            Container.this.setId(id);
            return this;
        }

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
