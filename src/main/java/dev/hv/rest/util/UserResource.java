package dev.hv.rest.util;

import dev.hv.db.dao.UserDAOImpl;
import dev.hv.db.dao.UserDAO;
import dev.hv.db.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        userDAO.insert(
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getToken()
        );
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(@PathParam("id") int id, User user) {
        userDAO.update(
                id,
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getToken()
        );
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") int id) {
        return userDAO.findById(id);
    }

    @GET
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        userDAO.delete(id);
    }
}
