package src;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Scheduler {

    ArrayList<Reservation> reservationList;

    Scheduler() {
        this.reservationList = new ArrayList<>();
    }


    public boolean checkRoomAvailability(Room room) {
        return room.isCheckedIn();
    }

    public Reservation AcceptUserInput(String name, String email, String phone, String address, Room room, Date checkIn, Date checkOut) {
        // create new Guest & add new Guest to Hotel's list of Guests.
        Guest newGuest = createGuest(name, email, phone, address);
        // create new Reservation & add new Reservation to Scheduler's list of Reservations.
        Reservation newReservation = createReservation(newGuest, room, checkIn, checkOut);
        addReservation(newReservation);
        // send email to new Guest after completing Reservation.
        sendConfirmation();
        // update Room's booked status for the current Room object.
        updateRoomStatus(room, true);
        return newReservation;

    }


    //books requested room for Guest and updates roomsBooked ArrayList
    public Reservation createReservation(Guest g, Room r, Date checkIn, Date checkOut) {
        // create new Reservation from User's input and current Guest ID.
        return new Reservation(g.getID(), r.getRoomNumber(), checkIn, checkOut);
    }

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);

    }

    public Guest createGuest(String name, String email, String phone, String address) {
        return new Guest(name, email, phone, address);
    }

    // this method is assuming only one method in Room.java is used to update CheckIn.
    public void updateRoomStatus(Room room, boolean isOccupied) {
        room.setCheckedIn(isOccupied);
    }

    //sends email confirmation to Guest.
    private void sendConfirmation() {
    }

    //cancels requested booked room for Guest and updates roomMap HashMap.
    public void cancelReservation() {

    }

    public Reservation getReservation(UUID reservationID){
        return reservationList.
    }

}
