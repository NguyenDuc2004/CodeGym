/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;

import com.hotel.model.Customer;
import com.hotel.model.Room;
import com.hotel.model.User;
import com.hotel.repository.DataStorage;
import com.hotel.view.QLYKHACHHANGFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyễn Khắc Minh Đức
 */
public class QLYKHACHHANGController {
    private QLYKHACHHANGFrame view;
    private DataStorage storage;
    
    public QLYKHACHHANGController(QLYKHACHHANGFrame view){
        this.view = view;
        this.storage = DataStorage.getInstance();
        
        view.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        
        loadDataToTable();
        initEvents();
        
         view.tbKhachHang.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            displaySelectedCus();
            }
         });
     }
    
    private void initEvents() {
        view.btnThem.addActionListener(e -> handleAddKH());
        view.btnLamMoi.addActionListener(e-> handleRefesh());
        view.btnXoa.addActionListener(e -> handleXoaKH());
        view.btnSua.addActionListener(e -> handleSuaKH());
    }
    private void handleXoaKH(){
        String ma = view.txtMaKH.getText().trim();
        if(ma.isEmpty()){
             javax.swing.JOptionPane.showMessageDialog(view,"Vui lòng chọn 1 KH hoặc nhập mã để xóa!");
             return;
        }
        if(storage.deleteKH(ma)){
            loadDataToTable();
            handleRefesh();
            javax.swing.JOptionPane.showMessageDialog(view,"Xóa thành công!");
        }else{
            javax.swing.JOptionPane.showMessageDialog(view,"Không tồn tại khách hàng này!");
        }
    }
    private void handleAddKH(){
        String ma = view.txtMaKH.getText().trim();
        String hoten = view.txtTenKH.getText().trim();
        String sdt = view.txtSoDT.getText().trim();
        String cccd = view.txtCCCD.getText().trim();
        
        if(ma.isEmpty() || hoten.isEmpty() || sdt.isEmpty() || cccd.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(view,"Vui lòng nhập đủ thông tin!");
            return;
        }
        
        for(Customer cus : storage.getListCustomers()){
                if(cus.getMaKH().equalsIgnoreCase(ma)){
                    javax.swing.JOptionPane.showMessageDialog(view, "Mã đã tồn tại!");
                    return;
                }
            }
        
        Customer newCus = new Customer(ma,hoten,sdt,cccd);
        storage.addKH(newCus);
        loadDataToTable();
    }
    private void handleSuaKH(){
         String ma = view.txtMaKH.getText().trim();
         if(ma.isEmpty()){
             javax.swing.JOptionPane.showMessageDialog(view, "Vui lòng chon 1 KH cập nhật!");
             return;
         }
        String hoten = view.txtTenKH.getText().trim();
        String sdt = view.txtSoDT.getText().trim();
        String cccd = view.txtCCCD.getText().trim();
        
        Customer upCus = new Customer(ma,hoten,sdt,cccd);
        if(storage.updateKH(upCus)){
            loadDataToTable();
            handleRefesh();
            javax.swing.JOptionPane.showMessageDialog(view, "Cập nhật thành công!");
        }else{
             javax.swing.JOptionPane.showMessageDialog(view, "Mã khách hàng không tồn tại!");

        }
         
    }
    
    private void loadDataToTable() {
        if(storage.getListCustomers().size()<=0){
            javax.swing.JOptionPane.showMessageDialog(view,"Chưa có dữ liệu!");
        }
        DefaultTableModel model = (DefaultTableModel) view.tbKhachHang.getModel();
        
        model.setRowCount(0);
        
        for(Customer c : storage.getListCustomers()){
            model.addRow(new Object[]{
                c.getMaKH(),
                c.getHoTen(),
                c.getSoDT(),
                c.getCccd()
            });
        }
    }
    
    private void handleRefesh(){
        view.txtMaKH.setText("");
        view.txtTenKH.setText("");
        view.txtSoDT.setText("");
        view.txtCCCD.setText("");
    }
    
     private void displaySelectedCus() {
        int row = view.tbKhachHang.getSelectedRow();
        if (row == -1) return;

       
        String id = view.tbKhachHang.getValueAt(row, 0).toString();
    
        for (Customer c : storage.getListCustomers()) {
            if (c.getMaKH().equals(id)) {
                view.txtMaKH.setText(c.getMaKH());
                view.txtTenKH.setText(c.getHoTen());
                view.txtSoDT.setText(c.getSoDT());
                view.txtCCCD.setText(c.getCccd());
                break;
            }
        }
}
    
}
