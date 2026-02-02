package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.repository.DataStorage;
import com.hotel.view.QLYKHACHHANGFrame;
import com.hotel.view.TrangChuFrame;
import com.hotel.view.BookingsFrame; 
import com.hotel.view.QLYPHONGFrame;

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
        
        view.lbWelcome.setText("Xin chào " + user.getUserName());

        initEvents();
    }
    
    private void initEvents() {
 
        view.btnManageRooms.addActionListener(e -> {
            QLYPHONGFrame roomView = new QLYPHONGFrame();
            new QLYPHONGController(roomView);
            roomView.setVisible(true);
            roomView.setLocationRelativeTo(null);
        });
        view.btnManageBookings.addActionListener(e -> {
            BookingsFrame bookingView = new BookingsFrame(); 
            new BookingController(bookingView);              
            bookingView.setVisible(true);
            bookingView.setLocationRelativeTo(null);
        });
        view.btnManageCustomers.addActionListener(e -> {
            QLYKHACHHANGFrame khView = new QLYKHACHHANGFrame();
            new QLYKHACHHANGController(khView);
            khView.setVisible(true);
            khView.setLocationRelativeTo(null);
        });
       view.btnManageAccounts.addActionListener(e -> {
            if (currentUser.getRole().equalsIgnoreCase("Admin")) {
            com.hotel.view.QLYTAIKHOANFrame accView = new com.hotel.view.QLYTAIKHOANFrame();
            new com.hotel.controller.QLYTAIKHOANController(accView);
            accView.setVisible(true);
            accView.setLocationRelativeTo(null);
            } else {
            javax.swing.JOptionPane.showMessageDialog(view, "Bạn không có quyền truy cập!");
            }
        });
    }
}