package org.example.demouser.DAO.User;

import org.example.demouser.DbConnection.DbConnection;
import org.example.demouser.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    public static final String SELECT_FROM_USERS = "select *from users";
    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE ID = ?;";
    public static final String INSERT_USER = "Insert into users (name,email,country) values(?,?,?);";
    public static final String SELECT_USER_BY_ID = "select *from users where id =?";
    public static final String UPDATE_USER = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";
    public UserDAO() {
        super();
    }

    @Override
    public void insertUser(User user) throws SQLException {
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USER);
        ){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                System.out.println("Thêm người dùng thành công!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID)){
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_FROM_USERS)

        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

                users.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection conn = DbConnection.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USER_BY_ID)
        ){
           preparedStatement.setInt(1,id);
           rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean updateUser(int id, String name, String email, String country) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER)) {

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, country);
            statement.setInt(4, id);


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
