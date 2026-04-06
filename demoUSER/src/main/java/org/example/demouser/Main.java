//package org.example.demouser;
//
//import org.example.demouser.DbConnection.DbConnection;
//
//import java.io.*;
//import java.sql.Connection;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
//@WebServlet(name = "user", value = "/user")
//public class Main extends HttpServlet {
//    private String message;
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Connection conn = DbConnection.getConnection();
//        if(conn != null){
//            System.out.println("thanh cong roi: "+ conn);
//        }else{
//            System.out.println("fail");
//        }
//    }
//
//    public void destroy() {
//
//    }
//}