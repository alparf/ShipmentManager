package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Position extends AbstractEntity {
    String name;

    public static Builder newBuilder() {
        return new Position().new Builder();
    }

    public class Builder {

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
