package Model;

public class Reservation {
    private String reservationID;
    private String reservationDate;
    private String reservationTime;
    String moneyAmount;
    String pointsPerReservation;

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(String moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getPointsPerReservation() {
        return pointsPerReservation;
    }

    public void setPointsPerReservation(String pointsPerReservation) {
        this.pointsPerReservation = pointsPerReservation;
    }
}
