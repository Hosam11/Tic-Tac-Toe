package tictactoe;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class AboutSceneBase extends BorderPane {

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final Label gameTitle;
    protected final ImageView logo;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final Label label9;
    protected final Label label10;
    protected final Label label11;
    protected final Label label12;
    protected final ImageView soundIcon;

    public AboutSceneBase() {

        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        gameTitle = new Label();
        logo = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        label10 = new Label();
        label11 = new Label();
        label12 = new Label();
        soundIcon = new ImageView();


        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(578.0);
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
        containerPane.setId("contentPane");
        containerPane.setMaxWidth(USE_PREF_SIZE);
        containerPane.setMinWidth(USE_PREF_SIZE);
        containerPane.setPrefHeight(561.0);
        containerPane.setPrefWidth(382.0);

        contentPane.setLayoutX(1.0);
        contentPane.setLayoutY(2.0);
        contentPane.setPrefHeight(572.0);
        contentPane.setPrefWidth(380.0);

        gameTitle.setAlignment(javafx.geometry.Pos.CENTER);
        gameTitle.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        gameTitle.setId("gameTitle");
        gameTitle.setLayoutX(46.0);
        gameTitle.setLayoutY(11.0);
        gameTitle.setText("About Us");
        gameTitle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameTitle.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        gameTitle.setFont(new Font("System Bold", 12.0));

        logo.setFitHeight(46.0);
        logo.setFitWidth(40.0);
        logo.setOnMouseClicked(this::loadHomeScene);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        logo.setImage(new Image(getClass().getResource("../img/logo/icon.png").toExternalForm()));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(11.0);
        label.setLayoutY(100.0);
        label.setText("Team Members:");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        label.setFont(new Font("System Bold", 16.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setLayoutX(32.0);
        label0.setLayoutY(135.0);
        label0.setPrefHeight(19.0);
        label0.setPrefWidth(300.0);
        label0.setText("Hossam");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        label0.setFont(new Font("System Bold", 13.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setLayoutX(28.0);
        label1.setLayoutY(160.0);
        label1.setPrefHeight(19.0);
        label1.setPrefWidth(302.0);
        label1.setText("Hagar");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        label1.setFont(new Font("System Bold", 13.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label2.setLayoutX(30.0);
        label2.setLayoutY(188.0);
        label2.setPrefHeight(19.0);
        label2.setPrefWidth(302.0);
        label2.setText("Marwa");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        label2.setFont(new Font("System Bold", 13.0));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label3.setLayoutX(29.0);
        label3.setLayoutY(213.0);
        label3.setPrefHeight(19.0);
        label3.setPrefWidth(302.0);
        label3.setText("Mohammed");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        label3.setFont(new Font("System Bold", 13.0));

        label4.setLayoutX(14.0);
        label4.setLayoutY(292.0);
        label4.setText("How to Play:");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        label4.setFont(new Font("System Bold", 16.0));

        label5.setAlignment(javafx.geometry.Pos.CENTER);
        label5.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label5.setLayoutX(29.0);
        label5.setLayoutY(239.0);
        label5.setPrefHeight(19.0);
        label5.setPrefWidth(302.0);
        label5.setText("Yassmine");
        label5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        label5.setFont(new Font("System Bold", 13.0));

        label6.setLayoutX(28.0);
        label6.setLayoutY(317.0);
        label6.setText("1. The game is played on a grid that's 3 squares by 3 squares.");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#c3c3c3"));

        label7.setLayoutX(28.0);
        label7.setLayoutY(341.0);
        label7.setText("2. You are X, your friend (or the computer in this case) is O. ");
        label7.setTextFill(javafx.scene.paint.Color.valueOf("#c3c3c3"));

        label8.setLayoutX(41.0);
        label8.setLayoutY(354.0);
        label8.setText("Players take turns putting their marks in empty squares.");
        label8.setTextFill(javafx.scene.paint.Color.valueOf("#c3c3c3"));

        label9.setLayoutX(28.0);
        label9.setLayoutY(376.0);
        label9.setText("3. The first player to get 3 of her marks in a row ");
        label9.setTextFill(javafx.scene.paint.Color.valueOf("#c3c3c3"));

        label10.setLayoutX(41.0);
        label10.setLayoutY(387.0);
        label10.setText("(up, down, across, or diagonally) is the winner.");
        label10.setTextFill(javafx.scene.paint.Color.valueOf("#c3c3c3"));

        label11.setLayoutX(28.0);
        label11.setLayoutY(410.0);
        label11.setText("4. When all 9 squares are full, the game is over. ");
        label11.setTextFill(javafx.scene.paint.Color.valueOf("#c3c3c3"));

        label12.setLayoutX(41.0);
        label12.setLayoutY(421.0);
        label12.setText("If no player has 3 marks in a row, the game ends in a tie.");
        label12.setTextFill(javafx.scene.paint.Color.valueOf("#c3c3c3"));

        soundIcon.setFitHeight(30.0);
        soundIcon.setFitWidth(30.0);
        soundIcon.setLayoutX(315.0);
        soundIcon.setLayoutY(52.0);
        soundIcon.setOnMouseClicked(this::muteSound);
        soundIcon.setPickOnBounds(true);
        soundIcon.setPreserveRatio(true);
        soundIcon.setImage(new Image(getClass().getResource("../img/sound/sound_icon.png").toExternalForm()));
        setCenter(containerPane);

        contentPane.getChildren().add(gameTitle);
        contentPane.getChildren().add(logo);
        contentPane.getChildren().add(label);
        contentPane.getChildren().add(label0);
        contentPane.getChildren().add(label1);
        contentPane.getChildren().add(label2);
        contentPane.getChildren().add(label3);
        contentPane.getChildren().add(label4);
        contentPane.getChildren().add(label5);
        contentPane.getChildren().add(label6);
        contentPane.getChildren().add(label7);
        contentPane.getChildren().add(label8);
        contentPane.getChildren().add(label9);
        contentPane.getChildren().add(label10);
        contentPane.getChildren().add(label11);
        contentPane.getChildren().add(label12);
        contentPane.getChildren().add(soundIcon);
        containerPane.getChildren().add(contentPane);
        
                EntryPoint.changeSoundImage(soundIcon);


    }

    protected void loadHomeScene(javafx.scene.input.MouseEvent mouseEvent) {
        MenuSceneBase ms = new MenuSceneBase();
        Scene scene = logo.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(ms.containerPane);

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

}
