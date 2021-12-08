package DAO;

import Entity.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User getUser(int id){
        return get(id);
    }

    public User addUser(User user){
        return persist(user);
    }

    public List<User> getUsers(){
        return list(currentSession().createQuery("SELECT p FROM profile p"));
        //return list(currentSession().createQuery("SELECT e FROM Equipement e"));
    }

    public String deleteUsers(int id){
        User userDele = getUser(id);
        currentSession().delete(userDele);
        return "Delete book with sucess";
    }

    public String updateUser(User user){
        currentSession().update(user);
        return "Update book with sucess";
    }
}