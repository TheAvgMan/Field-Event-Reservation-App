package DataFetchersPosters;

import Model.Event;
import Tables.EventsTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventsDFP extends DFP {
    private String name;
    private String description;
    private String image;
    private int reservations;
    private int maxReservations;
    private int points;


    public List<Event> queryAllEvents() {
        List<Event> events = new ArrayList<>();
        Event event;

        try {
            resultSet = statement.executeQuery(EventsTable.SELECT_ALL_EVENTS);
            while (resultSet.next()){
                event = new Event();
                event.setEventName(resultSet.getString(EventsTable.COLUMN_NAME));
                event.setEventDescription(resultSet.getString(EventsTable.COLUMN_DESCRIPTION));
                event.setImageSrc(resultSet.getString(EventsTable.COLUMN_IMAGE));
                event.setEventReservations(resultSet.getInt(EventsTable.COLUMN_RESERVATIONS));
                event.setMaxReservations(resultSet.getInt(EventsTable.COLUMN_MAX_RESERVATIONS));
                events.add(event);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return events;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getReservations() {
        return reservations;
    }

    public int getMaxReservations() {
        return maxReservations;
    }

    public int getPoints() {
        return points;
    }
}
