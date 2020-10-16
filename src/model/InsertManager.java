package model;

import model.database_elements.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class InsertManager {

    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;

    public InsertManager(){

    }

    public void sqlInsert(DatabaseHandler dbh, String tableName, String something){
        dbh.connect();

        dbh.disconnect();
    }

}
