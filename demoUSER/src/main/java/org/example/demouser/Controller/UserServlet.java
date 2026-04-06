package org.example.demouser.Controller;

import org.example.demouser.Model.User;
import org.example.demouser.Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "user", value = "/user")
    public class UserServlet extends HttpServlet {
        UserService userService = new UserService();
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String action = request.getParameter("action");
            if(action == null){
                action = "";
            }
            switch (action){
                case "view":
                    showView(request,response);
                    break;
                case "create":
                    showFormCreate(request,response);
                    break;
                case "edit":
                    showFormEdit(request,response);
                    break;
                case "delete":
                    deleted(request,response);
                   break;
                default:
                    getListUser(request, response); break;
            }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if(action==null) action = "";
            switch (action){
                case "create":
                    createUser(req, resp);
                    break;
                case "edit":
                        editUser(req,resp);
                    break;
                default:
                    resp.sendRedirect("user");
                    break;
            }
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User existingUser = userService.detailUser(id);

        req.setAttribute("user", existingUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            userService.updateUser(id, name, email, country);
            resp.sendRedirect("user");
        } catch (NumberFormatException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        User newUser = new User(name, email, country);
        try {
            userService.insertUser(newUser);
            resp.sendRedirect("user");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userService.findAll();
        request.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("User/ListUser.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            RequestDispatcher dispatcher = req.getRequestDispatcher("User/create.jsp");
            dispatcher.forward(req,resp);
    }

    private void showView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userService.detailUser(id);
            req.setAttribute("user",user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("User/view.jsp");
            dispatcher.forward(req,resp);
    }


    private void deleted(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean result = false;
        try {
            result = userService.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (result) {
            req.getSession().setAttribute("message", "Xóa thành công");
        } else {
            req.getSession().setAttribute("message", "Xóa thất bại");
        }
        resp.sendRedirect("user");

    }

    public void destroy() {

        }
    }

