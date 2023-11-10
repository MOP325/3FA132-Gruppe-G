package dev.hv.db.dao;

import dev.hv.db.model.IDReading;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOReading<T extends IDReading> {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(T reading) {
        entityManager.persist(reading);
        return reading.getId();
    }

    public void update(T reading) {
        entityManager.merge(reading);
    }

    public void delete(T reading) {
        if (!entityManager.contains(reading)) {
            reading = entityManager.merge(reading);
        }
        entityManager.remove(reading);
    }
}
