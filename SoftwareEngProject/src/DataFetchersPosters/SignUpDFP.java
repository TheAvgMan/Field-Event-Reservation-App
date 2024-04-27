package DataFetchersPosters;

import Tables.UsersTable;

import java.sql.SQLException;

public class SignUpDFP extends DFP {

    public void createTable() {
        try {
            statement.execute(UsersTable.CREATE_TABLE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void postUser(String id, String password, String admin, String name, String points, String discount) {
        try {
            statement.execute(UsersTable.INSERT_USER + "'" + id + "'" + ", " + "'" + password + "'" + ", " + "'" + admin + "'" + ", " +
                    "'" + name + "'" + ", " + "'" + points + "'" + ", " + "'" + discount + "'" + ")");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
