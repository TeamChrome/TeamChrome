package src.main.java;

public class Room {
    public enum RoomType{
        KING,SUITE,DOUBLE,INVALID
    }

    public static final int MAXIMUM_ROOM_NUMBER = 999;
    public static final int MAXIMUM_ROOM_LEVEL = 5;

    RoomType roomType;
    int roomNumber;
    int roomLevel;
    boolean checkedIn;

    public Room() {
        this.roomType = RoomType.INVALID;
        this.roomNumber = 0;
        this.roomLevel = 0;
        this.checkedIn = false;
    }

    public Room(RoomType roomType, int roomNumber, int roomLevel, boolean checkedIn) {
        this.roomType = roomType;
        this.setRoomNumber(roomNumber);
        this.setRoomLevel(roomLevel);
        this.checkedIn = checkedIn;
    }

    //comments
    //isn't the room level the first digit of the room number?
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        if(roomNumber < 0 || roomNumber > MAXIMUM_ROOM_NUMBER){
            System.err.println("[Room.setRoomNumber] The given roomNumber is invalid: " + roomNumber);
            return;
        }
        this.roomNumber = roomNumber;
    }

    public int getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(int roomLevel) {
        if(roomLevel < 0 || roomLevel > MAXIMUM_ROOM_LEVEL){
            System.err.println("[Room.setRoomLevel] The given roomLevel is invalid: " + roomLevel);
            return;
        }
        this.roomLevel = roomLevel;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void checkIn(){
        this.checkedIn = true;
    }

    public void checkOut(){
        this.checkedIn = false;
    }

    //we won't need this if we decide to have two different checkIn or checkOut functions
    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }


}
