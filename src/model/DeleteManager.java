package model;

import model.database_elements.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DeleteManager {

    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    public DeleteManager(){
    }

    public void sqlDelete(DatabaseHandler dbh, String tableName, String ID){
        dbh.connect();

        dbh.disconnect();
    }



}
