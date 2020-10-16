package model.database_elements;

import java.sql.*;

public class DatabaseHandler {

    private final String DB_URL = "jdbc:mariadb://atlantis.informatik.umu.se/svph1917_db_ht2020";
    private Connection dbConnection;
    private DatabaseAccount databaseAccount;

    public DatabaseHandler(){
        try {
            Class.forName("org.mariadb.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.databaseAccount = new DatabaseAccount();
        } catch (Exception e) {
            System.err.println("JDBC Drivers were not found: " + e.getMessage());
        }
    }

    public void connect(){
        try {
            dbConnection = DriverManager.getConnection(
                    DB_URL,
                    databaseAccount.getUser(),
                    databaseAccount.getPassword());
        }catch (SQLException e) {
            System.err.println("Database couldn't connect with error-code: " + e.getMessage());
        }
    }

    public void disconnect(){
        try {
            if(dbConnection != null){
                dbConnection.close();
            }
        } catch (SQLException e) {
            System.err.println("Database couldn't disconnect with error-code: " + e.getMessage());
        }
    }

    public Connection getDbConnection() {
        return dbConnection;
    }
}
