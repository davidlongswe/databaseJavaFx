package model;

import model.database_elements.DatabaseHandler;

import java.sql.*;

public class DisplayManager {

    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    public DisplayManager(){
    }

    public void sqlDisplay(DatabaseHandler dbh, String tableName){
        dbh.connect();
        try {
            String displayQuery = "SELECT * FROM " + tableName;
            this.statement = dbh.getDbConnection().createStatement();
            this.resultSet = statement.executeQuery(displayQuery);
            resultSetMetaData = resultSet.getMetaData();
            int nrOfColumns = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= nrOfColumns; i++) {
                System.out.print(resultSetMetaData.getColumnLabel(i) + "\t\t\n");
            }

            while (resultSet.next()) {
                for (int i = 1; i <= nrOfColumns; i++) {
                    System.out.print(resultSet.getString(i) + "\t\t\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbh.disconnect();
    }

}
