/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelmanagementsystem;

import com.hotel.controller.LoginController;
import com.hotel.controller.QLYPHONGController;
import com.hotel.view.LoginFrame;
import com.hotel.view.QLYPHONGFrame;

/**
 *
 * @author Nguyễn Khắc Minh Đức
 */
public class HotelManagementSystem {

   public static void main(String[] args) {
   java.awt.EventQueue.invokeLater(() -> {
            
            LoginFrame loginView = new LoginFrame();
            
            new LoginController(loginView); 
            
            loginView.setVisible(true);
            loginView.setLocationRelativeTo(null); 
            
            
        });
    }
}

