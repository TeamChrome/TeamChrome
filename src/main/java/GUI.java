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

    RoomSearchTableController roomSearchTableController;
    public GUI(){
        this.hotel = new Hotel("Hotel SUN");
        this.hotel.getReservationsFromDatabase();
        this.hotel.getRoomsFromDatabase();
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
      /*

        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomSearchTable.fxml"));
        Scene roomSearch = loader.load();
        stage.setScene(roomSearch);
        stage.show();
        */


        //System.out.println("Selected room: " + selectedRoom.toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomSearchTable.fxml"));
//        Scene roomCheckoutscene = new Scene(roomCheckoutParent);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(loader.load());
        this.roomSearchTableController = loader.getController();
        this.roomSearchTableController.loadData(this.hotel);
        stage.show();
        this.roomSearchTableController.drawTable();




//        controller.updateText();

    }

//    public void initAndShow(Hotel hotel){
//        this.roomSearchTableController.loadData(hotel);
//        this.mainStage.show();
//        this.roomSearchTableController.drawTable();
//    }
}