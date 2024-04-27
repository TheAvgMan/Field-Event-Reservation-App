package Controller.itemsDesigns;

import Model.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class EventController {
    private Event event;    // everything would work fine without it, but it was added for extra organisation.
//    private EventsReservationsDFP eventsReservationsDFP = new EventsReservationsDFP();

    private Stage stage;
    private Parent root;

    @FXML
    private ImageView imageView;

    @FXML
    private Label title;

    @FXML
    private Label description;

    @FXML
    private Label noOfReservations;

    @FXML
    private Button bookingButton;

//    private String eventIDGenerator() {
//        eventIDCounter++;
//        return "#" + String.valueOf(eventIDCounter);
//    }

    public void setEvent(Event event) {
        this.event = event;
        imageView.setImage(new Image(this.event.getImageSrc()));
        title.setText(this.event.getEventName());
        description.setText(this.event.getEventDescription());
        noOfReservations.setText(this.event.getEventReservations() + "/" + this.event.getMaxReservations() + "  Reservations");
    }

    private void goToBookings(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Bookings.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Bookings");
        stage.show();
    }

    @FXML
    public void bookEvent(ActionEvent e) throws IOException {


        goToBookings(e);
    }
}
