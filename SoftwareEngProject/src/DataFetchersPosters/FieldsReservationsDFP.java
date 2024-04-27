package DataFetchersPosters;

import Model.FieldReservation;
import Tables.FieldsReservationsTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FieldsReservationsDFP extends DFP{
    private String reservationID;
    private String reservationDate;
    private String reservationTime;
//    private String moneyAmount;
//    private String pointsPerReservation;
    private String fieldName;
//    private String fieldID;
    private static long orderNumber = 9999999;

    public List<FieldReservation> queryAllFieldsReservations(String ID) {
        List<FieldReservation> fieldReservations = new ArrayList<>();
        FieldReservation fieldReservation;

        try {
            resultSet = statement.executeQuery(FieldsReservationsTable.SELECT_FIELDS_RESERVATIONS + "'" + ID + "'");
            while (resultSet.next()){
                fieldReservation = new FieldReservation();
                fieldReservation.setFieldName(resultSet.getString(FieldsReservationsTable.COLUMN_FIELD_NAME));
                fieldReservation.setReservationID(resultSet.getString(FieldsReservationsTable.COLUMN_RESERVATION_ID));
                fieldReservation.setReservationTime(resultSet.getString(FieldsReservationsTable.COLUMN_RESERVATION_TIME));
                fieldReservation.setReservationDate(resultSet.getString(FieldsReservationsTable.COLUMN_RESERVATION_DATE));
                fieldReservations.add(fieldReservation);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return fieldReservations;
    }

    public void createFieldReservation(String orderNumber, String fieldName, String fieldDay, String fieldTime) throws SQLException {
        statement.execute("INSERT INTO " + FieldsReservationsTable.TABLE_NAME + " VALUES (" + "'" + orderNumber + "'" + "," +
                "'" + LogInDFP.getUserID() + "'" + "," + "'" + fieldDay + "'" + "," + "'" + fieldTime + "'" + "," + "'" + fieldName + "'" + ")");
    }

    public String getReservationID() {
        return reservationID;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

//    public String getMoneyAmount() {
//        return moneyAmount;
//    }
//
//    public String getPointsPerReservation() {
//        return pointsPerReservation;
//    }

    public String getFieldName() {
        return fieldName;
    }

//    public String getFieldID() {
//        return fieldID;
//    }

    public static String orderNumber() {
        orderNumber++;
        return "#" + orderNumber;
    }
}
