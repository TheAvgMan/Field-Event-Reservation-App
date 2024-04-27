package Tables;

public class EventsTable {
    public static final String TABLE_NAME = "Events";
    public static final String COLUMN_NAME = "name";    //event name
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_IMAGE = "image";  // image url
    public static final String COLUMN_RESERVATIONS = "reservations";
    public static final String COLUMN_MAX_RESERVATIONS = "max_reservations";
    public static final String COLUMN_POINTS = "points"; // points provided for booking this event


    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            " (" + COLUMN_NAME + " TEXT PRIMARY KEY" + ", " +
            COLUMN_DESCRIPTION + " TEXT" + ", " + COLUMN_IMAGE + " TEXT" + ", " + COLUMN_RESERVATIONS + " INTEGER" + ", " +
            COLUMN_MAX_RESERVATIONS + " INTEGER" + ", " + COLUMN_POINTS + " INTEGER" + ")";

    public static final String SELECT_ALL_EVENTS = "SELECT * FROM " + TABLE_NAME;

    public static final String SELECT_EVENT = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + "="; // Append value

    public static final String INSERT_EVENT = "INSERT INTO " + TABLE_NAME + " VALUES " + "("; // Append value
}
