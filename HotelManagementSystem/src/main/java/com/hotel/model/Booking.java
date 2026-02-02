package com.hotel.model;

import java.time.LocalDate;

public class Booking {
    private String maDatPhong;
    private Customer khachHang; 
    private Room phong;         
    private LocalDate ngayCheckIn;
    private LocalDate ngayCheckOut;
    private double tongTien;

    public Booking() {
    }

    public Booking(String maDatPhong, Customer khachHang, Room phong, LocalDate ngayCheckIn, LocalDate ngayCheckOut, double tongTien) {
        this.maDatPhong = maDatPhong;
        this.khachHang = khachHang;
        this.phong = phong;
        this.ngayCheckIn = ngayCheckIn;
        this.ngayCheckOut = ngayCheckOut;
        this.tongTien = tongTien;
    }


    public String getMaDatPhong() { return maDatPhong; }
    public void setMaDatPhong(String maDatPhong) { this.maDatPhong = maDatPhong; }

    public Customer getKhachHang() { return khachHang; }
    public void setKhachHang(Customer khachHang) { this.khachHang = khachHang; }

    public Room getPhong() { return phong; }
    public void setPhong(Room phong) { this.phong = phong; }

    public LocalDate getNgayCheckIn() { return ngayCheckIn; }
    public void setNgayCheckIn(LocalDate ngayCheckIn) { this.ngayCheckIn = ngayCheckIn; }

    public LocalDate getNgayCheckOut() { return ngayCheckOut; }
    public void setNgayCheckOut(LocalDate ngayCheckOut) { this.ngayCheckOut = ngayCheckOut; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    @Override
    public String toString() {
        return "Booking{" + "id=" + maDatPhong + ", KH=" + khachHang.getHoTen() + ", Phong=" + phong.getMaPhong() + '}';
    }
}