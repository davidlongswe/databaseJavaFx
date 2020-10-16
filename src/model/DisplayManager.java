package model;

import model.database_elements.DatabaseHandler;

import java.sql.*;
import java.util.ArrayList;

public class DisplayManager {

    private Statement statement;
    private ResultSet resultSet;
    private ArrayList<String> workoutLogs;
    private ArrayList<WorkoutLog> logObjects;

    public DisplayManager(){
        workoutLogs = new ArrayList<>();
        logObjects = new ArrayList<>();
    }

    public void sqlDisplay(DatabaseHandler dbh){
        dbh.connect();
        try {
            String displayQuery = "SELECT workout_id, user_id, name, email, duration, date, type " +
                    "FROM (User NATURAL JOIN Workout_log) " +
                    "NATURAL JOIN Workout";
            this.statement = dbh.getDbConnection().createStatement();
            this.resultSet = statement.executeQuery(displayQuery);
            while(resultSet.next()){
                WorkoutLog workoutLog = new WorkoutLog();
                workoutLog.setWorkout_id(resultSet.getInt("workout_id"));
                workoutLog.setUser_id(resultSet.getInt("user_id"));
                workoutLog.setDate(resultSet.getDate("date"));
                workoutLog.setDuration(resultSet.getFloat("duration"));
                logObjects.add(workoutLog);
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

    public ArrayList<WorkoutLog> getLogObjects() {
        return logObjects;
    }

    public ArrayList<String> getWorkoutLogs() {
        return workoutLogs;
    }
}
