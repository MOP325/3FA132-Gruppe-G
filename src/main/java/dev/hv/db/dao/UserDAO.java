package dev.hv.db.dao;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import dev.hv.db.model.User;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import java.util.List;

public interface UserDAO {

    @SqlUpdate("INSERT INTO users (u_Firstname, u_LastName, u_Password, u_Token) VALUES (:firstName, :lastName, :password, :token)")
    void insert(@Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("password") String password, @Bind("token") String token);

    @SqlUpdate("UPDATE users SET u_Firstname = :firstName, u_LastName = :lastName, u_Password = :password, u_Token = :token WHERE u_Id = :id")
    void update(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("password") String password, @Bind("token") String token);

    @SqlQuery("SELECT * FROM users WHERE u_Id = :id")
    User findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM users")
    List<User> findAll();

    @SqlUpdate("DELETE FROM users WHERE u_Id = :id")
    void delete(@Bind("id") int id);
}