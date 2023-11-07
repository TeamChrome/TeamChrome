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

public class RoomCheckoutController implements Initializable {


    private Room selectedRoom;
    @FXML
    private TextArea roomTextArea;
    @Override
    public void initialize(URL location, ResourceBundle resources){


    }

    public void goBackToRoomSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomSearchTable.fxml"));
        Stage stage = (Stage) roomTextArea.getScene().getWindow();
        stage.setScene(loader.load());
        stage.show();


    }

    public void loadData(Room selectedRoom){
        this.selectedRoom = selectedRoom;
    }

    public void updateText(){
        float calculatedCost = 99.9f;
        String text = "Room type: " + this.selectedRoom.roomType.toString() +
                "\nRoom Number:" + this.selectedRoom.roomNumber +
                "\nRoom Level: " + this.selectedRoom.roomLevel +
                "\nCost for Stay: $" + calculatedCost;
        roomTextArea.setText(text);
    }





}
