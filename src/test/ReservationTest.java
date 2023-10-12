package src.test;

import org.junit.Test;
import src.main.java.Reservation;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    @Test
    public void paramContrusctor(){
        Reservation reservation = new Reservation();
        assert(reservation.getReservationTime() == Period.ZERO);
    }
}