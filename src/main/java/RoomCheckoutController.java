package src.main.java;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomCheckoutController implements Initializable {


    private Room selectedRoom;
    @FXML
    private TextArea roomTextArea;
    @Override
    public void initialize(URL location, ResourceBundle resources){


    }

    public void loadData(Room selectedRoom){
        this.selectedRoom = selectedRoom;
    }

    public void updateText(){
        roomTextArea.setText("Room type: " + this.selectedRoom.roomType.toString() + "\n Room Number:" + this.selectedRoom.roomNumber);
    }





}
