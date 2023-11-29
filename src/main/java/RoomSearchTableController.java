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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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

    @FXML
    private RadioButton doubleButton;

    @FXML
    private DatePicker checkInDatePicker;

    @FXML
    private DatePicker checkOutDatePicker;
    private Room selectedRoom;

    private Hotel hotel;
    ObservableList<RoomSearchModel> roomSearchModelObservableList = FXCollections.observableArrayList();

    /**
     * This method changes the scene to a different one
     */

    public void goToCheckoutPage(ActionEvent event) throws IOException {
        if(selectedRoom == null){
            return;
            //later we can have an error message appear here
        }
        System.out.println("Selected room: " + selectedRoom.toString());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoomCheckout.fxml"));
//        Scene roomCheckoutscene = new Scene(roomCheckoutParent);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage stage = (Stage) suiteButton.getScene().getWindow();
        stage.setScene(loader.load());
        RoomCheckoutController controller = loader.getController();
        LocalDate checkInLocalDate = this.checkInDatePicker.getValue();
        Instant checkInInstant = Instant.from(checkInLocalDate.atStartOfDay(ZoneId.systemDefault()));
        Date checkInDate = Date.from(checkInInstant);

        LocalDate checkOutLocalDate = this.checkOutDatePicker.getValue();
        Instant checkOutInstant = Instant.from(checkOutLocalDate.atStartOfDay(ZoneId.systemDefault()));
        Date checkOutDate = Date.from(checkOutInstant);
        controller.loadData(selectedRoom,checkInDate,checkOutDate,hotel);
        controller.updateText();
        //stage.show();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources){




    }

    public void loadData(Hotel hotel){
        this.hotel = hotel;
    }

    /**
     * drawTable updates the data within the TableView
     * This is a separate function to ensure the table is drawn, and then updated
     *
     */
    public void drawTable(){
        if(this.hotel == null){
            System.out.println("Hotel is null");
        } else {
            System.out.println("Hotel is not null");
        }
        for(Integer roomNumber: this.hotel.roomList.keySet()){
            Room room = this.hotel.roomList.get(roomNumber);
            if(!room.isCheckedIn()){
                roomSearchModelObservableList.add(new RoomSearchModel(room.roomType.toString(),room.roomCost,roomNumber,room.roomLevel));
            }
        }
        roomTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        roomCostTableColumn.setCellValueFactory(new PropertyValueFactory<>("costPerNight"));
        roomNumberTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomLevelTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomLevel"));
        roomSearchTable.setItems(roomSearchModelObservableList);
        checkInDatePicker.setValue(LocalDate.now());
        checkOutDatePicker.setValue(LocalDate.now());
        FilteredList<RoomSearchModel> filteredData = new FilteredList<>(roomSearchModelObservableList, b -> true);
        addListeners(filteredData);
        SortedList<RoomSearchModel> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(roomSearchTable.comparatorProperty());

        roomSearchTable.setItems(sortedData);
    }

    /**
     * This function adds all the listeners to the buttons to allow us to filter the data
     *
     * @param filteredList
     */
    private void addListeners(FilteredList<RoomSearchModel> filteredList) {
        kingButton.selectedProperty().addListener((ov, oldValue, newValue) -> {
            this.filterRoomOnType(filteredList);
        });

        suiteButton.selectedProperty().addListener((ov, oldValue, newValue) -> {
            this.filterRoomOnType(filteredList);
        });

        doubleButton.selectedProperty().addListener((ov, oldValue, newValue) -> {
            this.filterRoomOnType(filteredList);
        });


        roomSearchTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                TableView.TableViewSelectionModel<RoomSearchModel> selectionModel = roomSearchTable.getSelectionModel();
                int index = selectionModel.getSelectedIndex();
                RoomSearchModel roomModel = roomSearchTable.getItems().get(index);
                selectedRoom = roomModel.toRoom();
            }
        });

        checkInDatePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            this.filterRoomsOnDate(filteredList);

            System.out.println("Check in updated");
        });


        checkOutDatePicker.valueProperty().addListener((ov, oldValue, newValue) -> {
            this.filterRoomsOnDate(filteredList);
            System.out.println("Check out updated");
        });


    }

    private void filterRoomOnType(FilteredList<RoomSearchModel> filteredList) {
        boolean suiteEnabled = suiteButton.selectedProperty().getValue();
        boolean kingEnabled = kingButton.selectedProperty().getValue();
        boolean doubleEnabled = doubleButton.selectedProperty().getValue();

        ArrayList<String> roomsToFilter = new ArrayList<String>();
        if(suiteEnabled){
            roomsToFilter.add("SUITE");
        }

        if(kingEnabled){
            roomsToFilter.add("KING");
        }

        if(doubleEnabled){
            roomsToFilter.add("DOUBLE");
        }


        filteredList.setPredicate(s -> roomsToFilter.contains(s.roomType));


    }


    /**
     * @param filteredList
     */
    private void filterRoomsOnDate(FilteredList<RoomSearchModel> filteredList){
//        Date checkInDate = this.checkInDatePicker.
        LocalDate checkInLocalDate = this.checkInDatePicker.getValue();
        Instant checkInInstant = Instant.from(checkInLocalDate.atStartOfDay(ZoneId.systemDefault()));
        Date checkInDate = Date.from(checkInInstant);

        LocalDate checkOutLocalDate = this.checkOutDatePicker.getValue();
        Instant checkOutInstant = Instant.from(checkOutLocalDate.atStartOfDay(ZoneId.systemDefault()));
        Date checkOutDate = Date.from(checkOutInstant);

        int roomNumberToRemove = -1;
        for(Reservation reservation: this.hotel.reservations.values()){
            if(reservation.doReservationsOverlap(checkInDate,checkOutDate)){
                roomNumberToRemove = reservation.getRoomNumber();

            }
        }

        final int roomNumberToRemoveFinal = roomNumberToRemove;
        if(roomNumberToRemove != -1){
            filteredList.setPredicate(s -> !s.roomNumber.equals(roomNumberToRemoveFinal));
        } else {
            filteredList.setPredicate(s -> true);
        }

    }





    //private Date


}
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