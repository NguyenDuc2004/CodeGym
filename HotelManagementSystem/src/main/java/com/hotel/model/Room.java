package com.hotel.model;

public class Room {
    private String maPhong;
    private RoomType loaiPhong;  
    private double giaPhong;
    private RoomStatus trangThai; 

    public Room() {
    }

    public Room(String maPhong, RoomType loaiPhong, double giaPhong, RoomStatus trangThai) {
        this.maPhong = maPhong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.trangThai = trangThai;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    
    public RoomType getLoaiPhong() { return loaiPhong; }
    public void setLoaiPhong(RoomType loaiPhong) { this.loaiPhong = loaiPhong; }

    public RoomStatus getTrangThai() { return trangThai; }
    public void setTrangThai(RoomStatus trangThai) { this.trangThai = trangThai; }

  
}