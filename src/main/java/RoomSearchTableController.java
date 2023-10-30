package main.java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomSearchTableController implements Initializable {

    @FXML
    private TableView<RoomSearchModel> roomSearchTable;

    @FXML
    private TableColumn<RoomSearchModel,String> roomTypeTableColumn;

    @FXML
    private TableColumn<RoomSearchModel, Float> roomCostTableColumn;

    @FXML
    private TableColumn<RoomSearchModel, Integer> roomNumberTableColumn;

    @FXML
    private RadioButton suiteButton;

    @FXML
    private RadioButton kingButton;

    ObservableList<RoomSearchModel> roomSearchModelObservableList = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources){
        //fetch data here

        String[] sampleRoomTypes = {"SUITE","KING","KING","QUEEN"};
        Float[] sampleRoomCosts = {100.0f,200.0f,300.0f,400.0f};
        Integer[] sampleRoomNumbers = {100,101,201,202};
        for(int i = 0; i < sampleRoomNumbers.length; i++){
            roomSearchModelObservableList.add(new RoomSearchModel(sampleRoomTypes[i],sampleRoomCosts[i],sampleRoomNumbers[i]));
        }

        roomTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomCostTableColumn.setCellValueFactory(new PropertyValueFactory<>("costPerNight"));
        roomNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

        roomSearchTable.setItems(roomSearchModelObservableList);

        FilteredList<RoomSearchModel> filteredData = new FilteredList<>(roomSearchModelObservableList, b -> true);
        suiteButton.selectedProperty().addListener(((observableValue, aBoolean, t1) -> {
            filteredData.setPredicate(roomSearchModel -> {

                if(roomSearchModel.getRoomType().equals("SUITE")){
                    return t1;
                }

                return false;
            });
        }));

        kingButton.selectedProperty().addListener(((observableValue, aBoolean, t1) -> {
            filteredData.setPredicate(roomSearchModel -> {

                if(roomSearchModel.getRoomType().equals("KING")){
                    return t1;
                }

                return false;
            });
        }));

        SortedList<RoomSearchModel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(roomSearchTable.comparatorProperty());

        roomSearchTable.setItems(sortedData);
    }



}
