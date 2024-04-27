package Tables;

public class UsersTable {
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_ADMIN = "admin";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_POINTS = "points";
    public static final String COLUMN_DISCOUNT = "discount";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            " (" + COLUMN_ID + " TEXT PRIMARY KEY" + ", " +
            COLUMN_PASSWORD + " TEXT" + ", " + COLUMN_ADMIN + " TEXT" + ", " + COLUMN_NAME + " TEXT" + ", " +
            COLUMN_POINTS + " TEXT" + ", " + COLUMN_DISCOUNT + " TEXT" + ")";

    public static final String SELECT_USER = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "="; // Append value

    public static final String INSERT_USER = "INSERT INTO " + TABLE_NAME + " VALUES " + "("; // Append value

}
