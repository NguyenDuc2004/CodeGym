package org.example.demouser.Service;

import org.example.demouser.DAO.Product.IProductDAO;
import org.example.demouser.DAO.Product.productDAO;
import org.example.demouser.Model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    IProductDAO productDAO = new productDAO();


    public List<Product> findAll(){
        return productDAO.selectAllProducts();
    }
    public void addProduct(Product product) throws SQLException {
        productDAO.insertProduct(product);
    }
    public Product detailProduct(int id) throws SQLException {
        return productDAO.selectProduct(id);
    }

    public boolean deleteProduct(int id) throws SQLException {
        return productDAO.deleteProduct(id);
    }
}
