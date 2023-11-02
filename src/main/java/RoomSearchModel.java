package src.main.java;


public class RoomSearchModel {
    String roomType;
    Float costPerNight;
    Integer roomNumber;

    Integer roomLevel;

    public RoomSearchModel(String roomType, Float costPerNight, Integer roomNumber, Integer roomLevel) {
        this.roomType = roomType;
        this.costPerNight = costPerNight;
        this.roomNumber = roomNumber;
        this.roomLevel = roomLevel;
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

    public Integer getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(Integer roomLevel) {
        this.roomLevel = roomLevel;
    }

    @Override
    public String toString() {
        return "RoomSearchModel{" +
                "roomType='" + roomType + '\'' +
                ", costPerNight=" + costPerNight +
                ", roomNumber=" + roomNumber +
                '}';
    }

    public Room toRoom(){
        return new Room(Room.RoomType.valueOf(this.roomType),this.roomNumber,this.roomLevel,false);
    }


}
