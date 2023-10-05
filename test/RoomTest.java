package test;


import Room.Room;
import org.junit.Assert;
import org.junit.Test;
public class RoomTest {
    @Test
    public void RoomConstructorDefault(){
        Room roomConstructorDefault = new Room();
        Assert.assertEquals(roomConstructorDefault.getRoomType(),Room.RoomType.INVALID);
        Assert.assertEquals(roomConstructorDefault.getRoomNumber(),0);
        Assert.assertEquals(roomConstructorDefault.getRoomLevel(),0);
        Assert.assertFalse(roomConstructorDefault.isCheckedIn());
    }

    @Test
    public void RoomConstructorParam(){
        Room roomConstructorParam = new Room(Room.RoomType.SUITE,123,1,false);
        Assert.assertEquals(roomConstructorParam.getRoomType(),Room.RoomType.SUITE);
        Assert.assertEquals(roomConstructorParam.getRoomNumber(),123);
        Assert.assertEquals(roomConstructorParam.getRoomLevel(),1);
        Assert.assertFalse(roomConstructorParam.isCheckedIn());
    }

    @Test
    public void RoomSetCheckedIn(){
        Room roomSetCheckedIn = new Room(Room.RoomType.SUITE,123,1,false);
        roomSetCheckedIn.setCheckedIn(true);
        Assert.assertTrue(roomSetCheckedIn.isCheckedIn());
        roomSetCheckedIn.setCheckedIn(false);
        Assert.assertFalse(roomSetCheckedIn.isCheckedIn());
    }

    @Test
    public void RoomCheckInOut(){
        Room roomSetCheckedIn = new Room(Room.RoomType.SUITE,123,1,false);
        roomSetCheckedIn.checkIn();
        Assert.assertTrue(roomSetCheckedIn.isCheckedIn());
        roomSetCheckedIn.checkIn();
        Assert.assertTrue(roomSetCheckedIn.isCheckedIn());
        roomSetCheckedIn.checkOut();
        Assert.assertFalse(roomSetCheckedIn.isCheckedIn());
        roomSetCheckedIn.checkOut();
        Assert.assertFalse(roomSetCheckedIn.isCheckedIn());
    }

    @Test
    public void setRoomLevel(){
        Room roomSetCheckedIn = new Room(Room.RoomType.SUITE,123,1,false);
        int[] roomsToCheck = {1,2,3,4,5};
        for(int x: roomsToCheck){
            roomSetCheckedIn.setRoomLevel(x);
            Assert.assertEquals(roomSetCheckedIn.getRoomLevel(),x);
        }

        roomSetCheckedIn.setRoomLevel(-1);
        Assert.assertEquals(roomSetCheckedIn.getRoomLevel(),roomsToCheck[roomsToCheck.length-1]);
    }

    @Test
    public void setRoomNumber() {
        Room roomSetNumber = new Room(Room.RoomType.SUITE, 123, 1, false);
        for (int i = 0; i < Room.MAXIMUM_ROOM_NUMBER; i++) {
            roomSetNumber.setRoomNumber(i);
            Assert.assertEquals(roomSetNumber.getRoomNumber(), i);
        }
    }

}
