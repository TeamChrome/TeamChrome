package src.main.java;

public class Room {
    public enum RoomType{
        KING,SUITE,DOUBLE,INVALID
    }

    public static final int MAXIMUM_ROOM_NUMBER = 999;
    public static final int MAXIMUM_ROOM_LEVEL = 5;

    RoomType roomType;
    int roomNumber;

    float roomCost;
    int roomLevel;
    boolean checkedIn;

    public Room() {
        this.roomType = RoomType.INVALID;
        this.roomNumber = 0;
        this.roomLevel = 0;
        this.checkedIn = false;
        this.roomCost = 0.0f;
    }

    public Room(RoomType roomType, int roomNumber, int roomLevel, boolean checkedIn, float roomCost) {
        this.roomType = roomType;
        this.setRoomNumber(roomNumber);
        this.setRoomLevel(roomLevel);
        this.checkedIn = checkedIn;
        this.roomCost = roomCost;
    }

    /**
     * Gets the room type
     * @return roomType
     */
    public RoomType getRoomType() {
        return roomType;
    }

    /**
     * Sets the room type
     * @param roomType
     */
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    /**
     * Returns the room number
     * @return roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room level and discards and generates warning messages if outside of range
     * @param roomNumber
     */
    public void setRoomNumber(int roomNumber) {
        if(roomNumber < 0 || roomNumber > MAXIMUM_ROOM_NUMBER){
            System.err.println("[Room.setRoomNumber] The given roomNumber is invalid: " + roomNumber);
            return;
        }
        this.roomNumber = roomNumber;
    }

    /**
     *
     * @return roomLevel
     */
    public int getRoomLevel() {
        return roomLevel;
    }

    /**
     * Sets the room level and discards and generates warning messages if outside of range
     * @param roomLevel
     */
    public void setRoomLevel(int roomLevel) {
        if(roomLevel < 0 || roomLevel > MAXIMUM_ROOM_LEVEL){
            System.err.println("[Room.setRoomLevel] The given roomLevel is invalid: " + roomLevel);
            return;
        }
        this.roomLevel = roomLevel;
    }

    /**
     * Returns if room is checkedIn
     * @return checkedIn
     */
    public boolean isCheckedIn() {
        return checkedIn;
    }

    /**
     *
     */
    public void checkIn(){
        this.checkedIn = true;
    }

    /**
     *
     */
    public void checkOut(){
        this.checkedIn = false;
    }

    /**
     * Sets the checkedIn value
     * @param checkedIn
     */
    //we won't need this if we decide to have two different checkIn or checkOut functions
    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }


    /**
     * @return roomCost
     */
    public float getRoomCost() {
        return roomCost;
    }

    /**
     * Sets the roomCost
     * @param roomCost
     */
    public void setRoomCost(float roomCost) {
        this.roomCost = roomCost;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomType=" + roomType +
                ", roomNumber=" + roomNumber +
                ", roomCost=" + roomCost +
                ", roomLevel=" + roomLevel +
                ", checkedIn=" + checkedIn +
                '}';
    }


    public String getPrettyStringRoom(){
        String out = "";
        out+= "Room Floor: " + this.roomLevel + "\n";
        out+= "Room Number: " + this.roomNumber + "\n";
        out+= "Room Cost: $" + this.roomCost + " per day" + "\n";
        return out;
    }
}
