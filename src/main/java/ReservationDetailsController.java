package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReservationDetailsController implements Initializable {

    @FXML
    private TextArea roomInfoTextArea;

    @FXML
    private TextArea customerInfoTextArea;
    private Reservation reservation;

    private Hotel hotel;



    @Override
    public void initialize(URL location, ResourceBundle resources){


    }

    public void loadData(Hotel hotel, Reservation reservation){
        this.reservation = reservation;
        this.hotel = hotel;

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
