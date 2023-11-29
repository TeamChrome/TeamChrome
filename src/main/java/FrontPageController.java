package main.java;

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

    @FXML
    public void BookRoom() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BookRoom.fxml"));
        Stage window = (Stage) BookRoomButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 300));
    }


    @FXML
    void ModifyRes(ActionEvent event) {

    }

    @FXML
    void ViewAmenities(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("amenities.fxml"));
        Stage window = (Stage) ViewAmenities.getScene().getWindow();
        window.setScene(new Scene(root, 600, 300));
    }

    @FXML
    void ViewRes(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
