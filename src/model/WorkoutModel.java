package model;

import model.database_elements.DatabaseHandler;

import java.sql.Timestamp;

public class WorkoutModel {

    private DatabaseHandler databaseHandler;
    private DeleteManager deleteManager;
    private DisplayManager displayManager;
    private InsertManager insertManager;
    private UpdateManager updateManager;

    public WorkoutModel(){
        this.databaseHandler = new DatabaseHandler();
        this.deleteManager = new DeleteManager();
        this.displayManager = new DisplayManager();
        this.insertManager = new InsertManager();
        this.updateManager = new UpdateManager();
    }

    public void getDisplayDetails() {
        displayManager.sqlDisplay(this.databaseHandler);
    }

    public void getDeleteDetails(int selectedIndex) {
        deleteManager.sqlDelete(this.databaseHandler, selectedIndex, this.displayManager.getLogObjects());
    }

    public void getUpdateDetails(String type, float duration) {
        updateManager.sqlUpdate(this.databaseHandler, type, duration);
    }

    public void getInsertDetails(String name, String type, float duration) {
        insertManager.sqlInsert(this.databaseHandler, name, type, duration);
    }

    public DatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }

    public DeleteManager getDeleteManager() {
        return deleteManager;
    }

    public DisplayManager getDisplayManager() {
        return displayManager;
    }

    public InsertManager getInsertManager() {
        return insertManager;
    }

    public UpdateManager getUpdateManager() {
        return updateManager;
    }
}
