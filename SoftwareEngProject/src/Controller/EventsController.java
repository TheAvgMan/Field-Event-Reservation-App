package Controller;

import Controller.itemsDesigns.EventController;
import DataFetchersPosters.EventsDFP;
import Model.Event;
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

public class EventsController {
    private Stage stage;
    private Parent root;
    private FXMLLoader fxmlLoader;
    private EventController eventController;

    private EventsDFP eventsDFP = new EventsDFP();
    private List<Event> events = new ArrayList<>();

    @FXML
    private VBox vBox;



    public void initialize() {
        eventsDFP.openConnection();
        this.events.addAll(eventsDFP.queryAllEvents());
        eventsDFP.closeConnection();

        try {

            for (int i = 0; i < this.events.size(); i++) {
                fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/itemsDesigns/Event.fxml"));
                vBox.getChildren().add(fxmlLoader.load());
                eventController = fxmlLoader.getController();
                eventController.setEvent(this.events.get(i));

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
    public void goToBookings(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Bookings.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Bookings");
        stage.show();
    }
}
