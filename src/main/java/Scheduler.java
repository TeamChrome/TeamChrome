package src.main.java;
import java.util.*;

public class Scheduler {


    Scheduler() {

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
        // ask DataBaseReader to add a new line to Guest CSV
    }

    public void removeGuest(Map<String, Guest> guests, Guest guest) {
        guests.remove(guest.getId(), guest);
        // ask DataBaseReader to delete a line from Guest CSV
    }

    private void sendConfirmation() {
    }
}
