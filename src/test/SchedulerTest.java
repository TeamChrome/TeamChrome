package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.main.java.Reservation;
import src.main.java.Scheduler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SchedulerTest {

    @Test
    public void isRoomAvailableDuringTimeGreen() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scheduler scheduler = new Scheduler();
        Map<String, Reservation> reservationMap = new HashMap<>();
        Date checkIn = dateFormat.parse("2023-11-03");
        Date checkOut = dateFormat.parse("2023-11-05");
        reservationMap.put("green",new Reservation("greenGuest",101,checkIn,checkOut));
        boolean isAvail = scheduler.isRoomAvailibleDuringTime(102,reservationMap,checkIn,checkOut);
        Assert.assertTrue(isAvail);
    }


    @Test
    public void isRoomAvailableDuringTimeYellow() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scheduler scheduler = new Scheduler();
        Map<String, Reservation> reservationMap = new HashMap<>();
        Date checkIn = dateFormat.parse("2023-11-03");
        Date checkOut = dateFormat.parse("2023-11-05");
        reservationMap.put("yellow",new Reservation("yellowGuest",102,checkIn,checkOut));
        boolean isAvail = scheduler.isRoomAvailibleDuringTime(102,reservationMap,checkIn,checkOut);
        Assert.assertFalse(isAvail);
    }

    //Blue and yellow have identical test cases because blue follows yellow in the flow of logic
    //
    @Test
    public void isRoomAvailableDuringTimeBlue() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scheduler scheduler = new Scheduler();
        Map<String, Reservation> reservationMap = new HashMap<>();
        Date checkIn = dateFormat.parse("2023-11-03");
        Date checkOut = dateFormat.parse("2023-11-05");
        reservationMap.put("blue",new Reservation("blueGuest",102,checkIn,checkOut));
        boolean isAvail = scheduler.isRoomAvailibleDuringTime(102,reservationMap,checkIn,checkOut);
        Assert.assertFalse(isAvail);
    }

    @Test
    public void isRoomAvailableDuringTimePurple() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scheduler scheduler = new Scheduler();
        Map<String, Reservation> reservationMap = new HashMap<>();
        Date checkIn = dateFormat.parse("2023-11-03");
        Date checkOut = dateFormat.parse("2023-11-05");
        boolean isAvail = scheduler.isRoomAvailibleDuringTime(102,reservationMap,checkIn,checkOut);
        Assert.assertTrue(isAvail);
    }


}
