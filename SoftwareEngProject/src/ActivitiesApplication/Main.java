package ActivitiesApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/HomeSignedOut.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Activities | Home");
        primaryStage.getIcons().add(new Image("file:src/Images/asu-eng%20logo.png"));
        primaryStage.show();
    }

}
