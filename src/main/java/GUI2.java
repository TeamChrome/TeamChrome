package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Parent root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("BookRoom.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("reserveRoom.fxml"));
        primaryStage.setTitle("Welcome to Hotel Sun");
        primaryStage.setScene(new Scene(root,600, 300 ));
        primaryStage.show();

    }
}
