package dev.hv.db.dao;
import java.util.List;
import java.util.Properties;

import org.jdbi.v3.core.Jdbi;
import dev.hv.db.model.User;

public class UserDAOImpl {
    
    private Properties dbProperties = new Properties();

    Jdbi jdbi = Jdbi.create(dbProperties.getProperty("db.url"));

    public void insert(User user) {
        jdbi.useExtension(UserDAO.class, dao -> dao.insert(user.getFirstName(), user.getLastName(), user.getPassword(), user.getToken()));
    }

    public void update(User user) {
        jdbi.useExtension(UserDAO.class, dao -> dao.update(user.getId(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getToken()));
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