package src.main.java;


import java.util.Date;
import java.util.UUID;

public class Reservation {
    private String reservationID;
    private String guestID;
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation(String guestID, int roomNumber, Date checkIn, Date checkOut) {
        this.reservationID = UUID.randomUUID().toString();
        this.guestID = guestID;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Reservation() {
        this.reservationID = "";
        this.guestID = "";
        this.roomNumber = 0;
        this.checkIn = null;
        this.checkOut = null;
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

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public boolean isWithinStay(Date date){
        if(checkIn.after(date)){
            return false;
        }

        if(checkOut.before(date)){
            return false;
        }

        return true;
    }
}
