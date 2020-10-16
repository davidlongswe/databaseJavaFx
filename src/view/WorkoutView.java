package view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import model.database_elements.DatabaseHandler;
import view.subscenes.CustomSubScene;
import view.subscenes.InsertSubScene;
import view.subscenes.UpdateSubScene;

public class WorkoutView extends Application {

    private Button addBtn, updateBtn, deleteBtn;
    private Label nameLabel;
    private Scene scene;
    private ListView myListView;
    private VBox myVBox;
    private HBox myHBox;
    private InsertSubScene insertSubScene;
    private UpdateSubScene updateSubScene;
    private CustomSubScene sceneToHide;

    /*
    ObservableList. Our data source.
    */
    private final ObservableList<String> workouts =



            FXCollections.observableArrayList(
                    ("Joakim " + "joakim@gmail.com " + "1.0 " + "2020-09-18 18:32:40 " + "Gym "));
    private int selectedIndex=-1;


    @Override
    public void start(Stage stage) throws Exception {
        setUpStage(stage);
        setUpMainLabel();
        setUpWorkoutLogList();
        createButtons();
        setUpButtonBox();
        setUpWorkoutLogContentBox();
        createInsertSubScene();
        //createUpdateSubScene();
        show(stage);
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
         updateBtn = new Button("Update");
         deleteBtn = new Button("Delete");
    }

    private void setUpWorkoutLogList() {
        myListView= new ListView();
        myListView.setItems(workouts);
    }

    private void setUpMainLabel() {
        nameLabel = new Label("Workouts");
        nameLabel.setFont(new Font("Roboto", 20));
    }

    private void setUpStage(Stage stage) {
        scene = new Scene(new Group());
        stage.setTitle("WorkoutLogger");
        stage.setWidth(1024);
        stage.setHeight(768);
    }


    private void showSubScene(CustomSubScene subScene){
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
        updateSubScene = new UpdateSubScene();
        updateSubScene.addElements();
        ((Group) scene.getRoot()).getChildren().add(updateSubScene);
    }

    private void createInsertSubScene() {
        insertSubScene = new InsertSubScene();
        insertSubScene.addElements();
        ((Group) scene.getRoot()).getChildren().add(insertSubScene);
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}

