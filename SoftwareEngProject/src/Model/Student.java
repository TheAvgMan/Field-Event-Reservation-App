package Model;

import java.util.List;

public class Student extends User {

    private List<FieldReservation> fieldsReservations;
    private List<EventReservation> eventsReservations;
    private int points;


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<FieldReservation> getFieldsReservations() {
        return fieldsReservations;
    }

    public void setFieldsReservations(List<FieldReservation> fieldsReservations) {
        this.fieldsReservations = fieldsReservations;
    }

    public List<EventReservation> getEventsReservations() {
        return eventsReservations;
    }

    public void setEventsReservations(List<EventReservation> eventsReservations) {
        this.eventsReservations = eventsReservations;
    }
}
