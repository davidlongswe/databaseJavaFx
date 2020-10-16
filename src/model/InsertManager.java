package model;

import model.database_elements.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertManager {

    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    public InsertManager(){ }

    public void sqlInsert(DatabaseHandler dbh, String name, String type, float duration){
        dbh.connect();
        try {
            String insertQuery = ""; //TODO insert query here (
            this.statement = dbh.getDbConnection().createStatement();
            this.resultSet = statement.executeQuery(insertQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        dbh.disconnect();
    }

}
