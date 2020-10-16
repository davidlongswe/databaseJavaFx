package model;

import model.database_elements.DatabaseHandler;
import java.util.Scanner;

public class WorkoutModel {

    private DatabaseHandler databaseHandler;
    private DeleteManager deleteManager;
    private DisplayManager displayManager;
    private InsertManager insertManager;
    private UpdateManager updateManager;
    private Scanner scanner;

    public WorkoutModel(){
        this.databaseHandler = new DatabaseHandler();
        this.deleteManager = new DeleteManager();
        this.displayManager = new DisplayManager();
        this.insertManager = new InsertManager();
        this.updateManager = new UpdateManager();
        this.scanner = new Scanner(System.in);
    }

    public void runProgram(){
        queryUser();
    }

    private void queryUser() {
        int userChoice = scanner.nextInt();
        do{
            System.out.println("1. Insert new entry\n2. Update entry\n3. Delete entry\n4. Show table entries\n5. Quit");
            switch(userChoice){
                case 1:
                    getInsertDetails();
                    break;
                case 2:
                    getUpdateDetails();
                    break;
                case 3:
                    getDeleteDetails();
                    break;
                case 4:
                    getDisplayDetails();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
            userChoice = scanner.nextInt();
        }while(userChoice != 5);
    }

    private void getDisplayDetails() {
        //TODO: ask user what they want to display
        displayManager.sqlDisplay(this.databaseHandler, "table to display");
    }

    private void getDeleteDetails() {
        //TODO: ask user what they want to delete
        deleteManager.sqlDelete(this.databaseHandler, "entry to delete", "some id");

    }

    private void getUpdateDetails() {
        //TODO: ask user what they want to update
        updateManager.sqlUpdate(this.databaseHandler, "some table", "some id");
    }

    private void getInsertDetails() {
        //TODO: ask user what they want to insert
        insertManager.sqlInsert(this.databaseHandler, "table name", "something");
    }


}
