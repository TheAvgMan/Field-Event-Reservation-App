package Controller;

import DataFetchersPosters.HomeDFP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Parent root;

    private HomeDFP homeDFP = new HomeDFP();


    @FXML
    private Label welcomeLabel;
    @FXML
    private Label progressLabel;
    @FXML
    private ProgressIndicator progressIndicator;
    @FXML
    private Button discountButton;

    public void initialize() {
        homeDFP.openConnection();
        homeDFP.modifyPoints();
        homeDFP.queryUser();
        welcomeLabel.setText("Welcome, " + homeDFP.getName());
        progressIndicator.setProgress(Double.parseDouble(homeDFP.getPoints()) / 100.0);
        progressLabel.setText(homeDFP.getPoints() + "/" + "100");

        if (homeDFP.getDiscount().equals("yes")) {
            discountButton.setDisable(false);
        } else {
            discountButton.setDisable(true);
        }

        homeDFP.closeConnection();
    }

    @FXML
    public void activateDiscount() {
        discountButton.setDisable(true);
        homeDFP.openConnection();
        homeDFP.useDiscount();
        homeDFP.closeConnection();
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

    @FXML
    public void goToBookings(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Bookings.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Bookings");
        stage.show();
    }

}
