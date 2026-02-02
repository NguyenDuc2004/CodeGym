package com.hotel.model;

public class Booking {
    private String maDatPhong;
    private Customer khachHang; 
    private Room phong;         
    private int ngayCheckIn;  
    private int ngayCheckOut; 
    private double tongTien;

    public Booking() {
    }

    public Booking(String maDatPhong, Customer khachHang, Room phong, int ngayCheckIn, int ngayCheckOut, double tongTien) {
        this.maDatPhong = maDatPhong;
        this.khachHang = khachHang;
        this.phong = phong;
        this.ngayCheckIn = ngayCheckIn;
        this.ngayCheckOut = ngayCheckOut;
        this.tongTien = tongTien;
    }

    // Getters và Setters
    public String getMaDatPhong() { return maDatPhong; }
    public void setMaDatPhong(String maDatPhong) { this.maDatPhong = maDatPhong; }

    public Customer getKhachHang() { return khachHang; }
    public void setKhachHang(Customer khachHang) { this.khachHang = khachHang; }

    public Room getPhong() { return phong; }
    public void setPhong(Room phong) { this.phong = phong; }

    public int getNgayCheckIn() { return ngayCheckIn; }
    public void setNgayCheckIn(int ngayCheckIn) { this.ngayCheckIn = ngayCheckIn; }

    public int getNgayCheckOut() { return ngayCheckOut; }
    public void setNgayCheckOut(int ngayCheckOut) { this.ngayCheckOut = ngayCheckOut; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    @Override
    public String toString() {
        return "Booking{" + 
               "ID='" + maDatPhong + '\'' + 
               ", KH=" + khachHang.getHoTen() + 
               ", Phong=" + phong.getMaPhong() + 
               ", In=" + ngayCheckIn + 
               ", Out=" + ngayCheckOut + 
               '}';
    }
}