package model;

import model.database_elements.DatabaseHandler;
import java.util.Scanner;

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

    public void getDeleteDetails() {
        deleteManager.sqlDelete(this.databaseHandler);
    }

    public void getUpdateDetails() {
        updateManager.sqlUpdate(this.databaseHandler, "some table", "some id");
    }

    public void getInsertDetails() {
        insertManager.sqlInsert(this.databaseHandler, "table name", "something");
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
