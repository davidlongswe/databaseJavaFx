package model;

import model.database_elements.DatabaseHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeleteManager {

    private Statement statement;
    private ResultSet resultSet;

    public DeleteManager(){
    }

    public void sqlDelete(DatabaseHandler dbh, int selectedIndex, ArrayList<WorkoutLog> logObjects){
        dbh.connect();
        try {
            WorkoutLog workoutLog = logObjects.get(selectedIndex);
            String displayQuery = "DELETE FROM Workout_log WHERE user_id = " +
                    "" + workoutLog.getUser_id() + " AND workout_id = "
                    + workoutLog.getWorkout_id() + " AND date = " + workoutLog.getTimestamp();
            System.out.println(displayQuery);
            //String displayQuery = "DELETE FROM Workout_log WHERE user_id = 3 AND workout_id = 2 AND date = '2020-09-05 14:15:26'";
            this.statement = dbh.getDbConnection().createStatement();
            this.resultSet = statement.executeQuery(displayQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbh.disconnect();
    }
}
