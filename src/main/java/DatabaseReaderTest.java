package src.main.java;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class DatabaseReaderTest {

    @Test
    void getRooms() {
        DatabaseReader reader = new DatabaseReader();
        reader.readRooms();
        ArrayList<Reservation> reservations = reader.getReservations();
        ArrayList<Room> rooms = reader.getRooms();

        for(Room x: rooms){
            System.out.println(x);
        }
    }

    @Test
    void getReservations() {
    }


    @Test
    void writeReservations() {
        DatabaseReader reader = new DatabaseReader();
        Date checkIn = null;
        Date checkOut = null;
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        try {
            checkIn = ft.parse("2023.08.20");
            checkOut = ft.parse("2023.08.22");
        } catch (ParseException e){
            System.err.println("Parsing error in isWithinStay!");
        }
        Reservation res = new Reservation("example",102,checkIn,checkOut);
        reader.readRooms();
        reader.readReservations();
        System.out.println(reader.reservations.size());
        reader.reservations.add(res);
        reader.writeReservations();
    }
}