package view.subscenes;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class CustomSubScene extends SubScene {

    private boolean isHidden;
    public static final String PANEL_IMAGE = "view/resources/grey_panel.png";
    private AnchorPane root;

    public CustomSubScene() {
        super(new AnchorPane(), 300, 400);
        prefWidth(300);
        prefHeight(400);
        BackgroundImage backgroundImage= new BackgroundImage(new Image(PANEL_IMAGE,300,400,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root = (AnchorPane) this.getRoot();
        root.setBackground(new Background(backgroundImage));
        setLayoutX(1024);
        setLayoutY(40);
        isHidden = true;
    }

    /**
     * moveSubscene - Moves the sub-scene out and into the screen with a translateTransition
     */
    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        if (isHidden) {
            transition.setToX(-600);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }

    /**
     * getPane - gets the root pane for the sub-scene
     *
     * @return
     */
    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();
    }

    public boolean isHidden() {
        return isHidden;
    }
}
