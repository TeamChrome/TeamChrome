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
        Reservation reservationToCheck = null;
        for(Reservation reservation: reservationMap.values()){
            if(reservation.getRoomNumber() == roomNumber){
                reservationToCheck = reservation;
            }
        }

        if(reservationToCheck == null){
            return true;
        }
        if(reservationToCheck.doReservationsOverlap(checkIn,checkOut)){
            return false;
        } else {
            return true;
        }
    }

    private void sendConfirmation() {
    }
}
