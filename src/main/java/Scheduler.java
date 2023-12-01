package src.main.java;
import java.util.*;

public class Scheduler {


    public Scheduler() {

    }

    public Reservation createReservation(Guest g, Room r, Date checkIn, Date checkOut) {
        return new Reservation(g.getId(), r.getRoomNumber(), checkIn, checkOut);
    }

    public void addReservation(Map<String, Reservation> reservations, Reservation reservation) {
        reservations.put(reservation.getReservationID(), reservation);

        // ask DataBaseReader to add a new line to Reservation CSV
    }

    public void cancelReservation(Map<String, Reservation> reservations, Reservation reservation) {
        reservations.remove(reservation.getReservationID(), reservation);
        // ask DataBaseReader to delete a line from Reservation CSV
    }

    public Guest createGuest(String name, String email, String phone, String address) {
        return new Guest(name, email, phone, address);
    }

    public void addGuest(Map<String, Guest> guests, Guest guest) {
        guests.put(guest.getId(), guest);
        // ask DataBaseReader to add a new line to src.main.java.Guest CSV
    }

    public void removeGuest(Map<String, Guest> guests, Guest guest) {
        guests.remove(guest.getId(), guest);
        // ask DataBaseReader to delete a line from src.main.java.Guest CSV
    }


    /**
     * Checks if a room is available during a given time frame by searching through reservations
     * @param roomNumber
     * @param reservationMap
     * @param checkIn
     * @param checkOut
     * @return
     */
    public boolean isRoomAvailibleDuringTime(Integer roomNumber, Map<String, Reservation> reservationMap, Date checkIn, Date checkOut){
        Reservation reservationToCheck = null; //1
        for(Reservation reservation: reservationMap.values()){ //2

            //enclosed area green
            if(reservation.getRoomNumber() == roomNumber){ //3

                //enclosed area yellow
                reservationToCheck = reservation; //4
                break;
            }

        }

        if(reservationToCheck != null){ //5

            //enclosed area blue
            if(reservationToCheck.doReservationsOverlap(checkIn,checkOut)){ //6
                return false; //7
            }

        }

        //enclosed area purple
        return true; //8
    }

    private void sendConfirmation() {
    }
}
