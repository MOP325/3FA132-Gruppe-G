package dev.hv.db.dao;

import org.jdbi.v3.core.Jdbi;

import dev.hv.db.model.User;

import java.util.List;

public class DAOUser {

    private Jdbi jdbi;

    public DAOUser() {
        jdbi = Jdbi.create("jdbc:your_database_url", "username", "password");
    }

    public void insert(User user) {
        jdbi.useExtension(UserDAO.class,
                dao -> dao.insert(user.getFirstName(), user.getLastName(), user.getPassword(), user.getToken()));
    }

    public void update(User user) {
        jdbi.useExtension(UserDAO.class, dao -> dao.update(user.getId(), user.getFirstName(), user.getLastName(),
                user.getPassword(), user.getToken()));
    }

    public User findById(int id) {
        return jdbi.withExtension(UserDAO.class, dao -> dao.findById(id));
    }

    public List<User> findAll() {
        return jdbi.withExtension(UserDAO.class, UserDAO::findAll);
    }

    public void delete(int id) {
        jdbi.useExtension(UserDAO.class, dao -> dao.delete(id));
    }
}