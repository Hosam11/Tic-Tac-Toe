package alerts;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class Alert2BtnSceneBase extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane0;
    protected final Button cencelBtn;
    protected final Button okBtn;
    protected final Label label;
    protected final AnchorPane anchorPane1;
    protected final AnchorPane anchorPane2;
    protected final AnchorPane anchorPane3;

    public Alert2BtnSceneBase() {

        anchorPane = new AnchorPane();
        borderPane = new BorderPane();
        anchorPane0 = new AnchorPane();
        cencelBtn = new Button();
        okBtn = new Button();
        label = new Label();
        anchorPane1 = new AnchorPane();
        anchorPane2 = new AnchorPane();
        anchorPane3 = new AnchorPane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(90.0);
        anchorPane.setPrefWidth(600.0);
        setBottom(anchorPane);

        BorderPane.setAlignment(borderPane, javafx.geometry.Pos.CENTER);
        borderPane.setMaxHeight(USE_PREF_SIZE);
        borderPane.setMaxWidth(USE_PREF_SIZE);
        borderPane.setPrefHeight(260.0);
        borderPane.setPrefWidth(300.0);

        BorderPane.setAlignment(anchorPane0, javafx.geometry.Pos.CENTER);
        anchorPane0.setMaxHeight(USE_PREF_SIZE);
        anchorPane0.setMaxWidth(USE_PREF_SIZE);
        anchorPane0.setMinHeight(148.0);
        anchorPane0.setMinWidth(186.0);
        anchorPane0.setPrefHeight(244.0);
        anchorPane0.setPrefWidth(282.0);
        anchorPane0.setStyle("-fx-background-color: white;");

        cencelBtn.setLayoutX(154.0);
        cencelBtn.setLayoutY(185.0);
        cencelBtn.setMnemonicParsing(false);
        cencelBtn.setPrefHeight(31.0);
        cencelBtn.setPrefWidth(114.0);
        cencelBtn.setStyle("-fx-background-color: #8bc0ec; -fx-border-radius: 10 10 10 10; -fx-background-radius: 10 10 10 10;");
        cencelBtn.setText("Cancel");
        cencelBtn.setFont(new Font("System Bold", 16.0));

        okBtn.setAlignment(javafx.geometry.Pos.CENTER);
        okBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        okBtn.setLayoutX(14.0);
        okBtn.setLayoutY(185.0);
        okBtn.setMnemonicParsing(false);
        okBtn.setPrefHeight(31.0);
        okBtn.setPrefWidth(114.0);
        okBtn.setStyle("-fx-background-color: #8bc0ec; -fx-border-radius: 10 10 10 10; -fx-background-radius: 10 10 10 10;");
        okBtn.setText("Ok");
        okBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        okBtn.setFont(new Font("System Bold", 16.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutY(78.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(283.0);
        label.setText("Label");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font(16.0));
        borderPane.setCenter(anchorPane0);
        setCenter(borderPane);

        BorderPane.setAlignment(anchorPane1, javafx.geometry.Pos.CENTER);
        anchorPane1.setPrefHeight(220.0);
        anchorPane1.setPrefWidth(150.0);
        setLeft(anchorPane1);

        BorderPane.setAlignment(anchorPane2, javafx.geometry.Pos.CENTER);
        anchorPane2.setPrefHeight(220.0);
        anchorPane2.setPrefWidth(150.0);
        setRight(anchorPane2);

        BorderPane.setAlignment(anchorPane3, javafx.geometry.Pos.CENTER);
        anchorPane3.setPrefHeight(52.0);
        anchorPane3.setPrefWidth(600.0);
        setTop(anchorPane3);

        anchorPane0.getChildren().add(cencelBtn);
        anchorPane0.getChildren().add(okBtn);
        anchorPane0.getChildren().add(label);

    }
}
