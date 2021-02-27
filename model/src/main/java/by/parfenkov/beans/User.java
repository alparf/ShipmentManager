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
@Table(name = "users")
public class User extends AbstractEntity {
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    @Column(name = "rights", nullable = false)
    private int rights;

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {

        public Builder withId(long id) {
            User.this.setId(id);
            return this;
        }

        public Builder withUserName(String userName) {
            User.this.setUserName(userName);
            return this;
        }

        public Builder withPassword(String password) {
            User.this.setPassword(password);
            return this;
        }

        public Builder withEmployee(Employee employee) {
            User.this.setEmployee(employee);
            return this;
        }

        public Builder withRights(int rights) {
            User.this.setRights(rights);
            return this;
        }

        public User build() {
            return User.this;
        }

        private Builder() {

        }
    }
}
