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
public class Employee extends AbstractEntity {
    @Column(name = "fio")
    private String fio;
    private Position position;

    public static Builder newBuilder() {
        return new Employee().new Builder();
    }

    public class Builder {

        public Builder withId(long id) {
            Employee.this.setId(id);
            return this;
        }

        public Builder withFio(String fio) {
            Employee.this.setFio(fio);
            return this;
        }

        public Builder withPosition(Position position) {
            Employee.this.setPosition(position);
            return this;
        }

        public Employee build() {
            return Employee.this;
        }

        private Builder() {

        }
    }
}
