/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.repository.DataStorage;
import com.hotel.view.TrangChuFrame;

/**
 *
 * @author Nguyễn Khắc Minh Đức
 */
public class TrangChuController {
    private TrangChuFrame view;
    private User currentUser;
    private DataStorage storage;
    
    public TrangChuController(TrangChuFrame view, User user) {
        this.view = view;
        this.currentUser = user;
        this.storage = DataStorage.getInstance();
        
        view.lbWelcome.setText("Xin chào "+user.getUserName());

        // 2. Gắn sự kiện cho các nút bấm trên Menu
        initEvents();
    }
    
    private void initEvents() {
       view.btnManageRooms.addActionListener(e -> {
            com.hotel.view.QLYPHONGFrame roomView = new com.hotel.view.QLYPHONGFrame();
            new com.hotel.controller.QLYPHONGController(roomView);
            roomView.setVisible(true);
            roomView.setLocationRelativeTo(null);
    });

     
        view.btnManageBookings.addActionListener(e -> {
            javax.swing.JOptionPane.showMessageDialog(view, "Chức năng Đặt phòng đang được xây dựng!");
        });

   
        view.btnManageCustomers.addActionListener(e -> {
            javax.swing.JOptionPane.showMessageDialog(view, "Chức năng Khách hàng đang được xây dựng!");
        });

    
        view.btnManageAccounts.addActionListener(e -> {
            if (currentUser.getRole().equalsIgnoreCase("Admin")) {
                javax.swing.JOptionPane.showMessageDialog(view, "Chào Admin! Đang mở Quản lý tài khoản...");
            } else {
                javax.swing.JOptionPane.showMessageDialog(view, "Bạn không có quyền truy cập chức năng này!");
            }
        });
    }
    
   
}
