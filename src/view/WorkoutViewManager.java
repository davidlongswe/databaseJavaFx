package view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import model.WorkoutModel;
import view.subscenes.CustomSubScene;

import java.util.ArrayList;


public class WorkoutViewManager extends Application {

    private Button addBtn, updateBtn, deleteBtn, subSceneInsertBtn, subSceneUpdateBtn;
    private Label nameLabel;
    private Scene scene;
    private ListView<String> myListView;
    private VBox myVBox, insertVBox, updateVBox;
    private HBox myHBox;
    private CustomSubScene sceneToHide, insertSubScene, updateSubScene;
    private Label insertNameLabel, insertTypeLabel, insertDurationLabel, updateNameLabel,
            updateTypeLabel, updateDurationLabel, updateDateLabel;
    private TextField insertType, insertDuration, insertName, updateName,
            updateType, updateDuration, updateDate;

    private ObservableList<String> workouts = FXCollections.observableArrayList();

    private WorkoutModel workoutModel;

    private int selectedIndex = -1;

    @Override
    public void start(Stage stage) throws Exception {
        workoutModel = new WorkoutModel();
        setUpStage(stage);
        setUpMainLabel();
        createButtons();
        setUpButtonBox();
        setUpWorkoutLogList();
        setUpWorkoutLogContentBox();
        createSubScenes();
        show(stage);
        displayList();
        setButtonListeners();
    }

    private void show(Stage stage) {
        stage.setScene(scene);
        stage.show();
    }

    private void setUpWorkoutLogContentBox() {
        myVBox = new VBox();
        myVBox.setSpacing(5);
        myVBox.setPrefWidth(400);
        myVBox.setPadding(new Insets(10, 0, 0, 10));
        myVBox.getChildren().addAll(nameLabel, myListView, myHBox);
        ((Group) scene.getRoot()).getChildren().addAll(myVBox);
    }

    private void setUpButtonBox() {
        myHBox = new HBox();
        myHBox.getChildren().addAll(addBtn,updateBtn,deleteBtn);
        myHBox.setSpacing(3);
    }

    private void createButtons() {
         addBtn = new Button("Add");
         addBtn.setOnMouseClicked(mouseEvent -> {
             showSubScene(insertSubScene);
         });
         updateBtn = new Button("Update");
         updateBtn.setOnMouseClicked(mouseEvent -> {
             showSubScene(updateSubScene);
         });
         deleteBtn = new Button("Delete");

    }

    public void setUpWorkoutLogList() {
        myListView = new ListView<>();
        myListView.setOnMouseClicked(event -> {
            String selectedItem = myListView.getSelectionModel().getSelectedItem();
            selectedIndex = myListView.getSelectionModel().getSelectedIndex();
            System.out.println("Selected index: " + selectedIndex + " " + "Selected item:" + selectedItem);
        });
        ((Group) scene.getRoot()).getChildren().add(myListView);
    }

    private void setUpMainLabel() {
        nameLabel = new Label("Workouts");
        nameLabel.setFont(new Font("Roboto", 20));
    }

    private void setUpStage(Stage stage) {
        scene = new Scene(new Group());
        stage.setTitle("WorkoutLogger");
        stage.setWidth(800);
        stage.setHeight(600);
    }


    public void showSubScene(CustomSubScene subScene){
        if(sceneToHide != null){
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private void createSubScenes(){
        createInsertSubScene();
        createUpdateSubScene();
    }

    private void createUpdateSubScene() {
        updateSubScene = new CustomSubScene();
        updateVBox = new VBox();
        updateVBox.setSpacing(5);
        updateVBox.setPrefWidth(200);
        updateVBox.setPadding(new Insets(10, 0, 0, 50));
        updateVBox.setAlignment(Pos.CENTER);

        updateNameLabel = new Label("Name");
        updateName = new TextField();
        updateTypeLabel = new Label("Type");
        updateType = new TextField();
        updateDurationLabel = new Label("Duration");
        updateDuration = new TextField();
        updateDateLabel = new Label("Date");
        updateDate = new TextField();
        subSceneUpdateBtn = new Button("UPDATE");

        updateVBox.getChildren().addAll(updateNameLabel, updateName, updateTypeLabel, updateType,
                updateDurationLabel, updateDuration, updateDateLabel, updateDate, subSceneUpdateBtn);
        updateSubScene.getPane().getChildren().add(updateVBox);
        ((Group) scene.getRoot()).getChildren().add(updateSubScene);
    }

    private void createInsertSubScene() {
        insertSubScene = new CustomSubScene();
        insertVBox = new VBox();
        insertVBox.setSpacing(5);
        insertVBox.setPrefWidth(200);
        insertVBox.setPadding(new Insets(10, 0, 0, 50));
        insertVBox.setAlignment(Pos.CENTER);

        insertNameLabel = new Label("Name");
        insertName = new TextField();
        insertTypeLabel = new Label("Type");
        insertType = new TextField();
        insertDurationLabel = new Label("Duration");
        insertDuration = new TextField();
        subSceneInsertBtn = new Button("INSERT");

        insertVBox.getChildren().addAll(insertNameLabel, insertName,
                insertTypeLabel, insertType, insertDurationLabel, insertDuration, subSceneInsertBtn);
        insertSubScene.getPane().getChildren().add(insertVBox);
        ((Group) scene.getRoot()).getChildren().add(insertSubScene);
    }

    public void displayList(){
        workoutModel.getDisplayDetails();
        ArrayList<String> modelWorkouts = workoutModel.getDisplayManager().getWorkoutLogs();
        workouts.addAll(modelWorkouts);
        myListView.setItems(workouts);
    }

    public void setButtonListeners(){
        addBtn.setOnMouseClicked(mouseEvent -> {
            showSubScene(insertSubScene);
        });
        subSceneInsertBtn.setOnMouseClicked(mouseEvent -> {
            workoutModel.getInsertDetails();
        });
        subSceneUpdateBtn.setOnMouseClicked(mouseEvent -> {
            workoutModel.getUpdateDetails();
        });
        updateBtn.setOnMouseClicked(mouseEvent ->  {
            showSubScene(updateSubScene);
        });
        deleteBtn.setOnMouseClicked(mouseEvent -> {
            workoutModel.getDeleteDetails();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}

