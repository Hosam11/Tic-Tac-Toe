package tictactoe;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class MenuSceneBase extends BorderPane {

    public Boolean flag = true;

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final Label gameTitle;
    protected final Label playerName;
    protected final Button onePlayerBtn;
    protected final InnerShadow innerShadow;
    protected final Button multiPlayerBtn;
    protected final InnerShadow innerShadow0;
    protected final Button exitBtn;
    protected final InnerShadow innerShadow1;
    protected final Label about;
    protected final Label history;
    protected final ImageView logo;
    protected final ImageView soundIcon;

    public MenuSceneBase() {

        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        gameTitle = new Label();
        playerName = new Label();
        onePlayerBtn = new Button();
        innerShadow = new InnerShadow();
        multiPlayerBtn = new Button();
        innerShadow0 = new InnerShadow();
        exitBtn = new Button();
        innerShadow1 = new InnerShadow();
        about = new Label();
        history = new Label();
        logo = new ImageView();
        soundIcon = new ImageView();

        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(512.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/../css/styles.css");

        BorderPane.setAlignment(leftSideAnchorPane, javafx.geometry.Pos.CENTER);
        leftSideAnchorPane.setPrefHeight(512.0);
        leftSideAnchorPane.setPrefWidth(179.0);
        setLeft(leftSideAnchorPane);

        BorderPane.setAlignment(rightSideAnchorPane, javafx.geometry.Pos.CENTER);
        rightSideAnchorPane.setPrefHeight(600.0);
        rightSideAnchorPane.setPrefWidth(182.0);
        setRight(rightSideAnchorPane);

        BorderPane.setAlignment(containerPane, javafx.geometry.Pos.BOTTOM_CENTER);
        containerPane.setId("containerPane");
        containerPane.setMaxWidth(USE_PREF_SIZE);
        containerPane.setMinWidth(USE_PREF_SIZE);
        containerPane.setPrefHeight(600.0);
        containerPane.setPrefWidth(393.0);

        contentPane.setId("contentPane");
        contentPane.setLayoutX(6.0);
        contentPane.setPrefHeight(600.0);
        contentPane.setPrefWidth(386.0);

        gameTitle.setId("gameTitle");
        gameTitle.setLayoutX(46.0);
        gameTitle.setLayoutY(6.0);
        gameTitle.setText("TICTOCTOE GAME");
        gameTitle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameTitle.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        gameTitle.setFont(new Font("System Bold", 12.0));

        playerName.setAlignment(javafx.geometry.Pos.CENTER);
        playerName.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        playerName.setText(SignInSceneBase.p.name);
        playerName.setLayoutX(62.0);
        playerName.setLayoutY(24.0);

        playerName.setText(SignInSceneBase.p.name);

        playerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerName.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        playerName.setFont(new Font("System Bold", 13.0));

        onePlayerBtn.setAlignment(javafx.geometry.Pos.CENTER);
        onePlayerBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        onePlayerBtn.setId("onePlayerBtn");
        onePlayerBtn.setLayoutX(117.0);
        onePlayerBtn.setLayoutY(187.0);
        onePlayerBtn.setMnemonicParsing(false);
        onePlayerBtn.setOnAction(this::loadPopUpLevels);
        onePlayerBtn.setPrefHeight(41.0);
        onePlayerBtn.setPrefWidth(143.0);
        onePlayerBtn.getStyleClass().add("options");
        onePlayerBtn.getStylesheets().add("/tictactoe/../css/styles.css");
        onePlayerBtn.setText("Playing: One Player");
        onePlayerBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        onePlayerBtn.setTextFill(javafx.scene.paint.Color.valueOf("#0a0801"));
        onePlayerBtn.setFont(new Font("System Bold", 12.0));
        onePlayerBtn.setCursor(Cursor.HAND);

        innerShadow.setBlurType(javafx.scene.effect.BlurType.GAUSSIAN);
        innerShadow.setColor(javafx.scene.paint.Color.WHITE);
        innerShadow.setHeight(24.0);
        innerShadow.setOffsetY(2.0);
        innerShadow.setRadius(11.75);
        innerShadow.setWidth(25.0);
        onePlayerBtn.setEffect(innerShadow);

        multiPlayerBtn.setAlignment(javafx.geometry.Pos.CENTER);
        multiPlayerBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        multiPlayerBtn.setId("multiPlayerBtn");
        multiPlayerBtn.setLayoutX(117.0);
        multiPlayerBtn.setLayoutY(270.0);
        multiPlayerBtn.setMnemonicParsing(false);
        multiPlayerBtn.setOnAction(this::loadPopUpLocalVsNw);
        multiPlayerBtn.setPrefHeight(41.0);
        multiPlayerBtn.setPrefWidth(143.0);
        multiPlayerBtn.getStyleClass().add("options");
        multiPlayerBtn.getStylesheets().add("/tictactoe/../css/styles.css");
        multiPlayerBtn.setText("Playing: Multi-Player");
        multiPlayerBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        multiPlayerBtn.setTextFill(javafx.scene.paint.Color.valueOf("#0a0801"));
        multiPlayerBtn.setFont(new Font("System Bold", 12.0));
        multiPlayerBtn.setCursor(Cursor.HAND);

        innerShadow0.setColor(javafx.scene.paint.Color.WHITE);
        innerShadow0.setHeight(23.0);
        innerShadow0.setOffsetY(2.0);
        innerShadow0.setRadius(11.5);
        innerShadow0.setWidth(25.0);
        multiPlayerBtn.setEffect(innerShadow0);

        exitBtn.setAlignment(javafx.geometry.Pos.CENTER);
        exitBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        exitBtn.setId("exitBtn");
        exitBtn.setLayoutX(117.0);
        exitBtn.setLayoutY(357.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setOnAction(this::exitProgram);
        exitBtn.setPrefHeight(41.0);
        exitBtn.setPrefWidth(143.0);
        exitBtn.getStyleClass().add("options");
        exitBtn.getStylesheets().add("/tictactoe/../css/styles.css");
        exitBtn.setText("Exit");
        exitBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        exitBtn.setTextFill(javafx.scene.paint.Color.valueOf("#0a0801"));
        exitBtn.setFont(new Font("System Bold", 12.0));

        innerShadow1.setColor(javafx.scene.paint.Color.WHITE);
        innerShadow1.setOffsetY(2.0);
        innerShadow1.setRadius(11.0);
        innerShadow1.setWidth(25.0);
        exitBtn.setEffect(innerShadow1);

        about.setAlignment(javafx.geometry.Pos.CENTER);
        about.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        about.setId("about");
        about.setLayoutX(19.0);
        about.setLayoutY(471.0);
        about.setOnMouseClicked(this::loadAboutScene);
        about.setPrefHeight(17.0);
        about.setPrefWidth(59.0);
        about.setText("About");
        about.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        about.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        about.setUnderline(true);
        about.setFont(new Font("System Bold", 15.0));

        history.setAlignment(javafx.geometry.Pos.CENTER);
        history.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        history.setId("history");
        history.setLayoutX(22.0);
        history.setLayoutY(513.0);
        history.setOnMouseClicked(this::loadHistoryScene);
        history.setPrefHeight(17.0);
        history.setPrefWidth(59.0);
        history.setText("History");
        history.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        history.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        history.setUnderline(true);
        history.setFont(new Font("System Bold", 15.0));

        logo.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        logo.setAccessibleRoleDescription("toHomePage");
        logo.setFitHeight(46.0);
        logo.setFitWidth(40.0);
        logo.setId("logo");
        logo.setLayoutX(3.0);
        logo.setLayoutY(3.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        logo.setImage(new Image(getClass().getResource("../img/logo/icon.png").toExternalForm()));

        soundIcon.setFitHeight(30.0);
        soundIcon.setFitWidth(30.0);
        soundIcon.setLayoutX(303.0);
        soundIcon.setLayoutY(69.0);
        soundIcon.setOnMouseClicked(this::muteSound);
        soundIcon.setPickOnBounds(true);
        soundIcon.setPreserveRatio(true);
        soundIcon.setImage(new Image(getClass().getResource("../img/sound/sound_icon.png").toExternalForm()));
        setCenter(containerPane);

        contentPane.getChildren().add(gameTitle);
        contentPane.getChildren().add(playerName);
        contentPane.getChildren().add(onePlayerBtn);
        contentPane.getChildren().add(multiPlayerBtn);
        contentPane.getChildren().add(exitBtn);
        contentPane.getChildren().add(about);
        contentPane.getChildren().add(history);
        contentPane.getChildren().add(logo);
        contentPane.getChildren().add(soundIcon);
        containerPane.getChildren().add(contentPane);

        EntryPoint.changeSoundImage(soundIcon);

    }

    protected void loadPopUpLevels(javafx.event.ActionEvent actionEvent) {
        PopUpLevelBase levelPopUp = new PopUpLevelBase();
        Scene scene = onePlayerBtn.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(levelPopUp.containerPane);

        makeFadeOut();

    }

    protected void loadPopUpLocalVsNw(javafx.event.ActionEvent actionEvent) {
        PopUpLocalVsNwBase nwPopUp = new PopUpLocalVsNwBase();
        Scene scene = multiPlayerBtn.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(nwPopUp.containerPane);

        makeFadeOut();
    }

    protected void loadAboutScene(javafx.scene.input.MouseEvent mouseEvent) {
        AboutSceneBase as = new AboutSceneBase();
        Scene scene = about.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(as.containerPane);

        makeFadeOut();
    }

    protected void loadHistoryScene(javafx.scene.input.MouseEvent mouseEvent) {
        HistorySceneBase hs = new HistorySceneBase();

        Scene scene = history.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(hs.containerPane);

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

    protected void muteSound(javafx.scene.input.MouseEvent mouseEvent) {
        EntryPoint.changeSoundStatue(soundIcon);
    }

    protected void exitProgram(javafx.event.ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Are You Sure ?",
                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            Platform.exit();
            System.exit(0);
        }

    }

}
