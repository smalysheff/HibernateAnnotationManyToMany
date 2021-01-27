package ru.sapteh.service;

import com.sun.istack.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Role;

import java.io.Serializable;
import java.util.List;

public class RoleService implements DAO<Role, Long> {

    private final SessionFactory factory;

    public RoleService(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(@NotNull final Role role) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public Role read(@NotNull final Long id) {
        try(Session session = factory.openSession()) {
            return session.get(Role.class, id);
        }
    }

    @Override
    public List<Role> readByAll() {
        try(Session session = factory.openSession()){
            String sql = "SELECT * FROM role";
            Query query = session.createNativeQuery(sql).addEntity(Role.class);
            return query.getResultList();
        }
    }

    @Override
    public void update(@NotNull final Role role) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(@NotNull final Role role) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
        }
    }
}
