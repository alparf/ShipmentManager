package by.parfenkov.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractEntity {
    private String userName;
    private String password;
    private Employee employee;
    private int right;

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {

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

        public Builder withRight(int right) {
            User.this.setRight(right);
            return this;
        }

        public User build() {
            return User.this;
        }

        private Builder() {

        }
    }
}
