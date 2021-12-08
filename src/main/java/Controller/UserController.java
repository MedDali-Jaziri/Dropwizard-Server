package Controller;

import DAO.UserDAO;
import Entity.User;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("userService")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    @Path("/getUser")
    @UnitOfWork
    public User getUser(@QueryParam("userID")int userID){
        return this.userDAO.getUser(userID);
    }

    @GET
    @Path("/getUsers")
    @UnitOfWork
    public List<User> getUsers(){
        return this.userDAO.getUsers();
    }

    @POST
    @Path("/addUser")
    @UnitOfWork
    public int addUser(
            @Valid User User
    ){
        return this.userDAO.addUser(User).getId();
    }

    @DELETE
    @Path("/deleteUser")
    @UnitOfWork
    public String deleteUser(@QueryParam("UserID") int UserID){
        return this.userDAO.deleteUsers(UserID);
    }

    @POST
    @Path("/updateUser")
    @UnitOfWork
    public String updateUser(@Valid User User){
        return this.userDAO.updateUser(User);
    }
}
