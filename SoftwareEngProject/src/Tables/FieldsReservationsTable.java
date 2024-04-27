package Tables;

public class FieldsReservationsTable {
    public static final String TABLE_NAME = "Fields_Reservations";
    public static final String COLUMN_RESERVATION_ID = "_id";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_RESERVATION_DATE = "reservation_date";
    public static final String COLUMN_RESERVATION_TIME = "reservation_time";
//    public static final String COLUMN_MONEY_AMOUNT = "money_amount";
//    public static final String COLUMN_POINTS_PER_RESERVATION = "points_per_reservation";
    public static final String COLUMN_FIELD_NAME = "field_name";
//    public static final String COLUMN_FIELD_ID = "field_id";

//    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
//            " (" + COLUMN_RESERVATION_ID + " TEXT PRIMARY KEY" + ", " +
//            COLUMN_USER_ID + " TEXT" + ", " + COLUMN_RESERVATION_DATE + " TEXT" + ", " + COLUMN_RESERVATION_TIME + " TEXT" + ", " +
//            COLUMN_MONEY_AMOUNT + " TEXT" + ", " + COLUMN_POINTS_PER_RESERVATION + " TEXT" + ", " +
//            COLUMN_FIELD_NAME + " TEXT" + ", " + COLUMN_FIELD_ID + " TEXT" + ")";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            " (" + COLUMN_RESERVATION_ID + " TEXT PRIMARY KEY" + ", " +
            COLUMN_USER_ID + " TEXT" + ", " + COLUMN_RESERVATION_DATE + " TEXT" + ", " + COLUMN_RESERVATION_TIME + " TEXT" + ", " +
            COLUMN_FIELD_NAME + " TEXT" + ")";

    public static final String SELECT_FIELDS_RESERVATIONS = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_USER_ID + "="; // Append value

}
