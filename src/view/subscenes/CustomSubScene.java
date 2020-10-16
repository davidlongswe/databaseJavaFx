package view.subscenes;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class CustomSubScene extends SubScene {

    private boolean isHidden;

    public CustomSubScene() {
        super(new AnchorPane(), 400, 400);
    }

    /**
     * moveSubscene - Moves the sub-scene out and into the screen with a translateTransition
     */
    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        if (isHidden) {
            transition.setToX(-676);
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
