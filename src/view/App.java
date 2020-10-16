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


public class App extends Application {

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
    private ArrayList<String> dbWorkouts;

    @Override
    public void start(Stage stage) throws Exception {
        workoutModel = new WorkoutModel();
        dbWorkouts = new ArrayList<>();
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
        updateVBox = createCustomVBox(updateVBox, 5, 200);

        updateNameLabel = new Label("Name");
        updateTypeLabel = new Label("Type");
        updateDurationLabel = new Label("Duration");
        updateDateLabel = new Label("Date");

        updateName = new TextField();
        updateType = new TextField();
        updateDuration = new TextField();
        updateDate = new TextField();

        subSceneUpdateBtn = new Button("UPDATE");

        updateVBox.getChildren().addAll(updateNameLabel, updateName, updateTypeLabel, updateType,
                updateDurationLabel, updateDuration, updateDateLabel, updateDate, subSceneUpdateBtn);
        updateSubScene.getPane().getChildren().add(updateVBox);
        ((Group) scene.getRoot()).getChildren().add(updateSubScene);
    }

    private void createInsertSubScene() {
        insertSubScene = new CustomSubScene();
        insertVBox = createCustomVBox(insertVBox, 5, 200);

        insertNameLabel = new Label("Name");
        insertTypeLabel = new Label("Type");
        insertDurationLabel = new Label("Duration");

        insertName = new TextField();
        insertType = new TextField();
        insertDuration = new TextField();

        subSceneInsertBtn = new Button("INSERT");

        insertVBox.getChildren().addAll(insertNameLabel, insertName,
                insertTypeLabel, insertType, insertDurationLabel, insertDuration, subSceneInsertBtn);
        insertSubScene.getPane().getChildren().add(insertVBox);
        ((Group) scene.getRoot()).getChildren().add(insertSubScene);
    }

    public VBox createCustomVBox(VBox vb, int spacing, int width){
        vb = new VBox();
        vb.setSpacing(spacing);
        vb.setPrefWidth(width);
        vb.setPadding(new Insets(10, 0, 0, 50));
        vb.setAlignment(Pos.CENTER);
        return vb;
    }

    public void displayList(){
        workoutModel.getDisplayDetails();
        dbWorkouts = workoutModel.getDisplayManager().getWorkoutLogs();
        workouts.addAll(dbWorkouts);
        myListView.setItems(workouts);
    }

    public void setButtonListeners(){
        addBtn.setOnMouseClicked(mouseEvent -> showSubScene(insertSubScene));

        subSceneInsertBtn.setOnMouseClicked(mouseEvent ->
                workoutModel.getInsertDetails(
                        insertName.getText(),
                        insertType.getText(),
                        Float.parseFloat(updateDuration.getText())));

        subSceneUpdateBtn.setOnMouseClicked(mouseEvent ->
                workoutModel.getUpdateDetails(
                        updateType.getText(),
                        Float.parseFloat(updateDuration.getText())));

        updateBtn.setOnMouseClicked(mouseEvent -> showSubScene(updateSubScene));

        deleteBtn.setOnMouseClicked(mouseEvent -> {
            if(myListView.getSelectionModel().isSelected(selectedIndex)){
                workoutModel.getDeleteDetails(selectedIndex);
                myListView.getItems().remove(selectedIndex);
            }
        });
    }

}

