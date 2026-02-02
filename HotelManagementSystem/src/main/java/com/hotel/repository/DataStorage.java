/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    }
    
    public List<User> getListUsers() { return listUsers; }
    public List<Room> getListRooms() { return listRooms; }
    public List<Customer> getListCustomers() { return listCustomers; }
    public List<Booking> getListBookings() { return listBookings; }
    
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
                     r.getLoaiPhong().getDisplayName().toLowerCase().contains(keyword.toLowerCase()) || r.getTrangThai().getDisplayName().toLowerCase().contains(keyword.toLowerCase()))
        .collect(Collectors.toList());
    }
   
    public User checkLogin(String username, String password) {
        for (User u : listUsers) {
            if (u.getUserName().equals(username) && u.getPassWord().equals(password)) {
                return u;
            }
        }
        return null;
    }
    
}
