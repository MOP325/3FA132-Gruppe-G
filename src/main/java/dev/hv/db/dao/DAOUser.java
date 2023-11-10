package dev.hv.db.dao;

import dev.hv.db.model.IDUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOUser<T extends IDUser> {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(T user) {
        entityManager.persist(user);
        return user.getId();
    }

    public void update(T user) {
        entityManager.merge(user);
    }

    public void delete(T user) {
        if (!entityManager.contains(user)) {
            user = entityManager.merge(user);
        }
        entityManager.remove(user);
    }
}
