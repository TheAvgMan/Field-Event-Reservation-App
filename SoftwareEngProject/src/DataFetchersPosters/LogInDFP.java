package DataFetchersPosters;

import Tables.UsersTable;

import java.sql.SQLException;

public class LogInDFP extends DFP {
    private static String id;
    private String password;
    private String admin;


    public void queryUser(String IDValue) {
        id = IDValue;
        try {
            resultSet = statement.executeQuery(UsersTable.SELECT_USER + "'" + id + "'");
            if (resultSet.next()){
                this.password = resultSet.getString(UsersTable.COLUMN_PASSWORD);
                this.admin = resultSet.getString(UsersTable.COLUMN_ADMIN);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getUserID() {
        return id;
    }

    public String getUserPassword() {
        return this.password;
    }

    public String isAdmin() {
        return this.admin;
    }

}
