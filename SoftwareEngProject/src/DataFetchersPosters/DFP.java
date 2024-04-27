package DataFetchersPosters;

import java.sql.*;

public class DFP {
    private final String DB = "ActivitiesAppDB.db";
    private final String CONNECTION_STRING = "jdbc:sqlite:E:/Software Engineering Project/SoftwareEngProject/src/" + DB;

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            statement = connection.createStatement();
        } catch (SQLException e) {
            // dialog to show connection error to database
        }
    }


    public void closeConnection() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // dialog to show closing connection to database error
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // dialog to show closing connection to database error
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // dialog to show closing connection to database error
            }
        }
    }
}
