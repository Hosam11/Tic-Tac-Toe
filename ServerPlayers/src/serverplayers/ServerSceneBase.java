package serverplayers;



import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ServerSceneBase extends BorderPane {

    protected final AnchorPane containerPane;
    protected final TextArea textArea;

    public ServerSceneBase() {

        containerPane = new AnchorPane();
        textArea = new TextArea();

        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(246.0);
        setPrefWidth(385.0);
        setStyle("-fx-background-color: black;");

        BorderPane.setAlignment(containerPane, javafx.geometry.Pos.CENTER);
        containerPane.setId("containerPane");
        containerPane.setMaxHeight(USE_PREF_SIZE);
        containerPane.setMaxWidth(USE_PREF_SIZE);
        containerPane.setMinHeight(USE_PREF_SIZE);
        containerPane.setMinWidth(USE_PREF_SIZE);
        containerPane.setPrefHeight(254.0);
        containerPane.setPrefWidth(382.0);
        containerPane.getStylesheets().add("/css/styles.css");

        textArea.setPrefHeight(254.0);
        textArea.setPrefWidth(383.0);
        textArea.setStyle("-fx-control-inner-background:#000000; -fx-font-family: Consolas; -fx-highlight-fill: #00ff00; -fx-highlight-text-fill: #000000; -fx-text-fill: #00ff00; ");
        setCenter(containerPane);

        containerPane.getChildren().add(textArea);
        
        textArea.setEditable(false);
    }
}
