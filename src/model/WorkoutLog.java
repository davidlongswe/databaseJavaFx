package model;

import java.sql.Timestamp;


public class WorkoutLog {

    private int workout_id;
    private int user_id;
    private String timestamp;
    private Float duration;

    public WorkoutLog() {}

    public int getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(int workout_id) {
        this.workout_id = workout_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        String tsString = timestamp.toString();
        String tsStringCorrected = tsString.substring(0, tsString.length() - 2);
        this.timestamp = tsStringCorrected;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }
}
