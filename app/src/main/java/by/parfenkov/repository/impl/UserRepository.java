package by.parfenkov.repository.impl;

import by.parfenkov.beans.User;
import by.parfenkov.hibernate.HibernateUtil;
import by.parfenkov.repository.IRepository;
import by.parfenkov.specification.IHibernateSpecification;
import by.parfenkov.specification.ISpecification;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IRepository<User> {
    @Override
    public Optional<User> add(User user) {
        Session session = HibernateUtil.getEMFactory().openSession();
        Transaction transaction  = session.getTransaction();
        try (session) {
            transaction.begin();
            session.persist(user);
            user = session.find(User.class, user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> set(User user) {
        Session session = HibernateUtil.getEMFactory().openSession();
        Transaction transaction  = session.getTransaction();
        try (session) {
            transaction.begin();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> remove(User user) {
        Session session = HibernateUtil.getEMFactory().openSession();
        Transaction transaction  = session.getTransaction();
        try (session) {
            transaction.begin();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return Optional.of(user);
    }

    @Override
    public List<User> get(ISpecification<User> specification) {
        EntityManager em =  HibernateUtil.getEMFactory().createEntityManager();
        List<User> userList = new LinkedList<>();
        if (specification instanceof IHibernateSpecification) {
            IHibernateSpecification hibernateSpecification = (IHibernateSpecification) specification;
            userList = em.createQuery(hibernateSpecification.getCriteriaQuery(em)).getResultList();
        }
        userList.removeIf(specification::isInvalid);
        return userList;
    }
}
