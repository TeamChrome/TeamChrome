package src.main.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Hotel {
    String hotelName;
    Scheduler scheduler;

    DatabaseReader databaseReader;
    Map<Integer, Room> roomList;

    Map<String, Reservation> reservations;
    Map<String, Guest> guests;




    public Hotel(String hotelNameIn) {
        this.hotelName = hotelNameIn;
        this.databaseReader = new DatabaseReader();
        this.scheduler = new Scheduler();
        this.roomList = new HashMap<Integer, Room>();
        this.reservations = new HashMap<String, Reservation>();
        this.guests = new HashMap<String, Guest>();
    }

    public void getRoomsFromDatabase() {
        this.databaseReader.readRooms();
        for(Room room: this.databaseReader.getRooms()){
            this.roomList.put(room.roomNumber,room);
        }
    }

    public void getReservationsFromDatabase() {
        this.databaseReader.readReservations();
        for(Reservation reservation: this.databaseReader.getReservations()){
            this.reservations.put(reservation.getReservationID(),reservation);
        }
    }

    // TODO: 11/10/23
    public boolean checkIfTimeAvailableForRoom(Integer roomNumber, Date checkIn, Date checkOut){
        //Delegate to scheduler
        return false;

    }

    /**
     * Reserves a room for a guest using given parameters
     * @param guestIn
     * @param roomNumber
     * @param checkIn
     * @param checkOut
     * @return reservationId
     */
    public String reserveRoomForGuest(Guest guestIn, Integer roomNumber, Date checkIn, Date checkOut){
        Room roomToReserve = this.roomList.get(roomNumber);
        Reservation reservation = this.scheduler.createReservation(guestIn,roomToReserve,checkIn,checkOut);
        String reservationId = reservation.getReservationID();
        this.scheduler.addReservation(this.reservations,reservation);
        return reservationId;

    }


    /**
     * Adds a new guest to the scheduler
     * @param guestIn
     */
    public void addNewGuest(Guest guestIn){
        this.scheduler.addGuest(this.guests,guestIn);
    }




}


