package src.main.java;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
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


    /** Checks if a given date is within the current date range for the reservation
     * @param date
     * @return boolean
     */
    public boolean isWithinStay(Date date){

        if(date.equals(this.checkIn) || date.equals(this.checkOut)){
            return true;
        }


        return date.after(checkIn) && date.before(checkOut);

        /*
        if(checkIn.after(date)){
            return false;
        }

        if(checkOut.before(date)){
            return false;
        }

        return true;

         */
    }


    /**
     * Checks if two different reservation ranges overlap
     * @param checkIn
     * @param checkOut
     * @return
     */
    public boolean doReservationsOverlap(Date checkIn, Date checkOut){
        Reservation temp = new Reservation("test",0,checkIn,checkOut);
        return this.isWithinStay(checkIn) || this.isWithinStay(checkOut) || temp.isWithinStay(this.checkIn) || temp.isWithinStay(this.checkOut);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID='" + reservationID + '\'' +
                ", guestID='" + guestID + '\'' +
                ", roomNumber=" + roomNumber +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }

    /**
     * Generates a string in the same CSV format used to store the reservations within the CurrentReservations file
     * @return out
     */
    public String toCSVFormat(){
        String out = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        out+=(reservationID);
        out+=',';
        out+=(guestID);
        out+=',';
        out+=(Integer.toString(roomNumber));
        out+=',';
        out+=(formatter.format(checkIn));
        out+=',';
        out+=(formatter.format(checkOut));
        return out;
    }
}
