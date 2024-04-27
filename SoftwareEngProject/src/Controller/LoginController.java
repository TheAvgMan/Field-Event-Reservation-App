package Controller;

import DataFetchersPosters.LogInDFP;
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

public class LoginController {
    private Stage stage;
    private Parent root;

    private LogInDFP logInDFP = new LogInDFP();

    @FXML
    private TextField id;
    @FXML
    private PasswordField password;



    private void goToHome(ActionEvent e) throws IOException {
        if (logInDFP.isAdmin().equals("no")) {
            root = FXMLLoader.load(getClass().getResource("/View/Home.fxml")); // the student home page
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Activities | Home");
            stage.show();
        } else if (logInDFP.isAdmin().equals("yes")) {
            // the admin home page
        }
    }


    @FXML
    public void verifyPassword(ActionEvent e) throws IOException {
        logInDFP.openConnection();
        if (!id.getText().trim().isEmpty()) {
            logInDFP.queryUser(id.getText().trim());
            if (password.getText().equals(logInDFP.getUserPassword())) {
                logInDFP.closeConnection();
                goToHome(e);
//                return "Verified";
            } else {
//                return "Incorrect Password";
            }
        }
        logInDFP.closeConnection();
//        return "Invalid User";
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
