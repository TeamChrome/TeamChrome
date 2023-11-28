package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class RoomCheckoutController implements Initializable {


    private Room selectedRoom;

    private Date selectedCheckInDate;

    private Date selectedCheckOutDate;

    private Hotel hotel;
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


    }

    public void goBackToRoomSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomSearchTable.fxml"));
        Stage stage = (Stage) roomTextArea.getScene().getWindow();
        stage.setScene(loader.load());
        stage.show();



    }

    public void loadData(Room selectedRoom, Date checkIn, Date checkOut, Hotel hotel){
        this.selectedRoom = selectedRoom;
        this.hotel = hotel;
        this.selectedCheckInDate = checkIn;
        this.selectedCheckOutDate = checkOut;
    }

    public void updateText(){
        float calculatedCost = 99.9f;
        String text = "Room type: " + this.selectedRoom.roomType.toString() +
                "\nRoom Number:" + this.selectedRoom.roomNumber +
                "\nRoom Level: " + this.selectedRoom.roomLevel +
                "\nCost for Stay: $" + calculatedCost;
        roomTextArea.setText(text);
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
        System.out.println(mostRecentReservation);
        this.hotel.databaseReader.reservations.add(mostRecentReservation);
        this.hotel.databaseReader.writeReservations();

    }





}
