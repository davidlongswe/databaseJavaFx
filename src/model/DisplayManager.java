package model;

import model.database_elements.DatabaseHandler;

import java.sql.*;
import java.util.ArrayList;

public class DisplayManager {

    private Statement statement;
    private ResultSet resultSet;
    private ArrayList<String> workoutLogs;

    public DisplayManager(){
        workoutLogs = new ArrayList<>();
    }

    public void sqlDisplay(DatabaseHandler dbh){
        dbh.connect();
        try {
            String displayQuery = "SELECT name, email, duration, date, type " +
                    "FROM (User NATURAL JOIN Workout_log) " +
                    "NATURAL JOIN Workout";
            this.statement = dbh.getDbConnection().createStatement();
            this.resultSet = statement.executeQuery(displayQuery);
            while(resultSet.next()){
                workoutLogs.add(resultSet.getString("name") + " " +
                        resultSet.getString("email") + " " +
                        resultSet.getDate("date") + " " +
                        resultSet.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbh.disconnect();
    }

    public ArrayList<String> getWorkoutLogs() {
        return workoutLogs;
    }
}
