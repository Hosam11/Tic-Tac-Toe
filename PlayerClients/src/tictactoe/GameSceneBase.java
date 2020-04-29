package tictactoe;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GameSceneBase extends BorderPane {

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final Label gameTitle;
    protected final Line sperateLine;
    public final ImageView logo;
    protected final AnchorPane actionPane;
    protected final Line lineV2;
    protected final Line lineV1;
    protected final Line lineH2;
    protected final Line lineH1;
    public final Button btn0;
    public final Button btn1;
    public final Button btn2;
    public final Button btn3;
    public final Button btn4;
    public final Button btn5;
    public final Button btn6;
    public final Button btn7;
    public final Button btn8;
    protected final AnchorPane infoPane;
    protected final Label player_2;
    protected final Label pLayer_1;
    protected final Label tieLabel;
    public final Label scoreLabel_1;
    public final Label scoreLabel_2;
    public final Label tieScoreLabel;
    protected final Label statusLable;
    protected final ImageView scoreIcon;
    protected final ImageView soundIcon;
    protected final Label playerName;

    public GameSceneBase() {
        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        gameTitle = new Label();
        sperateLine = new Line();
        logo = new ImageView();
        actionPane = new AnchorPane();
        lineV2 = new Line();
        lineV1 = new Line();
        lineH2 = new Line();
        lineH1 = new Line();
        btn2 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn8 = new Button();
        btn0 = new Button();
        btn1 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn7 = new Button();
        infoPane = new AnchorPane();
        player_2 = new Label();
        pLayer_1 = new Label();
        tieLabel = new Label();
        scoreLabel_1 = new Label();
        scoreLabel_2 = new Label();
        tieScoreLabel = new Label();
        statusLable = new Label();
        scoreIcon = new ImageView();
        soundIcon = new ImageView();
        playerName = new Label();

        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(580.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/../css/styles.css");

        BorderPane.setAlignment(leftSideAnchorPane, javafx.geometry.Pos.CENTER);
        leftSideAnchorPane.setPrefHeight(561.0);
        leftSideAnchorPane.setPrefWidth(200.0);
        setLeft(leftSideAnchorPane);

        BorderPane.setAlignment(rightSideAnchorPane, javafx.geometry.Pos.CENTER);
        rightSideAnchorPane.setPrefHeight(561.0);
        rightSideAnchorPane.setPrefWidth(207.0);
        setRight(rightSideAnchorPane);

        BorderPane.setAlignment(containerPane, javafx.geometry.Pos.BOTTOM_CENTER);
        containerPane.setId("containerPane");
        containerPane.setMaxWidth(USE_PREF_SIZE);
        containerPane.setMinWidth(USE_PREF_SIZE);
        containerPane.setPrefHeight(561.0);
        containerPane.setPrefWidth(382.0);

        contentPane.setId("contentPane");
        contentPane.setLayoutY(9.0);
        contentPane.setPrefHeight(561.0);
        contentPane.setPrefWidth(382.0);

        gameTitle.setAlignment(javafx.geometry.Pos.CENTER);
        gameTitle.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        gameTitle.setId("gameTitle");
        gameTitle.setLayoutX(48.0);
        gameTitle.setLayoutY(3.0);
        gameTitle.setText("TICTOCTOE-GAME");
        gameTitle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameTitle.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        gameTitle.setFont(new Font("System Bold", 12.0));

        sperateLine.setEndX(-171.0);
        sperateLine.setEndY(290.0);
        sperateLine.setId("lineH2");
        sperateLine.setLayoutX(185.0);
        sperateLine.setLayoutY(106.0);
        sperateLine.setStartX(182.33334350585938);
        sperateLine.setStartY(290.0);
        sperateLine.setStroke(javafx.scene.paint.Color.valueOf("#7e7c7c"));
        sperateLine.setStrokeWidth(2.0);

        logo.setFitHeight(40.0);
        logo.setFitWidth(40.0);
        logo.setLayoutX(4.0);
        logo.setLayoutY(1.0);
        logo.setOnMouseClicked(this::loadMenuScene);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        logo.setImage(new Image(getClass().getResource("../img/logo/icon.png").toExternalForm()));

        actionPane.setId("actionPane");
        actionPane.setLayoutX(38.0);
        actionPane.setLayoutY(66.0);
        actionPane.setPrefHeight(305.0);
        actionPane.setPrefWidth(297.0);
        actionPane.getStyleClass().add("action");
        actionPane.getStylesheets().add("/tictactoe/../css/styles.css");

        lineV2.setEndX(-105.99996948242188);
        lineV2.setEndY(267.0);
        lineV2.setId("lineV2");
        lineV2.setLayoutX(304.0);
        lineV2.setLayoutY(20.0);
        lineV2.setStartX(-105.99998474121094);
        lineV2.setStartY(8.666664123535156);
        lineV2.setStroke(javafx.scene.paint.Color.WHITE);
        lineV2.setStrokeWidth(4.0);

        lineV1.setEndX(-105.99995422363281);
        lineV1.setEndY(266.3333435058594);
        lineV1.setId("lineV1");
        lineV1.setLayoutX(201.0);
        lineV1.setLayoutY(21.0);
        lineV1.setStartX(-105.99998474121094);
        lineV1.setStartY(8.666664123535156);
        lineV1.setStroke(javafx.scene.paint.Color.WHITE);
        lineV1.setStrokeWidth(4.0);

        lineH2.setEndX(-127.99998474121094);
        lineH2.setEndY(290.0);
        lineH2.setId("lineH2");
        lineH2.setLayoutX(130.0);
        lineH2.setLayoutY(-88.0);
        lineH2.setStartX(159.33334350585938);
        lineH2.setStartY(290.0);
        lineH2.setStroke(javafx.scene.paint.Color.WHITE);
        lineH2.setStrokeWidth(4.0);

        lineH1.setEndX(-142.99998474121094);
        lineH1.setEndY(290.0);
        lineH1.setId("lineH1");
        lineH1.setLayoutX(145.0);
        lineH1.setLayoutY(-176.0);
        lineH1.setStartX(143.33334350585938);
        lineH1.setStartY(290.0);
        lineH1.setStroke(javafx.scene.paint.Color.WHITE);
        lineH1.setStrokeWidth(4.0);

        btn2.setAlignment(javafx.geometry.Pos.CENTER);
        btn2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn2.setId("btn3");
        btn2.setLayoutX(201.0);
        btn2.setLayoutY(29.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(81.0);
        btn2.setPrefWidth(89.0);
        btn2.getStyleClass().add("btn");
        btn2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn2.setTextFill(javafx.scene.paint.Color.WHITE);

        btn5.setAlignment(javafx.geometry.Pos.CENTER);
        btn5.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn5.setId("btn6");
        btn5.setLayoutX(201.0);
        btn5.setLayoutY(117.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(81.0);
        btn5.setPrefWidth(89.0);
        btn5.getStyleClass().add("btn");
        btn5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn5.setTextFill(javafx.scene.paint.Color.WHITE);

        btn6.setAlignment(javafx.geometry.Pos.CENTER);
        btn6.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn6.setId("btn7");
        btn6.setLayoutX(3.0);
        btn6.setLayoutY(205.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(81.0);
        btn6.setPrefWidth(89.0);
        btn6.getStyleClass().add("btn");
        btn6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn6.setTextFill(javafx.scene.paint.Color.WHITE);

        btn8.setAlignment(javafx.geometry.Pos.CENTER);
        btn8.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn8.setId("btn9");
        btn8.setLayoutX(201.0);
        btn8.setLayoutY(205.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(81.0);
        btn8.setPrefWidth(89.0);
        btn8.getStyleClass().add("btn");
        btn8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn8.setTextFill(javafx.scene.paint.Color.WHITE);

        btn0.setAlignment(javafx.geometry.Pos.CENTER);
        btn0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn0.setId("btn1");
        btn0.setLayoutX(3.0);
        btn0.setLayoutY(29.0);
        btn0.setMnemonicParsing(false);
        btn0.setPrefHeight(81.0);
        btn0.setPrefWidth(89.0);
        btn0.getStyleClass().add("btn");
        btn0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn0.setTextFill(javafx.scene.paint.Color.WHITE);

        btn1.setAlignment(javafx.geometry.Pos.CENTER);
        btn1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn1.setId("btn2");
        btn1.setLayoutX(98.0);
        btn1.setLayoutY(29.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(81.0);
        btn1.setPrefWidth(97.0);
        btn1.getStyleClass().add("btn");
        btn1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn1.setTextFill(javafx.scene.paint.Color.WHITE);

        btn3.setAlignment(javafx.geometry.Pos.CENTER);
        btn3.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn3.setId("btn4");
        btn3.setLayoutX(3.0);
        btn3.setLayoutY(117.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(81.0);
        btn3.setPrefWidth(89.0);
        btn3.getStyleClass().add("btn");
        btn3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn3.setTextFill(javafx.scene.paint.Color.WHITE);

        btn4.setAlignment(javafx.geometry.Pos.CENTER);
        btn4.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn4.setId("btn5");
        btn4.setLayoutX(98.0);
        btn4.setLayoutY(117.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(81.0);
        btn4.setPrefWidth(97.0);
        btn4.getStyleClass().add("btn");
        btn4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn4.setTextFill(javafx.scene.paint.Color.WHITE);

        btn7.setAlignment(javafx.geometry.Pos.CENTER);
        btn7.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        btn7.setId("btn8");
        btn7.setLayoutX(98.0);
        btn7.setLayoutY(205.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(81.0);
        btn7.setPrefWidth(97.0);
        btn7.getStyleClass().add("btn");
        btn7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn7.setTextFill(javafx.scene.paint.Color.WHITE);

        infoPane.setId("scorePane");
        infoPane.setLayoutX(4.0);
        infoPane.setLayoutY(418.0);
        infoPane.setPrefHeight(141.0);
        infoPane.setPrefWidth(373.0);

        player_2.setAlignment(javafx.geometry.Pos.CENTER);
        player_2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        player_2.setLayoutX(276.0);
        player_2.setLayoutY(21.0);
        player_2.getStyleClass().add("xText");
        player_2.setText("X");
        player_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player_2.setTextFill(javafx.scene.paint.Color.valueOf("#e6e6e6"));
        player_2.setFont(new Font("System Bold", 40.0));

        pLayer_1.setAlignment(javafx.geometry.Pos.CENTER);
        pLayer_1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        pLayer_1.setLayoutX(36.0);
        pLayer_1.setLayoutY(19.0);
        pLayer_1.setText("O");
        pLayer_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        pLayer_1.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        pLayer_1.setFont(new Font("System Bold", 40.0));

        tieLabel.setAlignment(javafx.geometry.Pos.CENTER);
        tieLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        tieLabel.setLayoutX(175.0);
        tieLabel.setLayoutY(83.0);
        tieLabel.getStyleClass().add("scoreText");
        tieLabel.setText("Tie");
        tieLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        tieLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        tieLabel.setFont(new Font("System Bold", 18.0));

        scoreLabel_1.setAlignment(javafx.geometry.Pos.CENTER);
        scoreLabel_1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        scoreLabel_1.setLayoutX(34.0);
        scoreLabel_1.setLayoutY(76.0);
        scoreLabel_1.setText("score");
        scoreLabel_1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        scoreLabel_1.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        scoreLabel_1.setFont(new Font("System Bold", 18.0));

        scoreLabel_2.setAlignment(javafx.geometry.Pos.CENTER);
        scoreLabel_2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        scoreLabel_2.setLayoutX(271.0);
        scoreLabel_2.setLayoutY(77.0);
        scoreLabel_2.getStyleClass().add("xText");
        scoreLabel_2.setText("score");
        scoreLabel_2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        scoreLabel_2.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        scoreLabel_2.setFont(new Font("System Bold", 18.0));

        tieScoreLabel.setAlignment(javafx.geometry.Pos.CENTER);
        tieScoreLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        tieScoreLabel.setLayoutX(158.0);
        tieScoreLabel.setLayoutY(106.0);
        tieScoreLabel.getStyleClass().add("scoreText");
        tieScoreLabel.setText("tieScore");
        tieScoreLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        tieScoreLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        tieScoreLabel.setFont(new Font("System Bold", 18.0));

        statusLable.setAlignment(javafx.geometry.Pos.CENTER);
        statusLable.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        statusLable.setLayoutX(9.0);
        statusLable.setLayoutY(-14.0);
        statusLable.setPrefHeight(29.0);
        statusLable.setPrefWidth(349.0);
        statusLable.getStyleClass().add("scoreText");
//        statusLable.setText("");
        statusLable.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        statusLable.setTextFill(javafx.scene.paint.Color.valueOf("#0ecf18"));
        statusLable.setFont(new Font(20.0));

        scoreIcon.setFitHeight(58.0);
        scoreIcon.setFitWidth(151.0);
        scoreIcon.setLayoutX(159.0);
        scoreIcon.setLayoutY(18.0);
        scoreIcon.setPickOnBounds(true);
        scoreIcon.setPreserveRatio(true);
        scoreIcon.setImage(new Image(getClass().getResource("../img/score-icon-2.png").toExternalForm()));

        soundIcon.setFitHeight(30.0);
        soundIcon.setFitWidth(30.0);
        soundIcon.setLayoutX(309.0);
        soundIcon.setLayoutY(38.0);
        soundIcon.setOnMouseClicked(this::muteSound);
        soundIcon.setPickOnBounds(true);
        soundIcon.setPreserveRatio(true);
        soundIcon.setImage(new Image(getClass().getResource("../img/sound/sound_icon.png").toExternalForm()));

        playerName.setAlignment(javafx.geometry.Pos.CENTER);
        playerName.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        playerName.setId("gameTitle");
        playerName.setLayoutX(49.0);
        playerName.setLayoutY(32.0);
        playerName.setText(SignInSceneBase.p.name);
        playerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerName.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        playerName.setFont(new Font("System Bold", 12.0));
        setCenter(containerPane);

        contentPane.getChildren().add(gameTitle);
        contentPane.getChildren().add(sperateLine);
        contentPane.getChildren().add(logo);

        actionPane.getChildren().add(btn2);
        actionPane.getChildren().add(btn5);
        actionPane.getChildren().add(btn6);
        actionPane.getChildren().add(btn8);
        actionPane.getChildren().add(btn0);
        actionPane.getChildren().add(btn1);
        actionPane.getChildren().add(btn3);
        actionPane.getChildren().add(btn4);
        actionPane.getChildren().add(btn7);
        contentPane.getChildren().add(actionPane);
        infoPane.getChildren().add(player_2);
        infoPane.getChildren().add(pLayer_1);
        infoPane.getChildren().add(tieLabel);
        infoPane.getChildren().add(scoreLabel_1);
        infoPane.getChildren().add(scoreLabel_2);
        infoPane.getChildren().add(tieScoreLabel);
        infoPane.getChildren().add(statusLable);
        infoPane.getChildren().add(scoreIcon);
        contentPane.getChildren().add(infoPane);
        contentPane.getChildren().add(soundIcon);
        containerPane.getChildren().add(contentPane);
        containerPane.getChildren().add(playerName);

        actionPane.getChildren().add(lineV2);
        actionPane.getChildren().add(lineV1);
        actionPane.getChildren().add(lineH2);
        actionPane.getChildren().add(lineH1);

        btn0.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn1.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn2.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn3.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn4.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn5.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn6.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn7.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));
        btn8.setFont(Font.loadFont("file:src/fonts/BRADHITC.ttf", 42));

        EntryPoint.changeSoundImage(soundIcon);

    }

    protected void loadMenuScene(javafx.scene.input.MouseEvent mouseEvent) {
        if (HistorySceneBase.fromHistoryFlage == true) {
            MenuSceneBase ms = new MenuSceneBase();
            Scene scene = logo.getScene();
            BorderPane p = (BorderPane) scene.getRoot();
            p.setCenter(ms.containerPane);

            makeFadeOut();
        }
    }

    protected void muteSound(javafx.scene.input.MouseEvent mouseEvent) {
        EntryPoint.changeSoundStatue(soundIcon);

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
