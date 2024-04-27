package Controller;

import Controller.itemsDesigns.ReservationController;
import DataFetchersPosters.EventsReservationsDFP;
import DataFetchersPosters.FieldsReservationsDFP;
import DataFetchersPosters.LogInDFP;
import Model.EventReservation;
import Model.FieldReservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookingsController {
    private Parent root;
    private Stage stage;
    private FXMLLoader fxmlLoader;
    private ReservationController reservationController;

    private FieldsReservationsDFP fieldsReservationsDFP = new FieldsReservationsDFP();
    private List<FieldReservation> fieldReservations = new ArrayList<>();

    private EventsReservationsDFP eventsReservationsDFP = new EventsReservationsDFP();
    private List<EventReservation> eventReservations = new ArrayList<>();

    @FXML
    private VBox fieldsVbox;
    @FXML
    private VBox eventsVbox;



    public void initialize() {
        fieldsReservationsDFP.openConnection();
        this.fieldReservations.addAll(fieldsReservationsDFP.queryAllFieldsReservations(LogInDFP.getUserID()));
        eventsReservationsDFP.closeConnection();

        eventsReservationsDFP.openConnection();
        this.eventReservations.addAll(eventsReservationsDFP.queryAllEventsReservations(LogInDFP.getUserID()));
        eventsReservationsDFP.closeConnection();

        try {

            for(int i = 0; i < fieldReservations.size(); i++){
                fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/itemsDesigns/Reservation.fxml"));
                fieldsVbox.getChildren().add(fxmlLoader.load());
                reservationController = fxmlLoader.getController();
                reservationController.setReservation(fieldReservations.get(i));
            }

            for(int i = 0; i < eventReservations.size(); i++){
                fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/itemsDesigns/Reservation.fxml"));
                eventsVbox.getChildren().add(fxmlLoader.load());
                reservationController = fxmlLoader.getController();
                reservationController.setReservation(eventReservations.get(i));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    @FXML
    public void goToHome(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Home");
        stage.show();
    }


    @FXML
    public void goToHomeSignedOutScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/HomeSignedOut.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Home");
        stage.show();
    }

    @FXML
    public void goToFields(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Fields.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Fields");
        stage.show();
    }

    @FXML
    public void goToEvents(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Events.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Events");
        stage.show();
    }

}
