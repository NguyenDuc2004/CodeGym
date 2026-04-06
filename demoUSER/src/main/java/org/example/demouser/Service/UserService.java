package org.example.demouser.Service;

import org.example.demouser.DAO.User.IUserDAO;
import org.example.demouser.DAO.User.UserDAO;
import org.example.demouser.Model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private IUserDAO userDAO = new UserDAO();

    public List<User> findAll(){return userDAO.selectAllUsers();};
    public boolean deleteUser(int id) throws SQLException {
        return userDAO.deleteUser(id);
    }
    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }
    public User detailUser(int id){
        return userDAO.selectUser(id);
    }
    public boolean updateUser(User user) throws SQLException {
        return userDAO.updateUser(user);
    }
    public boolean updateUser(int id, String name, String email, String country) throws SQLException {
        return userDAO.updateUser(id, name, email, country);
    }
}
