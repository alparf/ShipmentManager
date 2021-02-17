package by.parfenkov;

import by.parfenkov.beans.Employee;
import by.parfenkov.beans.Position;
import by.parfenkov.beans.User;
import by.parfenkov.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Runner {
    public static void main(String[] args) {
        Session session = HibernateUtil.getEMFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Position position = Position.newBuilder()
                .withName("Водитель автобуса")
                .build();
        Employee employee = Employee.newBuilder()
                .withPosition(position)
                .withFio("Парфенков Антон Леонидович")
                .build();
        User user = User.newBuilder()
                .withUserName("admin")
                .withPassword("password")
                .withEmployee(employee)
                .withRight(25)
                .build();
        transaction.commit();
        session.persist(position);
        session.close();
    }
}
