package alerts;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class AlertWithActionsBase extends BorderPane {

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final Label stateSting;
    protected final Button cancelBtn;
    protected final ButtonBar buttonBar;
    protected final ImageView closeIcon;
    protected final Button okBtn;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;

    public AlertWithActionsBase() {

        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        stateSting = new Label();
        cancelBtn = new Button();
        buttonBar = new ButtonBar();
        closeIcon = new ImageView();
        okBtn = new Button();
        anchorPane = new AnchorPane();
        anchorPane0 = new AnchorPane();

        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(578.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(leftSideAnchorPane, javafx.geometry.Pos.CENTER);
        leftSideAnchorPane.setPrefHeight(561.0);
        leftSideAnchorPane.setPrefWidth(200.0);
        setLeft(leftSideAnchorPane);

        BorderPane.setAlignment(rightSideAnchorPane, javafx.geometry.Pos.CENTER);
        rightSideAnchorPane.setPrefHeight(561.0);
        rightSideAnchorPane.setPrefWidth(207.0);
        setRight(rightSideAnchorPane);

        BorderPane.setAlignment(containerPane, javafx.geometry.Pos.CENTER);
        containerPane.setId("containerPane");
        containerPane.setMaxHeight(USE_PREF_SIZE);
        containerPane.setMaxWidth(USE_PREF_SIZE);
        containerPane.setMinHeight(USE_PREF_SIZE);
        containerPane.setMinWidth(USE_PREF_SIZE);
        containerPane.setPrefHeight(254.0);
        containerPane.setPrefWidth(382.0);
        containerPane.getStylesheets().add("/css/styles.css");

        contentPane.setPrefHeight(254.0);
        contentPane.setPrefWidth(383.0);
        contentPane.setStyle("-fx-background-color: white;");

        stateSting.setAlignment(javafx.geometry.Pos.CENTER);
        stateSting.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        stateSting.setLayoutX(1.0);
        stateSting.setLayoutY(56.0);
        stateSting.setPrefHeight(26.0);
        stateSting.setPrefWidth(383.0);
        stateSting.setText("Label");
        stateSting.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        stateSting.setTextFill(javafx.scene.paint.Color.valueOf("#3b3939"));
        stateSting.setFont(new Font(17.0));

        cancelBtn.setAlignment(javafx.geometry.Pos.CENTER);
        cancelBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        cancelBtn.setLayoutX(266.0);
        cancelBtn.setLayoutY(175.0);
        cancelBtn.setMnemonicParsing(false);
        cancelBtn.setPrefHeight(31.0);
        cancelBtn.setPrefWidth(67.0);
        cancelBtn.getStyleClass().add("options");
        cancelBtn.getStylesheets().add("/css/styles.css");
        cancelBtn.setText("Cancel");
        cancelBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cancelBtn.setFont(new Font("System Bold", 15.0));

        buttonBar.setLayoutX(8.0);
        buttonBar.setPrefHeight(28.0);
        buttonBar.setPrefWidth(376.0);

        closeIcon.setFitHeight(24.0);
        closeIcon.setFitWidth(35.0);
        closeIcon.setPickOnBounds(true);
        closeIcon.setPreserveRatio(true);
        closeIcon.setImage(new Image(getClass().getResource("/img/close_icon.png").toExternalForm()));

        okBtn.setAlignment(javafx.geometry.Pos.CENTER);
        okBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        okBtn.setLayoutX(64.0);
        okBtn.setLayoutY(175.0);
        okBtn.setMnemonicParsing(false);
        okBtn.setPrefHeight(31.0);
        okBtn.setPrefWidth(67.0);
        okBtn.getStyleClass().add("options");
        okBtn.getStylesheets().add("/css/styles.css");
        okBtn.setText("Ok");
        okBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        okBtn.setFont(new Font("System Bold", 15.0));
        setCenter(containerPane);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);
        setTop(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);
        setBottom(anchorPane0);

        contentPane.getChildren().add(stateSting);
        contentPane.getChildren().add(cancelBtn);
        buttonBar.getButtons().add(closeIcon);
        contentPane.getChildren().add(buttonBar);
        contentPane.getChildren().add(okBtn);
        containerPane.getChildren().add(contentPane);

    }
}
