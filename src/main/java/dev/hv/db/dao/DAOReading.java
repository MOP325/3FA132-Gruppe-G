package dev.hv.db.dao;

import org.jdbi.v3.core.Jdbi;

import dev.hv.db.model.Reading;

import java.util.List;

public class DAOReading {

    private Jdbi jdbi;

    public DAOReading() {
        // Initialize JDBI (usually done once and passed as a dependency)
        jdbi = Jdbi.create("jdbc:your_database_url", "username", "password");
    }

    public void insert(Reading reading) {
        jdbi.useExtension(ReadingDAO.class, dao -> dao.insert(reading.getcId(), reading.getMeterId(),
                reading.getKindOfMeter(), reading.getMeterCount(), reading.getSubstitute(), reading.getComment()));
    }

    public void update(Reading reading) {
        jdbi.useExtension(ReadingDAO.class, dao -> dao.update(reading.getId(), reading.getcId(), reading.getMeterId(),
                reading.getKindOfMeter(), reading.getMeterCount(), reading.getSubstitute(), reading.getComment()));
    }

    public Reading findById(int id) {
        return jdbi.withExtension(ReadingDAO.class, dao -> dao.findById(id));
    }

    public List<Reading> findAll() {
        return jdbi.withExtension(ReadingDAO.class, ReadingDAO::findAll);
    }

    public void delete(int id) {
        jdbi.useExtension(ReadingDAO.class, dao -> dao.delete(id));
    }
}
