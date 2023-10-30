package main.java;

public class RoomSearchModel {
    String roomType;
    Float costPerNight;
    Integer roomNumber;

    public RoomSearchModel(String roomType, Float costPerNight, Integer roomNumber) {
        this.roomType = roomType;
        this.costPerNight = costPerNight;
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Float getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(Float costPerNight) {
        this.costPerNight = costPerNight;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
