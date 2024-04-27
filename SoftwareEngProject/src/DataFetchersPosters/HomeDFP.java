package DataFetchersPosters;

import Tables.UsersTable;

import java.sql.SQLException;

public class HomeDFP extends DFP {
    private String name;
    private String points;
    private String discount;

    private void queryPointsAndDiscount() {
        try {
            resultSet = statement.executeQuery(UsersTable.SELECT_USER + "'" + LogInDFP.getUserID() + "'");
            if (resultSet.next()){
                this.points = resultSet.getString(UsersTable.COLUMN_POINTS);
                this.discount = resultSet.getString(UsersTable.COLUMN_DISCOUNT);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updatePointsAndDiscount(String points, String discount) {
        try {
            statement.execute("UPDATE " + UsersTable.TABLE_NAME + " SET " + UsersTable.COLUMN_POINTS + "=" + "'" + points + "'" +
                                        ", " + UsersTable.COLUMN_DISCOUNT + "=" + "'" + discount + "'" +
                                        " WHERE " + UsersTable.COLUMN_ID + "=" + "'" + LogInDFP.getUserID() + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void queryUser() {
        try {
            resultSet = statement.executeQuery(UsersTable.SELECT_USER + "'" + LogInDFP.getUserID() + "'");
            if (resultSet.next()){
                this.name = resultSet.getString(UsersTable.COLUMN_NAME);
                this.points = resultSet.getString(UsersTable.COLUMN_POINTS);
                this.discount = resultSet.getString(UsersTable.COLUMN_DISCOUNT);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void modifyPoints() {
        queryPointsAndDiscount();
            if (Integer.parseInt(this.points) >= 100 && this.discount.equals("no")) {
                this.points = String.valueOf(Integer.parseInt(this.points) - 100);
                this.discount = "yes";
            } else if (Integer.parseInt(this.points) >= 100 && this.discount.equals("yes")) {
                this.points = String.valueOf(Integer.parseInt(this.points) - 100);
            }
        updatePointsAndDiscount(this.points, this.discount);
    }

    public void useDiscount() {
        try {
            statement.execute("UPDATE " + UsersTable.TABLE_NAME + " SET " + UsersTable.COLUMN_DISCOUNT + "=" + "'yes'" +
                    " WHERE " + UsersTable.COLUMN_ID + "=" + "'" + LogInDFP.getUserID() + "'");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPoints() {
        return this.points;
    }

    public String getDiscount() {
        return this.discount;
    }
}
