/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.repository.DataStorage;
import com.hotel.view.LoginFrame;
import com.hotel.view.QLYPHONGFrame;
import com.hotel.view.TrangChuFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyễn Khắc Minh Đức
 */
public class LoginController {
    private LoginFrame view;
    private DataStorage storage;
    
    public LoginController(LoginFrame view){
        this.view = view;
        this.storage = DataStorage.getInstance();
        
        this.view.btnLogin.addActionListener(e -> handleLogin());
              
    }
    
    private void handleLogin(){
        String userName = view.txtUsername.getText();
        String pass = new String(view.txtPassword.getPassword());
        
        if (userName.isEmpty() || pass.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(view, "Không được để trống tài khoản/mật khẩu!");
        return;
        }
        
        User userLogged = storage.checkLogin(userName, pass);
        
        if(userLogged != null){
            JOptionPane.showMessageDialog(view, "Đăng nhập thành công với quyền: " + userLogged.getRole());
            TrangChuFrame homeView = new TrangChuFrame();
            new TrangChuController(homeView, userLogged);
            homeView.setVisible(true);
            homeView.setLocationRelativeTo(null);
            view.dispose();
        }else{
            JOptionPane.showMessageDialog(view, "Sai tài khoản hoặc mật khẩu");
        }
        
        
    }
    
}
