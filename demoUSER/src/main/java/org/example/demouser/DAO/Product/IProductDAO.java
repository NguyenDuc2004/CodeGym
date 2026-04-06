package org.example.demouser.DAO.Product;

import org.example.demouser.Model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    void insertProduct(Product product) throws SQLException;
    Product selectProduct(int id) throws SQLException;

    List<Product> selectAllProducts();

    boolean updateProduct(Product product);

    boolean deleteProduct(int id) throws SQLException;

}
