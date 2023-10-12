package src.main.java;

import java.time.Period;
import java.util.UUID;

public class Reservation {
    private String reservationID;
    private String guestID;
    private int roomNumber;
    private Period reservationTime;

    public Reservation(String guestID, int roomNumber, Period reservationTime) {
        this.reservationID = UUID.randomUUID().toString();
        this.guestID = guestID;
        this.roomNumber = roomNumber;
        this.reservationTime = reservationTime;
    }

    public Reservation() {
        this.reservationID = "";
        this.guestID = "";
        this.roomNumber = 0;
        this.reservationTime = Period.ZERO;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Period getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Period reservationTime) {
        this.reservationTime = reservationTime;
    }
}
