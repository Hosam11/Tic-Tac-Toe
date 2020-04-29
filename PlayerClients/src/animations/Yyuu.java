/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animations;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yasmine Dwedar
 */
public class Yyuu extends Application {
    
    

    @Override
    public void start(Stage stage) throws Exception {
        stage.setMinHeight(560);
        stage.setMinWidth(600);

        Won win = new Won();
  
        lost2 lose = new lost2();
        DrawBase draw = new DrawBase();
        Parent root = win;
        Scene scene = new Scene(lose);
        scene.getStylesheets().addAll(getClass().getResource("StyleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        
        win.playAgainBtn.setOnAction((event) -> {
            System.out.println("clicked");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
