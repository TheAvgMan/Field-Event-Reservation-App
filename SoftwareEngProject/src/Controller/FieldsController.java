package Controller;

import DataFetchersPosters.FieldsReservationsDFP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class FieldsController {
    private Stage stage;
    private Parent root;

    private FieldsReservationsDFP fieldsReservationsDFP = new FieldsReservationsDFP();

    @FXML
    private ComboBox fieldComboBox;
    @FXML
    private ComboBox dayComboBox;
    @FXML
    private ComboBox timeComboBox;

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
    public void goToEvents(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Events.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Events");
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

    @FXML
    public void bookField(ActionEvent e) throws IOException {
        try {
            fieldsReservationsDFP.openConnection();
            fieldsReservationsDFP.createFieldReservation(FieldsReservationsDFP.orderNumber(), fieldComboBox.getValue().toString(),
                    dayComboBox.getValue().toString(),
                    timeComboBox.getValue().toString());
            fieldsReservationsDFP.closeConnection();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        goToBookings(e);
    }


}
