/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.controller;

import com.hotel.model.Room;
import com.hotel.model.RoomStatus;
import com.hotel.model.RoomType;
import com.hotel.repository.DataStorage;
import com.hotel.view.QLYPHONGFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nguyễn Khắc Minh Đức
 */
public class QLYPHONGController {
    private QLYPHONGFrame view;
    private DataStorage storage;

    public QLYPHONGController(QLYPHONGFrame view) {
        this.view = view;
        this.storage = DataStorage.getInstance();
        
        view.cbRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(RoomType.values()));
        view.cbRoomType.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof RoomType) {
                setText(((RoomType) value).getDisplayName());
            }
            return this;
         }
        });
        view.cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(RoomStatus.values()));
        view.cbStatus.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof RoomStatus) {
                setText(((RoomStatus) value).getDisplayName());
            }
            return this;
        }
    });
        
        loadDataToTable();
        
        
          view.btnAdd.addActionListener(e -> handleAddRoom());
          view.btnUpdate.addActionListener(e -> handleUpdateRoom());
          view.btnDelete.addActionListener(e -> handleDeleteRoom());
          view.btnClear.addActionListener(e -> clearFields());
        
        view.tblRooms.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            displaySelectedRoom();
        }
    });
      
    view.txtSearch.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    @Override
    public void insertUpdate(javax.swing.event.DocumentEvent e) {
        handleSearch();
    }

    @Override
    public void removeUpdate(javax.swing.event.DocumentEvent e) {
        handleSearch();
    }

    @Override
    public void changedUpdate(javax.swing.event.DocumentEvent e) {
        handleSearch();
    }
    });
    }
    
    private void handleAddRoom(){
        
        try{
            String maPhong = view.txtRoomId.getText().trim();
            String gia = view.txtPrice.getText().trim();
            if (maPhong.isEmpty() || gia.isEmpty()) {
                 javax.swing.JOptionPane.showMessageDialog(view, "Vui lòng nhập đủ Mã và Giá!");
                return;
            }
            for(Room r : storage.getListRooms()){
                if(r.getMaPhong().equalsIgnoreCase(maPhong)){
                    javax.swing.JOptionPane.showMessageDialog(view, "Ma phong da ton tai!");
                    return;
                }
            }
            
            double price = Double.parseDouble(gia);
            RoomType loai = (RoomType) view.cbRoomType.getSelectedItem();
            RoomStatus tthai = (RoomStatus) view.cbStatus.getSelectedItem();
        
            storage.addRoom(new Room(maPhong,loai,price,tthai));
            loadDataToTable();
            clearFields();
        }catch(NumberFormatException e){
            javax.swing.JOptionPane.showMessageDialog(view, "Giá phòng phải là số!");
        }
    }
    
    public void handleDeleteRoom(){
         String maPhong = view.txtRoomId.getText().trim();
         if(maPhong.isEmpty()){
             javax.swing.JOptionPane.showMessageDialog(view, "Vui lòng chọn 1 phòng hoặc nhập mã phòng để xóa!");
             return;
         }
         if(storage.deleteRoom(maPhong)){
             loadDataToTable();
             clearFields();
             javax.swing.JOptionPane.showMessageDialog(view,"Xóa thành công");
         }else{
             javax.swing.JOptionPane.showMessageDialog(view,"Không tồn tại phòng đó");

         }
           
    }
    
    public void handleUpdateRoom(){
        try{
         String maPhong = view.txtRoomId.getText().trim();
         if(maPhong.isEmpty()){
             javax.swing.JOptionPane.showMessageDialog(view, "Vui lòng chon 1 phòng cập nhật!");
             return;
         }
         String gia = view.txtPrice.getText().trim();
         RoomType loai = (RoomType) view.cbRoomType.getSelectedItem();
         RoomStatus Tthai = (RoomStatus) view.cbStatus.getSelectedItem();
         double price = Double.parseDouble(gia);
         Room upDateRoom = new Room(maPhong,loai,price,Tthai);
         if (storage.updateRoom(upDateRoom)) {
            loadDataToTable();
            clearFields();
            javax.swing.JOptionPane.showMessageDialog(view, "Cập nhật thành công!");
        }else {
            javax.swing.JOptionPane.showMessageDialog(view, "Lỗi: Không tìm thấy mã phòng để cập nhật!");
        }
        }catch(NumberFormatException e){
         javax.swing.JOptionPane.showMessageDialog(view, "Giá phải là số!");

        }
      
         
    }
    
    private void handleSearch() {
    String keyword = view.txtSearch.getText().trim();
    
    java.util.List<Room> results = storage.searchRooms(keyword);
    
 
    DefaultTableModel model = (DefaultTableModel) view.tblRooms.getModel();
    model.setRowCount(0); 
    
    for (Room r : results) {
        model.addRow(new Object[]{
            r.getMaPhong(),
            r.getLoaiPhong().getDisplayName(),
            r.getGiaPhong(),
            r.getTrangThai().getDisplayName()
        });
    }
    }
    
    private void displaySelectedRoom() {
        int row = view.tblRooms.getSelectedRow();
        if (row == -1) return;

        // Lấy mã phòng từ cột 0 của bảng
        String id = view.tblRooms.getValueAt(row, 0).toString();
    
        for (Room r : storage.getListRooms()) {
            if (r.getMaPhong().equals(id)) {
                view.txtRoomId.setText(r.getMaPhong());
                view.txtPrice.setText(String.valueOf(r.getGiaPhong()));
                view.cbRoomType.setSelectedItem(r.getLoaiPhong());
                view.cbStatus.setSelectedItem(r.getTrangThai());
                break;
            }
        }
}

    private void clearFields() {
    view.txtRoomId.setText("");
    view.txtPrice.setText("");
    view.cbRoomType.setSelectedIndex(0);
    view.cbStatus.setSelectedIndex(0);
    view.tblRooms.clearSelection();
}
    
    
    
    public void loadDataToTable(){
        DefaultTableModel model = (DefaultTableModel) view.tblRooms.getModel();
        
        model.setRowCount(0);
        
        for(Room r : storage.getListRooms()){
            model.addRow(new Object[]{
                r.getMaPhong(),
                r.getLoaiPhong().getDisplayName(),
                r.getGiaPhong(),
                r.getTrangThai().getDisplayName()
            });
        }
    }
    
    
}
