package animations;

import javafx.animation.ScaleTransition;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.util.Duration;

public  class DrawBase extends AnchorPane {

    protected final Text text;

    public DrawBase() {

        text = new Text();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setId("drawback");
        text.setLayoutX(200.0);
        text.setLayoutY(196.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("No Winner..");
        text.setId("draw");
        
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(1000));
        scaleTransition.setNode(text);
        scaleTransition.setByY(1.5);
        scaleTransition.setByX(1.5);
        scaleTransition.setCycleCount(30);
        scaleTransition.setAutoReverse(false);
        scaleTransition.play();
        getChildren().add(text);

    }
}
