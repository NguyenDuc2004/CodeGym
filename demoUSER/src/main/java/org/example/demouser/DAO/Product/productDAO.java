package org.example.demouser.DAO.Product;

import org.example.demouser.DbConnection.DbConnection;
import org.example.demouser.Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class productDAO implements IProductDAO {

    public static final String SELECT_FROM_PRODUCTS = "select *from products;";
    public static final String INSERT_PRODUCT = "INSERT INTO products (name, description, price, stock, image, status) VALUES (?, ?, ?, ?, ?, ?);";
    public static final String VIEW_PRODUCT = "select *from products where id = ?;";
    public static final String DELETE_PRODUCT = "DELETE FROM products WHERE ID = ?;";

    @Override
    public void insertProduct(Product product) throws SQLException {
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PRODUCT)
        ){
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStock());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setBoolean(6, product.isStatus());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Product selectProduct(int id) throws SQLException {
        Product product = null;
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(VIEW_PRODUCT)
        ){
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                String name = rs.getString("name");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");

                product = new Product(id, name, description, price, stock, image, status);
            }
        }
        return product;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> product = new ArrayList<>();
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_FROM_PRODUCTS)
        ) {
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                product.add(new Product(id,name,desc,price,stock,image,status));
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        int rowsDeleted = 0;
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_PRODUCT);
        ){
            preparedStatement.setInt(1,id);
            rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
