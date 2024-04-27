package Controller;

import DataFetchersPosters.SignUpDFP;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
    private Stage stage;
    private Parent root;

    SignUpDFP signUpDFP = new SignUpDFP();

    @FXML
    private TextField id;
    @FXML
    private TextField confirmID;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField name;

    private void goToLogIn(ActionEvent e) throws IOException {
         root = FXMLLoader.load(getClass().getResource("/View/Login.fxml")); // the student home page
         stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
         stage.setScene(new Scene(root));
         stage.setTitle("Activities | Log In");
         stage.show();
    }

    @FXML
    public void registerUser(ActionEvent e) throws IOException {
        if (!id.getText().trim().isEmpty() && !password.getText().trim().isEmpty() && !name.getText().trim().isEmpty()) {
            if (id.getText().trim().equals(confirmID.getText().trim()) && password.getText().trim().equals(confirmPassword.getText().trim())) {
                signUpDFP.openConnection();
                signUpDFP.createTable();
                signUpDFP.postUser(id.getText().trim(), password.getText().trim(), "no", name.getText().trim(), "0", "no");
                signUpDFP.closeConnection();
                goToLogIn(e);
            }
        }
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
    public void goBack(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/View/Signin.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Activities | Sign In");
        stage.show();
    }
}
