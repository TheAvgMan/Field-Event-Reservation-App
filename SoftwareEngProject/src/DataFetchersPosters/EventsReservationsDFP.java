package DataFetchersPosters;

import Model.EventReservation;
import Tables.EventsReservationsTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventsReservationsDFP extends DFP {
    private String reservationID;
    private String reservationDate;
    private String reservationTime;
    private String moneyAmount;
    private String pointsPerReservation;
    private String eventName;
    private static long orderNumber = 9999999;

    public List<EventReservation> queryAllEventsReservations(String ID) {
        List<EventReservation> eventsReservations = new ArrayList<>();
        EventReservation eventReservation;

        try {
            resultSet = statement.executeQuery(EventsReservationsTable.SELECT_EVENTS_RESERVATIONS + "'" + ID + "'");
            while (resultSet.next()){
                    eventReservation = new EventReservation();
                    eventReservation.setReservationID(resultSet.getString(EventsReservationsTable.COLUMN_RESERVATION_ID));
                    eventReservation.setReservationTime(resultSet.getString(EventsReservationsTable.COLUMN_RESERVATION_TIME));
                    eventReservation.setReservationDate(resultSet.getString(EventsReservationsTable.COLUMN_RESERVATION_DATE));
                    eventReservation.setEventName(resultSet.getString(EventsReservationsTable.COLUMN_EVENT_NAME));
                    eventReservation.setMoneyAmount(resultSet.getString(EventsReservationsTable.COLUMN_MONEY_AMOUNT));
                    eventReservation.setPointsPerReservation(resultSet.getString(EventsReservationsTable.COLUMN_POINTS_PER_RESERVATION));
                    eventsReservations.add(eventReservation);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return eventsReservations;
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

    public String getMoneyAmount() {
        return moneyAmount;
    }

    public String getPointsPerReservation() {
        return pointsPerReservation;
    }

    public String getEventName() {
        return eventName;
    }

    public static String orderNumber() {
        orderNumber++;
        return "#" + orderNumber;
    }
}
