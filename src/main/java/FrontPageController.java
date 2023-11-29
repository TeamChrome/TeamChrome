package src.main.java;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class FrontPageController implements Initializable {

    @FXML
    private Button BookRoomButton;

    @FXML
    private Button ModifyRes;

    @FXML
    private Button ViewAmenities;

    @FXML
    private Button ViewRes;

    private Hotel hotel;

    @FXML
    public void BookRoom() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomSearchTable.fxml"));
        Stage stage = (Stage) this.ViewRes.getScene().getWindow();
        stage.setScene(loader.load());
        RoomSearchTableController controller = loader.getController();
        controller.loadData(this.hotel);
        stage.show();
        controller.drawTable();
    }


    @FXML
    void ModifyRes(ActionEvent event) {

    }

    @FXML
    void ViewAmenities(ActionEvent event) {

    }

    @FXML
    void ViewRes(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loadData(Hotel hotel){
        this.hotel = hotel;
    }
}
