module SoftwareEngProject {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens ActivitiesApplication;
    opens Controller;
    opens Controller.itemsDesigns;
}