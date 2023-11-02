package src.main.java;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
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
    private TableColumn<RoomSearchModel, Integer> roomLevelTableColumn;

    @FXML
    private RadioButton suiteButton;

    @FXML
    private RadioButton kingButton;

    private Room selectedRoom;
    ObservableList<RoomSearchModel> roomSearchModelObservableList = FXCollections.observableArrayList();

    /**
     * This method changes the scene to a different one
     */

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        System.out.println("Selected room: " + selectedRoom.toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomCheckout.fxml"));
//        Scene roomCheckoutscene = new Scene(roomCheckoutParent);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(loader.load());
        RoomCheckoutController controller = loader.getController();
        stage.show();
        controller.loadData(selectedRoom);
        controller.updateText();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){
        //fetch data here

        String[] sampleRoomTypes = {"SUITE","KING","KING","TWIN"};
        Float[] sampleRoomCosts = {100.0f,200.0f,300.0f,400.0f};
        Integer[] sampleRoomNumbers = {100,101,201,202};
        Integer[] sampleRoomFloors = {1,1,2,2,};
        for(int i = 0; i < sampleRoomNumbers.length; i++){
            roomSearchModelObservableList.add(new RoomSearchModel(sampleRoomTypes[i],sampleRoomCosts[i],sampleRoomNumbers[i],sampleRoomFloors[i]));
        }

        roomTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomCostTableColumn.setCellValueFactory(new PropertyValueFactory<>("costPerNight"));
        roomNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomLevel"));
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

        roomSearchTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                TableView.TableViewSelectionModel<RoomSearchModel> selectionModel = roomSearchTable.getSelectionModel();
                int index = selectionModel.getSelectedIndex();
                RoomSearchModel roomModel = roomSearchTable.getItems().get(index);
                selectedRoom = roomModel.toRoom();
//                ObservableList<TablePosition> selectedCells = selectionModel.getSelectedCells();
                //int index = searchResultsTable.getSelectionModel().getSelectedIndex();
                //        Book book = searchResultsTable.getItems().get(index);
//                for(TablePosition pos: selectedCells){
//                    Object val = pos.getTableColumn().getCellData(newValue);
//                    System.out.println("Selected Values " + val);
//                }
                //TablePosition tablePosition = selectedCells.get(0);

            }
        });

        /*
            tableview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        //Check whether item is selected and set value of selected item to Label
        if(tableview.getSelectionModel().getSelectedItem() != null)
        {
           TableViewSelectionModel selectionModel = tableview.getSelectionModel();
           ObservableList selectedCells = selectionModel.getSelectedCells();
           TablePosition tablePosition = (TablePosition) selectedCells.get(0);
           Object val = tablePosition.getTableColumn().getCellData(newValue);
           System.out.println("Selected Value" + val);
         }
         }
     });
         */

        SortedList<RoomSearchModel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(roomSearchTable.comparatorProperty());

        roomSearchTable.setItems(sortedData);
    }



}
