package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.Reservation;

import java.time.Period;



public class ReservationTest {
    @Test
    public void paramContrusctor(){
        Reservation reservation = new Reservation();
        Assert.assertEquals(reservation.getReservationID(),"");
        Assert.assertEquals(reservation.getReservationTime(),Period.ZERO);

    }
}