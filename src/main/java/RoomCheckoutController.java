package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class RoomCheckoutController implements Initializable {


    private Room selectedRoom;

    private Date selectedCheckInDate;

    private Date selectedCheckOutDate;

    private Reservation bookedReservation;
    private Hotel hotel;

    private MailMan mailman;
    @FXML
    private TextArea roomTextArea;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNoTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField zipcodeTextField;






    @Override
    public void initialize(URL location, ResourceBundle resources){
        this.mailman = new MailMan();

    }


    public void goToReservationDetails() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReservationDetails.fxml"));

        Stage stage = (Stage) roomTextArea.getScene().getWindow();
        stage.setScene(loader.load());
        ReservationDetailsController controller = loader.getController();
        controller.loadData(this.hotel,this.bookedReservation);
        stage.show();
        controller.updateRoomInfoText();
        controller.updateCustomerInfoText();
    }

    public void goBackToRoomSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomSearchTable.fxml"));
        Stage stage = (Stage) roomTextArea.getScene().getWindow();
        stage.setScene(loader.load());
        RoomSearchTableController controller = loader.getController();
        controller.loadData(this.hotel);
        stage.show();
        controller.drawTable();



    }

    public void loadData(Room selectedRoom, Date checkIn, Date checkOut, Hotel hotel){
        this.selectedRoom = selectedRoom;
        this.hotel = hotel;
        this.selectedCheckInDate = checkIn;
        this.selectedCheckOutDate = checkOut;
    }

    public void updateText(){
        long daysStaying = getDays();
        float calculatedCost = this.selectedRoom.roomCost * daysStaying;
        String text = "Room type: " + this.selectedRoom.roomType.toString() +
                "\nRoom Number: " + this.selectedRoom.roomNumber +
                "\nRoom Level: " + this.selectedRoom.roomLevel +
                "\nDays Staying: " + daysStaying +
                "\nCost for Stay: $" + calculatedCost;
        roomTextArea.setText(text);
    }

    public long getDays(){
        long diffInMillis = Math.abs(this.selectedCheckOutDate.getTime() - this.selectedCheckInDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS) + 1;
    }


    public void reserveRoom(){
        //https://stackoverflow.com/questions/35973037/disable-button-in-java-until-all-fields-filled
        String guestFirstName = this.firstNameTextField.getText();
        String guestLastName = this.lastNameTextField.getText();
        String guestEmail = this.emailTextField.getText();
        String guestPhone = this.phoneNoTextField.getText();
        String guestAddress = this.addressTextField.getText();
        String guestCity = this.cityTextField.getText();
        String guestState = this.stateTextField.getText();
        String guestZipcode = this.zipcodeTextField.getText();

        String guestFullname = guestFirstName + " " + guestLastName;
        System.out.println("Guest full name: " + guestFullname);
        Guest newGuest = this.hotel.scheduler.createGuest(guestFullname,guestEmail,guestPhone,guestAddress);
        int roomNumber = this.selectedRoom.roomNumber;
        this.hotel.addNewGuest(newGuest);
        String reservationId = this.hotel.reserveRoomForGuest(newGuest,roomNumber,this.selectedCheckInDate,this.selectedCheckOutDate);
        Reservation mostRecentReservation = this.hotel.reservations.get(reservationId);
        this.bookedReservation = mostRecentReservation;
        System.out.println(mostRecentReservation);
        this.hotel.databaseReader.reservations.add(mostRecentReservation);
        this.hotel.databaseReader.writeReservations();
        this.mailman.sendEmail(1,newGuest,mostRecentReservation);

        try {
            this.goToReservationDetails();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }





}
