package Model;

public class FieldReservation extends Reservation{
    private String fieldName;
    private String fieldID;


    public String getMoneyAmount() {
        if (this.fieldID.equals("1")) {
            this.moneyAmount = "100.0"; // Big Football Field
        } else if (this.fieldID.equals("2")) {
            this.moneyAmount = "75.0"; // Small Football Field
        } else if (this.fieldID.equals("3")) {
            this.moneyAmount = "50.0"; // Basketball/Volleyball Field
        }
        return this.moneyAmount;
    }


    public String getPointsPerReservation() {
        if (this.fieldID.equals("1")) {
            this.pointsPerReservation = "20"; // Big Football Field
        } else if (this.fieldID.equals("2")) {
            this.pointsPerReservation = "10"; // Small Football Field
        } else if (this.fieldID.equals("3")) {
            this.pointsPerReservation = "5"; // Basketball/Volleyball Field
        }
        return this.pointsPerReservation;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;

        if (this.fieldName.equals("Big Football Field")) {
            this.fieldID = "1";
        } else if (this.fieldName.equals("Small Football Field")) {
            this.fieldID = "2";
        } else if (this.fieldName.equals("Basketball/Volleyball Field")) {
            this.fieldID = "3";
        }
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
