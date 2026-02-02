package com.hotel.controller;

import com.hotel.model.Booking;
import com.hotel.model.Customer;
import com.hotel.model.Room;
import com.hotel.repository.DataStorage;
import com.hotel.view.BookingsFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BookingController {
    private BookingsFrame view;
    private DataStorage storage;

    public BookingController(BookingsFrame view) {
        this.view = view;
        this.storage = DataStorage.getInstance();

        view.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        initComboBoxData();
        loadDataToTable();
        initEvents();

        view.tbBookings.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                displaySelectedBooking();
            }
        });
    }

   private void initComboBoxData() {
 
    javax.swing.JComboBox comboKH = (javax.swing.JComboBox) view.txtKhDat;
    javax.swing.JComboBox comboPhong = (javax.swing.JComboBox) view.txtPhongDat;

    comboKH.removeAllItems();
    comboPhong.removeAllItems();
    
    for (Customer c : storage.getListCustomers()) {
        comboKH.addItem(c); 
    }
    
    for (Room r : storage.getListRooms()) {
        comboPhong.addItem(r);
    }
}

    private void initEvents() {
        view.btnThemBook.addActionListener(e -> handleAddBooking());
        view.btnRefesh.addActionListener(e -> handleRefresh());
        view.btnHuyBook.addActionListener(e -> handleDeleteBooking());
        view.btnSuaBook.addActionListener(e -> handleUpdateBooking());
    }

    private void handleAddBooking() {
        try {
            String ma = view.txtMaDat.getText().trim();
            Customer kh = (Customer) view.txtKhDat.getSelectedItem();
            Room phong = (Room) view.txtPhongDat.getSelectedItem();
            
            int ngayIn = Integer.parseInt(view.txtIn.getText().trim());
            int ngayOut = Integer.parseInt(view.txtOut.getText().trim());

            if (ma.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nhập mã đặt phòng!");
                return;
            }

            if (ngayIn < 1 || ngayIn > 31 || ngayOut < 1 || ngayOut > 31 || ngayOut <= ngayIn) {
                JOptionPane.showMessageDialog(view, "Ngày 1-31 và Out phải lớn hơn In!");
                return;
            }

            double tongTien = (ngayOut - ngayIn) * phong.getGiaPhong();
            Booking newBooking = new Booking(ma, kh, phong, ngayIn, ngayOut, tongTien);
            
            storage.addBooking(newBooking);
            loadDataToTable();
            handleRefresh();
            JOptionPane.showMessageDialog(view, "Thêm thành công!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ngày phải là số!");
        }
    }

    private void handleUpdateBooking() {
        try {
            String ma = view.txtMaDat.getText().trim();
            Customer kh = (Customer) view.txtKhDat.getSelectedItem();
            Room phong = (Room) view.txtPhongDat.getSelectedItem();
            int ngayIn = Integer.parseInt(view.txtIn.getText().trim());
            int ngayOut = Integer.parseInt(view.txtOut.getText().trim());
            double tongTien = (ngayOut - ngayIn) * phong.getGiaPhong();

            Booking upBooking = new Booking(ma, kh, phong, ngayIn, ngayOut, tongTien);
            if (storage.updateBooking(upBooking)) {
                loadDataToTable();
                JOptionPane.showMessageDialog(view, "Đã cập nhật!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Lỗi sửa dữ liệu!");
        }
    }

    private void handleDeleteBooking() {
        String ma = view.txtMaDat.getText().trim();
        if (storage.deleteBooking(ma)) {
            loadDataToTable();
            handleRefresh();
            JOptionPane.showMessageDialog(view, "Đã hủy đơn!");
        }
    }

    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) view.tbBookings.getModel();
        model.setRowCount(0);
        for (Booking b : storage.getListBookings()) {
            model.addRow(new Object[]{
                b.getMaDatPhong(),
                b.getKhachHang().getHoTen(),
                b.getPhong().getMaPhong(),
                b.getNgayCheckOut(),
                b.getNgayCheckIn(),
                b.getTongTien()
            });
        }
    }

    private void handleRefresh() {
        view.txtMaDat.setText("");
        view.txtIn.setText("");
        view.txtOut.setText("");
        if(view.txtKhDat.getItemCount() > 0) view.txtKhDat.setSelectedIndex(0);
        if(view.txtPhongDat.getItemCount() > 0) view.txtPhongDat.setSelectedIndex(0);
    }

    private void displaySelectedBooking() {
        int row = view.tbBookings.getSelectedRow();
        if (row == -1) return;
        
        String id = view.tbBookings.getValueAt(row, 0).toString();
        for (Booking b : storage.getListBookings()) {
            if (b.getMaDatPhong().equals(id)) {
                view.txtMaDat.setText(b.getMaDatPhong());
                view.txtIn.setText(String.valueOf(b.getNgayCheckIn()));
                view.txtOut.setText(String.valueOf(b.getNgayCheckOut()));
               
                view.txtKhDat.setSelectedItem(b.getKhachHang());
                view.txtPhongDat.setSelectedItem(b.getPhong());
                break;
            }
        }
    }
}