package com.hotel.model;

public class Customer {
    private String maKH;
    private String hoTen;
    private String soDT;
    private String cccd;

    public Customer() {
    }

    public Customer(String maKH, String hoTen, String soDT, String cccd) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.cccd = cccd;
    }


    public String getMaKH() { return maKH; }
    public void setMaKH(String maKH) { this.maKH = maKH; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getSoDT() { return soDT; }
    public void setSoDT(String soDT) { this.soDT = soDT; }

    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }

    @Override
    public String toString() {
        return "Customer{" + "maKH=" + maKH + ", hoTen=" + hoTen + '}';
    }
}