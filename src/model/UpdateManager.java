package model;

import model.database_elements.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class UpdateManager {

    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    public UpdateManager(){

    }

    public void sqlUpdate(DatabaseHandler dbh, String tableName, String ID){
        dbh.connect();

        dbh.disconnect();
    }

}
