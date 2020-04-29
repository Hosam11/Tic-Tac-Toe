package tictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class SignInSceneBase extends BorderPane {

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final TextField usrNameField;
    protected final Glow glow;
    protected final PasswordField passwdField;
    protected final Glow glow0;
    protected final Label label;
    protected final Button signInBtn;
    protected final Label createAccountLabel;
    protected final ImageView logo;
    static PlayerData p = new PlayerData();

    public SignInSceneBase() {

        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        usrNameField = new TextField();
        glow = new Glow();
        passwdField = new PasswordField();
        glow0 = new Glow();
        label = new Label();
        signInBtn = new Button();
        createAccountLabel = new Label();
        logo = new ImageView();

        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(580.0);
        setPrefWidth(600.0);
        getStylesheets().add("/FXMLs/../css/styles.css");

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
        containerPane.getStylesheets().add("/FXMLs/../css/styles.css");

        contentPane.setId("contentPane");
        contentPane.setLayoutX(-1.0);
        contentPane.setPrefHeight(647.0);
        contentPane.setPrefWidth(383.0);
        contentPane.getStylesheets().add("/FXMLs/../css/styles.css");

        usrNameField.setLayoutX(101.0);
        usrNameField.setLayoutY(220.0);
        usrNameField.setPrefHeight(25.0);
        usrNameField.setPrefWidth(200.0);
        usrNameField.setPromptText("Username");
        usrNameField.getStyleClass().add("txtfield");
        usrNameField.getStylesheets().add("/FXMLs/../css/styles.css");

        usrNameField.setEffect(glow);
        usrNameField.setFont(new Font("System Bold", 13.0));

        passwdField.setLayoutX(99.0);
        passwdField.setLayoutY(284.0);
        passwdField.setStyle(" -fx-border-radius: 10 10 10 10;     -fx-background-radius: 10 10 10 10;     -fx-text-fill: black;     /*-fx-background-color: -fx-text-box-border, -fx-background ;*/     -fx-background-insets: 0, 0 0 1 0 ;     /*-fx-background-color: #93bcda;*/     -fx-background-color: #c3c3c3;     -fx-prompt-text-fill: white;");
        passwdField.getStyleClass().add("txtfield");
        passwdField.getStylesheets().add("/FXMLs/../css/styles.css");
        passwdField.setCursor(Cursor.HAND);
        passwdField.setPrefHeight(25.0);
        passwdField.setPrefWidth(200.0);

        passwdField.setEffect(glow0);
        passwdField.setFont(new Font("System Bold", 13.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(25.0);
        label.setLayoutY(112.0);
        label.setMaxHeight(USE_PREF_SIZE);
        label.setMaxWidth(USE_PREF_SIZE);
        label.setMinHeight(USE_PREF_SIZE);
        label.setMinWidth(USE_PREF_SIZE);
        label.setPrefHeight(35.0);
        label.setPrefWidth(321.0);
        label.getStylesheets().add("/FXMLs/../css/styles.css");
        label.setText("Let's Get Started !");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        label.setFont(new Font("System Bold", 32.0));

        signInBtn.setAlignment(javafx.geometry.Pos.CENTER);
        signInBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        signInBtn.setLayoutX(131.0);
        signInBtn.setLayoutY(381.0);
        signInBtn.setMnemonicParsing(false);
        signInBtn.setOnAction(this::loadMenuScene);
        signInBtn.setPrefHeight(25.0);
        signInBtn.setPrefWidth(133.0);
        signInBtn.getStyleClass().add("options");
        signInBtn.getStylesheets().add("/FXMLs/../css/styles.css");
        signInBtn.setText("Sign in");
        signInBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signInBtn.setFont(new Font("System Bold", 12.0));

        createAccountLabel.setLayoutX(140.0);
        createAccountLabel.setLayoutY(493.0);
        createAccountLabel.setOnMouseClicked(this::loadSignUpScene);
        createAccountLabel.setText("Create a new account ");
        createAccountLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        createAccountLabel.setTextFill(javafx.scene.paint.Color.valueOf("#73c2fb"));
        createAccountLabel.setUnderline(true);

        logo.setFitHeight(60.0);
        logo.setFitWidth(60.0);
        logo.setLayoutX(159.0);
        logo.setLayoutY(52.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        logo.setImage(new Image(getClass().getResource("../img/logo/icon.png").toExternalForm()));
        setCenter(containerPane);

        contentPane.getChildren().add(usrNameField);
        contentPane.getChildren().add(passwdField);
        contentPane.getChildren().add(label);
        contentPane.getChildren().add(signInBtn);
        contentPane.getChildren().add(createAccountLabel);
        contentPane.getChildren().add(logo);
        containerPane.getChildren().add(contentPane);

    }

    protected void loadMenuScene(javafx.event.ActionEvent actionEvent) {
        
        try {
            String username = usrNameField.getText();
            String psswrd = passwdField.getText();
            System.out.println("Connected!");
            // get the output stream from the socket.
//            Socket socket = new Socket("172.16.4.13", 6000);
            Socket socket = new Socket("localhost", 6000);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            System.out.println("Sending string to the ServerSocket");
            // write the message we want to send
            dataOutputStream.writeUTF(username + "_" + psswrd + "_IN");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String message = dataInputStream.readUTF();
            System.out.println("The message sent from the socket was: " + message);
            dataOutputStream.flush(); // send the message
            dataOutputStream.close(); // close the output stream when we're done.
            socket.close();
            if (message.equalsIgnoreCase("NO ENTRY")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("signin failed");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a unique username and a password");
                alert.showAndWait();

            } else if (!message.equalsIgnoreCase("NOT FOUND")&& !message.equalsIgnoreCase("NO ENTRY")) {
                System.out.println("signin");
                List<String> Data = new ArrayList<String>();
                Collections.addAll(Data, message.split("_"));
                System.out.println(Data);
                p.name = Data.get(0);

                System.out.println("pname=" + p.name);

                p.score = Data.get(1);
                System.out.println("score=" + p.score);
                int x = 2;
                while (x < Data.size()) {
                    String game = Data.get(x);
                    List<String> GData = new ArrayList<String>();
                    Collections.addAll(GData, game.split(","));
                    System.out.println("GDATA ID = " + GData.get(0));
                    System.out.println("GDATA ID = " + GData.get(0));
                    System.out.println("GDATA p1 = " + GData.get(1));
                    System.out.println("GDATA p2 = " + GData.get(2));
                    System.out.println("GDATA winner = " + GData.get(3));
                    p.Games.add(game);
                    
//                    p.Games.add(Models.ModelTable()
                    x++;

                  //  System.out.println("gameId" + GID);

                }
                p.PrintPlayer();
                MenuSceneBase ms = new MenuSceneBase();
                Scene scene = signInBtn.getScene();
                BorderPane pane = (BorderPane) scene.getRoot();
                pane.setCenter(ms.containerPane);

                makeFadeOut();

            } else {
                System.out.println("not found in else");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("siginin failed");
                alert.setHeaderText(null);
                alert.setContentText("username or password is incorrect please check your entries");
                alert.showAndWait();
            }
        } catch (IOException ex) {
            Logger.getLogger(SignInSceneBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void loadSignUpScene(javafx.scene.input.MouseEvent mouseEvent) {
        SignUpSceneBase signUp = new SignUpSceneBase();
        Scene scene = createAccountLabel.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(signUp.containerPane);

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
