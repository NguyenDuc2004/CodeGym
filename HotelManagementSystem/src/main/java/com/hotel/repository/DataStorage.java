package com.hotel.repository;

import com.hotel.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Nguyễn Khắc Minh Đức
 */
public class DataStorage {
    private static DataStorage instance;
    
    private List<User> listUsers;
    private List<Room> listRooms;
    private List<Customer> listCustomers;
    private List<Booking> listBookings;
    
    private DataStorage() {
        listUsers = new ArrayList<>();
        listRooms = new ArrayList<>();
        listCustomers = new ArrayList<>();
        listBookings = new ArrayList<>();
        
        initSampleData();
    }
    
    public static DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }
    
    private void initSampleData(){
        listUsers.add(new User("admin", "123", "Admin"));
        listUsers.add(new User("staff", "123", "Staff"));

        listRooms.add(new Room("P101", RoomType.SINGLE, 500000, RoomStatus.AVAILABLE));
        listRooms.add(new Room("P102", RoomType.DOUBLE, 800000, RoomStatus.AVAILABLE));
        listRooms.add(new Room("P103", RoomType.VIP, 1500000, RoomStatus.AVAILABLE));
        
        listCustomers.add(new Customer("KH01","MINH DUC","090000009","0333111122"));
        listCustomers.add(new Customer("KH02","KIM JI WON","090000009","03331132323"));
        listCustomers.add(new Customer("KH03","BAE SUZY","0903333333","0333112131"));
    }
    
    public List<User> getListUsers() { return listUsers; }
    public List<Room> getListRooms() { return listRooms; }
    public List<Customer> getListCustomers() { return listCustomers; }
    public List<Booking> getListBookings() { return listBookings; }
    
    // ================== QUẢN LÝ PHÒNG ==================
    public void addRoom(Room room) {
        this.listRooms.add(room);
    }
   
    public boolean deleteRoom(String maPhong) {
        return listRooms.removeIf(room -> room.getMaPhong().equals(maPhong));
    }
   
    public boolean updateRoom(Room updatedRoom) {
        for (int i = 0; i < listRooms.size(); i++) {
            if (listRooms.get(i).getMaPhong().equals(updatedRoom.getMaPhong())) {
                listRooms.set(i, updatedRoom);
                return true; 
            }
        }
        return false; 
    }

    public List<Room> searchRooms(String keyword) {
        return listRooms.stream()
            .filter(r -> r.getMaPhong().toLowerCase().contains(keyword.toLowerCase()) || 
                         r.getLoaiPhong().getDisplayName().toLowerCase().contains(keyword.toLowerCase()) || 
                         r.getTrangThai().getDisplayName().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toList());
    }
   
    // ================== QUẢN LÝ KHÁCH HÀNG ==================
    public void addKH(Customer newCus){
        listCustomers.add(newCus);
    }
   
    public boolean deleteKH(String id){
        return listCustomers.removeIf(cus -> cus.getMaKH().equals(id));
    }
   
    public boolean updateKH(Customer cus) {
        for (int i = 0; i < listCustomers.size(); i++) {
            if (listCustomers.get(i).getMaKH().equals(cus.getMaKH())) {
                listCustomers.set(i, cus);
                return true; 
            }
        }
        return false; 
    }

    // ================== QUẢN LÝ ĐẶT PHÒNG (MỚI THÊM) ==================
    public void addBooking(Booking booking) {
        listBookings.add(booking);
    }

    public boolean deleteBooking(String maDat) {
        return listBookings.removeIf(b -> b.getMaDatPhong().equals(maDat));
    }

    public boolean updateBooking(Booking booking) {
        for (int i = 0; i < listBookings.size(); i++) {
            if (listBookings.get(i).getMaDatPhong().equals(booking.getMaDatPhong())) {
                listBookings.set(i, booking);
                return true;
            }
        }
        return false;
    }

    // ================== HỆ THỐNG ==================
    public User checkLogin(String username, String password) {
        for (User u : listUsers) {
            if (u.getUserName().equals(username) && u.getPassWord().equals(password)) {
                return u;
            }
        }
        return null;
    }
}