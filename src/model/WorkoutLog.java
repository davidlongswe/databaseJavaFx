package model;

import java.time.LocalDateTime;

public class Workoutlog {
    private int workout_id;
    private int user_id;
    private LocalDateTime date;
    private Float duration;

    public Workoutlog(int workout_id, int user_id, LocalDateTime date, Float duration) {
        this.workout_id = workout_id;
        this.user_id = user_id;
        this.date = date;
        this.duration = duration;

    }

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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }
}