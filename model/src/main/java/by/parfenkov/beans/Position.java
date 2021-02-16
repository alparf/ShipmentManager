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
public class Position extends AbstractEntity {
    @Column(name = "name")
    private String name;

    public static Builder newBuilder() {
        return new Position().new Builder();
    }

    public class Builder {

        public Builder withId(long id) {
            Position.this.setId(id);
            return this;
        }

        public Builder withName(String name) {
            Position.this.setName(name);
            return this;
        }

        public Position build() {
            return Position.this;
        }

        private Builder() {

        }
    }
}
