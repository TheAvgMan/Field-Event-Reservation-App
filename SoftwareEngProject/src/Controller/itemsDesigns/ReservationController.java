package Controller.itemsDesigns;

import Model.EventReservation;
import Model.FieldReservation;
import Model.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReservationController {
    private Reservation reservation;

    @FXML
    private Label fieldName;
    @FXML
    private Label dayAndTime;
    @FXML
    private Label orderNo;
    @FXML
    private Label moneyAmount;
    @FXML
    private Label pointsPerReservation;


    public void setReservation(FieldReservation fieldReservation) {
        this.reservation = fieldReservation;
        fieldName.setText(((FieldReservation)this.reservation).getFieldName());
        dayAndTime.setText("Next " + this.reservation.getReservationDate() + " From " + this.reservation.getReservationTime());
        orderNo.setText(this.reservation.getReservationID());
        moneyAmount.setText("EGP " + this.reservation.getMoneyAmount());
        pointsPerReservation.setText(this.reservation.getPointsPerReservation() + " Points");
    }

    public void setReservation(EventReservation eventReservation) {
        this.reservation = eventReservation;
        fieldName.setText(((EventReservation)this.reservation).getEventName());
        dayAndTime.setText("Next " + this.reservation.getReservationDate() + " From " + this.reservation.getReservationTime());
        orderNo.setText(this.reservation.getReservationID());
        moneyAmount.setText("EGP " + this.reservation.getMoneyAmount());
        pointsPerReservation.setText(this.reservation.getPointsPerReservation() + " Points");
    }
}
