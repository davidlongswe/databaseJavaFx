package model;

import model.database_elements.DatabaseHandler;

import java.sql.*;

public class UpdateManager {

    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    public UpdateManager(){

    }

    public void sqlUpdate(DatabaseHandler dbh, String type, float duration){
        dbh.connect();
        try {
            String updateQuery = ""; //TODO update query here
            this.statement = dbh.getDbConnection().createStatement();
            this.resultSet = statement.executeQuery(updateQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dbh.disconnect();
    }

}
