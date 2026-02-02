package com.hotel.model;

public enum RoomType {
    SINGLE("Phòng Đơn"),
    DOUBLE("Phòng Đôi"),
    VIP("Phòng VIP");

    private String displayName;

    RoomType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}