package ru.sapteh.service;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.User;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public class UserService implements DAO<User, Long> {


    private final SessionFactory factory;

    public UserService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(User user) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public User read(@NotNull final Long id) {
        try(Session session = factory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public List<User> readByAll() {
        try(Session session = factory.openSession()) {
            String sql = "SELECT * FROM user";
            Query query = session.createNativeQuery(sql).addEntity(User.class);
            return query.getResultList();
        }
    }

    @Override
    public void update(@NotNull final User user) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final User user) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }
    }
}
