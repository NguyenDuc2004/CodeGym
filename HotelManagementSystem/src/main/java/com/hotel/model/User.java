/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.model;

/**
 *
 * @author Nguyễn Khắc Minh Đức
 */
public class User {
    private String userName;
    private String passWord;
    private String role;

    public User() {
    }

    public User(String userName, String passWord, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
    
    public String getRole() { return role; }
    
    
}
