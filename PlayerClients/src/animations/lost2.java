package animations;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class lost2 extends BorderPane {

    protected final AnchorPane anchorPane;
    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane0;
    public final Button playAgainBtn;

    public final Button exitBtn;
    protected final AnchorPane anchorPane1;
    protected final AnchorPane anchorPane2;
    protected final AnchorPane anchorPane3;

    public lost2() {

        anchorPane = new AnchorPane();
        borderPane = new BorderPane();
        anchorPane0 = new AnchorPane();
        playAgainBtn = new Button();

        exitBtn = new Button();
        anchorPane1 = new AnchorPane();
        anchorPane2 = new AnchorPane();
        anchorPane3 = new AnchorPane();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(640.0);
        setPrefWidth(600.0);
        setId("panelose");
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
        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        playAgainBtn.setLayoutX(39.0);
        playAgainBtn.setLayoutY(400.0);
        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.setPrefHeight(31.0);
        playAgainBtn.setPrefWidth(114.0);
        playAgainBtn.setText("Play Again");
        playAgainBtn.setId("btn");
        playAgainBtn.setFont(new Font(16.0));
        exitBtn.setFont(new Font(16.0));
        exitBtn.setId("btn");

        exitBtn.setLayoutX(279.0);
        exitBtn.setLayoutY(400.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(31.0001220703125);
        exitBtn.setPrefWidth(114.0);
        exitBtn.setText("Exit");
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

        anchorPane0.getChildren().add(playAgainBtn);

        anchorPane0.getChildren().add(exitBtn);

    }
}
