import java.util.ArrayList;
public class Scheduler {

    // empty constructor
    Scheduler() {}


    // parameterized constructor
    Scheduler(ArrayList<Room> rooms) {
        ArrayList<Room> roomsBooked = new ArrayList<Room>();
    }

    //
    private void checkRoomAvailability() {
    }



    //books requested room for Guest and updates roomsBooked ArrayList
    public void bookRoom(Room r, string[] ginfo) {
        // create new Guest g from User-given input.
        Guest g = createGuest(ginfo);

        // update Room r ownership for new Guest g.
        // update Room r booked status for Hotel Room list / hashmap.
        updateRoomStatus(Room r);

        // send email to Guest g's email after booking their room.
        //
        sendConfirmation();
    }

    public Guest createGuest(string[] ginfo) {
        string firstName = ginfo[0];
        string lastName = ginfo[1];
        string phone = ginfo[2];
        string email = ginfo[3];
        string address = ginfo[4];

        Guest g = new Guest(firstName, lastName, phone, email, address);
        return g;
    }

    public void addGuest(Guest g) {
        // after creating a new Guest g staying at the hotel, update the Guest list held by Hotel.
        return;
    }

    public void removeGuest(Guest g) {
        // after a Guest g is no longer staying at the hotel, update the Guest list held by Hotel.
        return;
    }

    public void updateRoomStatus(Room r) {
        return;
    }

    //sends email confirmation to Guest
    private void sendConfirmation() {
    }

    //cancels requested booked room for Guest and updates roomsBooked ArrayList
    public void cancelRoom() {

    }

}
