package view.subscenes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class InsertSubScene extends CustomSubScene {

    public static final String PANEL_IMAGE = "view/resources/grey_panel.png";
    private VBox vBox;
    private TextField name, type, duration;
    private Label nameLabel, typeLabel, durationLabel;
    private Button insertBtn;
    private AnchorPane root;


    public InsertSubScene(){
        prefWidth(400);
        prefHeight(400);
        BackgroundImage backgroundImage= new BackgroundImage(new Image(PANEL_IMAGE,400,400,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root = (AnchorPane) this.getRoot();
        root.setBackground(new Background(backgroundImage));
        setLayoutX(480);
        setLayoutY(40);
    }

    public void addElements(){
        vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPrefWidth(300);
        vBox.setPadding(new Insets(10, 0, 0, 50));
        vBox.setAlignment(Pos.CENTER);

        nameLabel = new Label("Name");
        name = new TextField();
        typeLabel = new Label("Type");
        type = new TextField();
        durationLabel = new Label("Duration");
        duration = new TextField();
        insertBtn = new Button("INSERT");

        vBox.getChildren().addAll(nameLabel, name, typeLabel, type, durationLabel, duration, insertBtn);
        getPane().getChildren().add(vBox);
    }

    @Override
    public AnchorPane getPane() {
        return super.getPane();
    }

}
