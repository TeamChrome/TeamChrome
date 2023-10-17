package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class ReservationTest {
    @Test
    public void emptyConstructor(){
        Reservation reservation = new Reservation();
        Assert.assertEquals(reservation.getReservationID(),"");
        Assert.assertNull(reservation.getCheckIn());
        Assert.assertNull(reservation.getCheckOut());
        Assert.assertEquals(reservation.getGuestID(),"");
        Assert.assertEquals(reservation.getRoomNumber(),0);
    }

    @Test
    public void paramConstructor(){
        String guestID = UUID.randomUUID().toString();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        Date checkIn = null;
        Date checkOut = null;
        int roomNumber = 123;

        try {
            checkIn = ft.parse("2023.08.17");
            checkOut = ft.parse("2023.08.19");
        } catch (ParseException e){
            System.err.println("Parsing error in paramConstructor!");
            Assert.fail();
        }

        Reservation reservation = new Reservation(guestID,roomNumber,checkIn,checkOut);
        Assert.assertEquals(reservation.getRoomNumber(),roomNumber);
        Assert.assertEquals(reservation.getCheckIn(),checkIn);
        Assert.assertEquals(reservation.getCheckOut(),checkOut);
        Assert.assertEquals(reservation.getGuestID(),guestID);
    }

    @Test
    public void isWithinStay(){
        Date checkIn = null;
        Date checkOut = null;
        Date beforeCheckIn = null;
        Date afterCheckOut = null;
        Date betweenCheckInOut = null;
        int roomNumber = 123;
        String guestID = UUID.randomUUID().toString();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
        try {
            checkIn = ft.parse("2023.08.17");
            checkOut = ft.parse("2023.08.19");
            beforeCheckIn = ft.parse("2023.08.10");
            afterCheckOut = ft.parse("2023.08.20");
            betweenCheckInOut = ft.parse("2023.08.18");
        } catch (ParseException e){
            System.err.println("Parsing error in isWithinStay!");
            Assert.fail();
        }
        Reservation reservation = new Reservation(guestID,roomNumber,checkIn,checkOut);

        Assert.assertFalse(reservation.isWithinStay(beforeCheckIn));
        Assert.assertFalse(reservation.isWithinStay(afterCheckOut));
        Assert.assertTrue(reservation.isWithinStay(betweenCheckInOut));
        Assert.assertTrue(reservation.isWithinStay(checkIn));
        Assert.assertTrue(reservation.isWithinStay(checkOut));

    }
}