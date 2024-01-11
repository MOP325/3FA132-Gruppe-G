package dev.hv.db.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import dev.hv.db.model.User;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

// Interface for database access to the "users" table, defines methods for inserting, updating, querying, and deleting user data.
public interface UserDAO {
        @SqlUpdate("INSERT INTO users (Firstname, LastName, Password, Token) VALUES (:firstName, :lastName, :password, :token)")
        void insert(@Bind("firstName") String firstName, @Bind("lastName") String lastName,
                        @Bind("password") String password, @Bind("token") String token);

        @SqlUpdate("UPDATE users SET Firstname = :firstName, LastName = :lastName, Password = :password, Token = :token WHERE Id = :id")
        void update(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName,
                        @Bind("password") String password, @Bind("token") String token);

        @SqlQuery("SELECT * FROM users WHERE Id = :id")
        User findById(@Bind("id") int id);

        @SqlQuery("SELECT * FROM users")
        List<User> findAll();

        @SqlUpdate("DELETE FROM users WHERE Id = :id")
        void delete(@Bind("id") int id);
}