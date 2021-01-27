package ru.sapteh.dao;

import java.util.List;

public interface DAO<Entity, Key> {
    void create(Entity entity);
    Entity read(Key key);
    List<Entity> readByAll();
    void update(Entity entity);
    void delete(Entity entity);
}
