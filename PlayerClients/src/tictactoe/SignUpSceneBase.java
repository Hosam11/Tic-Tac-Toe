package tictactoe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
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

public class SignUpSceneBase extends BorderPane {

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final TextField usrNameField;
    protected final Glow glow;
    protected final PasswordField passwdField;
    protected final Glow glow0;
    protected final Label titleLabel;
    protected final Button signUpBtn;
    protected final Label haveAccountLabel;
    protected final ImageView logo;

    public SignUpSceneBase() {

        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        usrNameField = new TextField();
        glow = new Glow();
        passwdField = new PasswordField();
        glow0 = new Glow();
        titleLabel = new Label();
        signUpBtn = new Button();
        haveAccountLabel = new Label();
        logo = new ImageView();

        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(578.0);
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
        containerPane.setId("contentPane");
        containerPane.setMaxWidth(USE_PREF_SIZE);
        containerPane.setMinWidth(USE_PREF_SIZE);
        containerPane.setPrefHeight(561.0);
        containerPane.setPrefWidth(382.0);

        contentPane.setId("contentPane");
        contentPane.setLayoutX(-9.0);
        contentPane.setMaxWidth(USE_PREF_SIZE);
        contentPane.setMinWidth(USE_PREF_SIZE);
        contentPane.setPrefHeight(600.0);
        contentPane.setPrefWidth(393.0);

        usrNameField.setLayoutX(90.0);
        usrNameField.setLayoutY(228.0);
        usrNameField.setPrefHeight(25.0);
        usrNameField.setPrefWidth(200.0);
        usrNameField.setPromptText("Name");
        usrNameField.getStyleClass().add("txtfield");
        usrNameField.getStylesheets().add("/FXMLs/../css/styles.css");

        usrNameField.setEffect(glow);
        usrNameField.setFont(new Font("System Bold", 13.0));
        usrNameField.setCursor(Cursor.TEXT);

        passwdField.setLayoutX(90.0);
        passwdField.setLayoutY(289.0);
        passwdField.getStyleClass().add("txtfield");
        passwdField.getStylesheets().add("/FXMLs/../css/styles.css");
        passwdField.setCursor(Cursor.TEXT);
          passwdField.setPrefHeight(25.0);
        passwdField.setPrefWidth(200.0);

        passwdField.setEffect(glow0);
        passwdField.setFont(new Font("System Bold", 13.0));

        titleLabel.setAlignment(javafx.geometry.Pos.CENTER);
        titleLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        titleLabel.setLayoutX(23.0);
        titleLabel.setLayoutY(123.0);
        titleLabel.setPrefHeight(38.0);
        titleLabel.setPrefWidth(346.0);
        titleLabel.getStylesheets().add("/FXMLs/../css/styles.css");
        titleLabel.setText("CREATE NEW ACCOUNT !");
        titleLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        titleLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        titleLabel.setFont(new Font("System Bold", 26.0));

        signUpBtn.setAlignment(javafx.geometry.Pos.CENTER);
        signUpBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        signUpBtn.setLayoutX(121.0);
        signUpBtn.setLayoutY(418.0);
        signUpBtn.setMnemonicParsing(false);
        signUpBtn.setOnAction(this::loadHomeScene);
        signUpBtn.setPrefHeight(25.0);
        signUpBtn.setPrefWidth(133.0);
        signUpBtn.setStyle("-fx-background-color: transperent; -fx-border-color: #8bc0ec;");
        signUpBtn.getStyleClass().add("options");
        signUpBtn.getStylesheets().add("/FXMLs/../css/styles.css");
        signUpBtn.setText("Sign Up");
        signUpBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        signUpBtn.setTextFill(javafx.scene.paint.Color.valueOf("#8bc0ec"));
        signUpBtn.setFont(new Font("System Bold", 12.0));
        signUpBtn.setCursor(Cursor.HAND);

        haveAccountLabel.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        haveAccountLabel.setAlignment(javafx.geometry.Pos.CENTER);
        haveAccountLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        haveAccountLabel.setLayoutX(118.0);
        haveAccountLabel.setLayoutY(502.0);
        haveAccountLabel.setOnMouseClicked(this::loadSingInScene);
        haveAccountLabel.setText("Already have an account ?");
        haveAccountLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        haveAccountLabel.setTextFill(javafx.scene.paint.Color.valueOf("#73c2fb"));
        haveAccountLabel.setUnderline(true);

        AnchorPane.setBottomAnchor(logo, 491.9544359842936);
        AnchorPane.setLeftAnchor(logo, 161.0);
        AnchorPane.setRightAnchor(logo, 172.33333333333331);
        AnchorPane.setTopAnchor(logo, 57.0);
        logo.setFitHeight(60.0);
        logo.setFitWidth(60.0);
        logo.setId("homeIcon");
        logo.setLayoutX(161.0);
        logo.setLayoutY(57.0);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        logo.setImage(new Image(getClass().getResource("../img/logo/icon.png").toExternalForm()));
        setCenter(containerPane);

        contentPane.getChildren().add(usrNameField);
        contentPane.getChildren().add(passwdField);
        contentPane.getChildren().add(titleLabel);
        contentPane.getChildren().add(signUpBtn);
        contentPane.getChildren().add(haveAccountLabel);
        contentPane.getChildren().add(logo);
        containerPane.getChildren().add(contentPane);

    }

  protected void loadHomeScene(javafx.event.ActionEvent actionEvent){
     try {
            String username = usrNameField.getText();
            String psswrd = passwdField.getText();
//            Socket socket = new Socket("172.16.4.13", 6000);
            Socket socket = new Socket("localhost", 6000);
            System.out.println("Connected!");
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            System.out.println("Sending string to the ServerSocket");
            // write the message we want to send
            dataOutputStream.writeUTF(username + "_" + psswrd + "_UP");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String message = dataInputStream.readUTF();
            System.out.println("The message sent from the socket was: " + message);
            dataOutputStream.flush(); // send the message
            dataOutputStream.close(); // close the output stream when we're done.
            socket.close();
            if (message.equalsIgnoreCase("NO ENTRY")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("signup failed");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a unique username and a password");
                alert.showAndWait();
                
            
            }
            else if (!message.equalsIgnoreCase("ALREADY EXISTS") && !message.equalsIgnoreCase("NO ENTRY")) {
                System.out.println("signup");
               // PlayerData p = new PlayerData();
                SignInSceneBase.p.name = message;
         
                 System.out.println("pname="+SignInSceneBase.p.name);
      
                SignInSceneBase.p.score="0";
                System.out.println("score=" +SignInSceneBase.p.score);
             SignInSceneBase.p.PrintPlayer();
               MenuSceneBase ms = new MenuSceneBase();   
        Scene scene = signUpBtn.getScene();
        BorderPane pane = (BorderPane) scene.getRoot();
        pane.setCenter(ms.containerPane);
        
        makeFadeOut();
           

        }
             else {
                //Alert no user check your entries
                
                  System.out.println("already exists in else");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("signup failed");
                alert.setHeaderText(null);
                alert.setContentText("username already exists please enter a unique name");
                alert.showAndWait();
            }
          }
         catch (IOException ex) {
            Logger.getLogger(tictactoe.SignUpSceneBase.class.getName()).log(Level.SEVERE, null, ex);
        }
       }

  protected void loadSingInScene(javafx.scene.input.MouseEvent mouseEvent){
        SignInSceneBase signIn = new SignInSceneBase();
        Scene scene = haveAccountLabel.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(signIn.containerPane);
        
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
