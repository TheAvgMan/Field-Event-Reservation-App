package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SigninController {
    private Stage stage;
    private Parent root;

    @FXML
    public void goToHomeSignedOutScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/HomeSignedOut.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Home");
        stage.show();
    }

    @FXML
    public void goToLogInScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Log In");
        stage.show();
    }

    @FXML
    public void goToSignupScene(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Signup.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Sign Up");
        stage.show();
    }

}
