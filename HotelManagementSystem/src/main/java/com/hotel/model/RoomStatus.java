package com.hotel.model;

public enum RoomStatus {
    AVAILABLE("Trống"),
    OCCUPIED("Đang có khách"),
    MAINTENANCE("Đang bảo trì");

    private String displayName;

    RoomStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}