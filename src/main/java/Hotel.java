package src.main.java;

import java.util.ArrayList;

public class Hotel {
    String hotelName;
    Scheduler scheduler;

    DatabaseReader databaseReader;
    ArrayList<Room> roomList;
    ArrayList<Guest> guestList;


    public Hotel(String hotelNameIn) {
        this.hotelName = hotelNameIn;
        this.databaseReader = new DatabaseReader();
        this.scheduler = new Scheduler();
    }

    public void getRoomsFromDatabase() {
        this.databaseReader.readRooms();
        this.roomList = this.databaseReader.getRooms();
    }

    public void getReservationsFromDatabase() {
        this.databaseReader.readReservations();


    }


}


