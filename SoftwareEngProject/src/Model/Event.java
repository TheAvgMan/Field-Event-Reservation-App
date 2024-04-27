package Model;

public class Event {
    private String eventName;
    private String eventDescription;
    private String imageSrc;
    private int eventReservations = 0; // will be updated with every reservation.
    private int maxReservations = 0; // the admin will enter the max reservations for each event when posting event

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getEventReservations() {
        return eventReservations;
    }

    public void setEventReservations(int eventReservations) {
        this.eventReservations = eventReservations;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getMaxReservations() {
        return maxReservations;
    }

    public void setMaxReservations(int maxReservations) {
        this.maxReservations = maxReservations;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

}
