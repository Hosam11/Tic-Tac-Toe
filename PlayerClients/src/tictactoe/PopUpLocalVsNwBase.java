package tictactoe;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class PopUpLocalVsNwBase extends BorderPane {

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final ButtonBar buttonBar;
    protected final ImageView closeIcon;
    protected final Button localOption;
    protected final InnerShadow innerShadow;
    protected final Button nwOption;
    protected final InnerShadow innerShadow0;
    protected final AnchorPane anchorPane;
    protected final AnchorPane anchorPane0;

        PlayerVSPlayer vSPlayer ;

    
    public PopUpLocalVsNwBase() {

        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        buttonBar = new ButtonBar();
        closeIcon = new ImageView();
        localOption = new Button();
        innerShadow = new InnerShadow();
        nwOption = new Button();
        innerShadow0 = new InnerShadow();
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
        containerPane.getStylesheets().add("/tictactoe/../css/styles.css");

        contentPane.setId("contentPane");
        contentPane.setPrefHeight(223.0);
        contentPane.setPrefWidth(378.0);
        contentPane.getStylesheets().add("/tictactoe/../css/styles.css");

        buttonBar.setLayoutX(6.0);
        buttonBar.setPrefHeight(28.0);
        buttonBar.setPrefWidth(376.0);

        closeIcon.setFitHeight(24.0);
        closeIcon.setFitWidth(35.0);
        closeIcon.setOnMouseClicked(this::loadMenuScene);
        closeIcon.setPickOnBounds(true);
        closeIcon.setPreserveRatio(true);
        closeIcon.setImage(new Image(getClass().getResource("../img/close_icon.png").toExternalForm()));

        localOption.setAlignment(javafx.geometry.Pos.CENTER);
        localOption.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        localOption.setId("onePlayer");
        localOption.setLayoutX(119.0);
        localOption.setLayoutY(58.0);
        localOption.setMnemonicParsing(false);
        localOption.setOnAction(this::loadGameSceneWithLocal);
        localOption.setPrefHeight(41.0);
        localOption.setPrefWidth(143.0);
        localOption.getStyleClass().add("options");
        localOption.getStylesheets().add("/tictactoe/../css/styles.css");
        localOption.setText("Local");
        localOption.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        localOption.setTextFill(javafx.scene.paint.Color.valueOf("#0a0801"));
        localOption.setFont(new Font("System Bold", 12.0));
        localOption.setCursor(Cursor.HAND);

        innerShadow.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
        innerShadow.setColor(javafx.scene.paint.Color.WHITE);
        innerShadow.setHeight(24.0);
        innerShadow.setOffsetY(2.0);
        innerShadow.setRadius(11.75);
        innerShadow.setWidth(25.0);
        localOption.setEffect(innerShadow);

        nwOption.setAlignment(javafx.geometry.Pos.CENTER);
        nwOption.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        nwOption.setId("exit");
        nwOption.setLayoutX(119.0);
        nwOption.setLayoutY(124.0);
        nwOption.setMnemonicParsing(false);
        nwOption.setOnAction(this::loadGameSceneWithNw);
        nwOption.setPrefHeight(41.0);
        nwOption.setPrefWidth(143.0);
        nwOption.getStyleClass().add("options");
        nwOption.getStylesheets().add("/tictactoe/../css/styles.css");
        nwOption.setText("Network");
        nwOption.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        nwOption.setTextFill(javafx.scene.paint.Color.valueOf("#0a0801"));
        nwOption.setFont(new Font("System Bold", 12.0));

        innerShadow0.setColor(javafx.scene.paint.Color.WHITE);
        innerShadow0.setOffsetY(2.0);
        innerShadow0.setRadius(11.0);
        innerShadow0.setWidth(25.0);
        nwOption.setEffect(innerShadow0);
        setCenter(containerPane);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);
        setTop(anchorPane);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);
        setBottom(anchorPane0);

        buttonBar.getButtons().add(closeIcon);
        contentPane.getChildren().add(buttonBar);
        contentPane.getChildren().add(localOption);
        contentPane.getChildren().add(nwOption);
        containerPane.getChildren().add(contentPane);

    }

    protected void loadMenuScene(javafx.scene.input.MouseEvent mouseEvent) {
        MenuSceneBase ms = new MenuSceneBase();
        Scene scene = closeIcon.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(ms.containerPane);

        makeFadeOut();
    }

    protected void loadGameSceneWithNw(javafx.event.ActionEvent actionEvent) {
        GameSceneBase gs = new GameSceneBase();
        Scene scene = nwOption.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(gs.containerPane);

        makeFadeOut();

        Platform.runLater(() -> {
            ClientPlayers clientPlayers = new ClientPlayers(gs, SignInSceneBase.p.name);
            System.err.println("na is >> " + SignInSceneBase.p.name);
        });

    }

    protected void loadGameSceneWithLocal(javafx.event.ActionEvent actionEvent) {
        GameSceneBase gs = new GameSceneBase();
        Scene scene = localOption.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(gs.containerPane);
        
        vSPlayer = new PlayerVSPlayer(gs);
        System.out.println("from local player");

        makeFadeOut();
    }

    private void makeFadeOut() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(1));
        fadeTransition.setNode(containerPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        //fadeTransition.setOnFinished((ActionEvent event) -> {
        //    loadHomeScene(event);
        //});
        fadeTransition.play(); //to Initiate the transition
    }

}
