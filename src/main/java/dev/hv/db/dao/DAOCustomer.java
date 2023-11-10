package dev.hv.db.dao;

import dev.hv.db.model.IDCustomer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOCustomer<T extends IDCustomer> {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(T customer) {
        entityManager.persist(customer);
        return customer.getId();
    }

    public void update(T customer) {
        entityManager.merge(customer);
    }

    public void delete(T customer) {
        if (!entityManager.contains(customer)) {
            customer = entityManager.merge(customer);
        }
        entityManager.remove(customer);
    }
}
