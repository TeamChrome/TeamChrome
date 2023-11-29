package src.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUI extends Application {
    Hotel hotel;
    Stage mainStage;

    FrontPageController frontPageController;
//    RoomSearchTableController roomSearchTableController;
    public GUI(){
        this.hotel = new Hotel("Hotel SUN");
        this.hotel.getReservationsFromDatabase();
        this.hotel.getRoomsFromDatabase();
        System.out.println("Current reservations: " + this.hotel.reservations);
    }

    public GUI(Hotel hotel){
        this.hotel = hotel;

    }


    //public static void main(String[] args) {
      //  launch(args);
   // }

    public void run(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
        stage.setScene(loader.load());
        this.frontPageController = loader.getController();
        this.frontPageController.loadData(this.hotel);
        stage.show();

    }
}