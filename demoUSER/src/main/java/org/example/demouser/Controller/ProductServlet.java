package org.example.demouser.Controller;

import org.example.demouser.Model.Product;
import org.example.demouser.Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action ="";
        switch (action){
            case "create":
                System.out.println("xem thong tin");
                break;
            case "view":
                viewProduct(req, resp);
                break;
            case "delete":
                try {
                    deleted(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:
                listProduct(req, resp);
                break;
        }

    }

    private void viewProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product p = null;
        try {
            p = productService.detailProduct(id);
            req.setAttribute("p", p);
            req.getRequestDispatcher("/Product/view.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String image = req.getParameter("image");
        boolean status = Boolean.parseBoolean(req.getParameter("status"));
        Product newProduct = new Product(name, description, price, stock, image, status);

        try {
            productService.addProduct(newProduct);
            resp.sendRedirect("product");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        for(Product p : products){
            System.out.println(p.getId());
        }
        req.setAttribute("product",products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Product/productList.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleted(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
    }


}
