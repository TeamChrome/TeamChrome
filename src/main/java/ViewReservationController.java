package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewReservationController implements Initializable {
    @FXML
    private TextField reservationID;

    @FXML
    private Button viewReservation;

    @FXML
    private TextArea roomInfoTextArea;

    @FXML
    private TextArea customerInfoTextArea;

    private Reservation reservation;
    private Guest guest;

    private Hotel hotel;





    @Override
    public void initialize(URL location, ResourceBundle resources){


    }

    public void loadData(Hotel hotel){
        this.hotel = hotel;

    }

    public void lookupReservation(){
        String reservationID = this.reservationID.getText();
        Reservation foundReservation = this.hotel.reservations.get(reservationID);
        /*
        for(String reservationIDLoop: this.hotel.reservations.keySet()){ //2
            System.out.println("Comparison between: [" + reservationIDLoop + "] and [" + reservationID + "]");
            if(reservationID.compareTo(reservationIDLoop) == 0){
                System.out.println("Strings are equal");
            } else {
                System.out.println("Strings are not equal");
            }
            //enclosed area green


        }
        */

        if(foundReservation == null){
            //do something
            System.out.println("reservation of id [" + reservationID + "] was not found");
            return;
        } else {
            System.out.println("Found reservation " + foundReservation.toString());
        }
        this.reservation = foundReservation;
        this.updateAllInfoText();
    }


    public void updateAllInfoText(){
        //updateCustomerInfoText();
        updateRoomInfoText();
    }

    public void updateRoomInfoText(){
        Integer roomNumber = this.reservation.getRoomNumber();
        Room roomBooked = this.hotel.roomList.get(roomNumber);
        this.roomInfoTextArea.setText(roomBooked.getPrettyStringRoom());
    }

    public void updateCustomerInfoText(){
        Reservation reservation = this.reservation;
        String guestID = reservation.getGuestID();
        Guest guest = this.hotel.guests.get(guestID);
        this.customerInfoTextArea.setText(guest.getPrettyString());


    }

    public void exitToMainMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
        Stage stage = (Stage) roomInfoTextArea.getScene().getWindow();
        stage.setScene(loader.load());
        FrontPageController controller = loader.getController();
        controller.loadData(this.hotel);
        stage.show();




    }
}
