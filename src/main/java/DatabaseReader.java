package src.main.java;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DatabaseReader {

    private ArrayList<Room> rooms;

    public ArrayList<Reservation> reservations;

    private static final String COMMA_DELIMITER = ",";


    public DatabaseReader() {
        this.rooms = new ArrayList<Room>();
        this.reservations = new ArrayList<Reservation>();
    }

    public void readRooms(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/data/RoomsInformation.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //we skip the first one because its a header
        for(int room = 0; room < records.size(); room++){
            List<String> currentRecord = records.get(room);
            int roomNumber = Integer.parseInt(currentRecord.get(0));
            int roomLevel = roomNumber/100;
            Room.RoomType roomType = Room.RoomType.valueOf(currentRecord.get(1).toUpperCase(Locale.ROOT));
            float cost = Float.parseFloat((currentRecord.get(2).substring(0,currentRecord.get(2).length()-4)));

            //System.out.println("Room number: " + roomNumber + " Room Type: " + roomType + " Cost: " + cost);
            Room currentRoom = new Room(roomType,roomNumber,roomLevel,false);
            this.rooms.add(currentRoom);

        }
    }

    public void readReservations(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/data/CurrentReservations.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //we skip the first one because its a header
        for(int room = 0; room < records.size(); room++){
            List<String> currentRecord = records.get(room);
            String reservationID = currentRecord.get(0);
            String guestID = currentRecord.get(1);
            int roomNumber = Integer.parseInt(currentRecord.get(2));
            String checkInString = currentRecord.get(3);
            String checkOutString = currentRecord.get(4);
            Date checkIn;
            Date checkOut;
            try {
                checkIn = formatter.parse(checkInString);
                checkOut = formatter.parse(checkOutString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            Reservation currentReservation = new Reservation(guestID,roomNumber,checkIn,checkOut);
            this.reservations.add(currentReservation);
        }
    }


    //This function writes all the current reservations into the csv file, overwriting what is currently there
    public void writeReservations(){
        File currentReservationsFile = new File("src/main/java/data/CurrentReservations.csv");
        currentReservationsFile.delete();
        try {
            currentReservationsFile.createNewFile();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentReservationsFile))) {

            for(Reservation currentReservation: this.reservations){
                bw.write(currentReservation.toCSVFormat());
                bw.write("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
