/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author pc
 */
public class PlayerVSPlayer {

    GameSceneBase mainStage;
    int turnFlag = 0;
    int oScore, xScore, tieScore = 0;
    int isWinner = -1; // 0 for player 2 - 1 for player 1   -  -1 for draw 
    String finalResult;

    MenuSceneBase homeScene = new MenuSceneBase();

    public PlayerVSPlayer(GameSceneBase gameSceneBase) {

        mainStage = gameSceneBase;
        System.out.println("from cons local player");
        mainStage.scoreLabel_1.setText(Integer.toString(oScore));
        mainStage.scoreLabel_2.setText(Integer.toString(xScore));
        mainStage.tieScoreLabel.setText(Integer.toString(tieScore));
        mainStage.pLayer_1.setText("Player 1");
        mainStage.pLayer_1.setStyle("-fx-font-size: 20px; -fx-font-style:bold;");

        mainStage.player_2.setText("Player 2");
        mainStage.player_2.setStyle("-fx-font-size: 20px; -fx-font-style:bold;");

        mainStage.logo.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are You Sure", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Scene s = new Scene(homeScene);
                EntryPoint.myStage.setScene(s);
            }
        });

        mainStage.btn8.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn9");
                setTurn();
                if (mainStage.btn8.getText() == "") {
                    mainStage.btn8.setText(getTurn());
                    mainStage.btn8.setDisable(true);
                    checkWinner();
                }

            }

        }
        );

        mainStage.btn0.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn1");
                setTurn();
                if (mainStage.btn0.getText() == "") {
                    mainStage.btn0.setText(getTurn());
                    mainStage.btn0.setDisable(true);
                    checkWinner();
                }
//                System.out.println(turnFlag);

            }

        }
        );

        mainStage.btn1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn2");
                if (mainStage.btn1.getText() == "") {
                    setTurn();
                    mainStage.btn1.setText(getTurn());
                    mainStage.btn1.setDisable(true);
                    checkWinner();
                }
            }
        });

        mainStage.btn2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn3");
                setTurn();
                if (mainStage.btn2.getText() == "") {
                    mainStage.btn2.setText(getTurn());
                    mainStage.btn2.setDisable(true);
                    checkWinner();
                }
            }
        }
        );

        mainStage.btn3.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn4");
                setTurn();
                if (mainStage.btn3.getText() == "") {
                    mainStage.btn3.setText(getTurn());
                    mainStage.btn3.setDisable(true);
                    checkWinner();
                }

            }

        }
        );

        mainStage.btn4.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn5");
                setTurn();
                if (mainStage.btn4.getText() == "") {
                    mainStage.btn4.setText(getTurn());
                    mainStage.btn4.setDisable(true);
                    checkWinner();
                }

            }

        }
        );

        mainStage.btn5.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn6");
                setTurn();
                if (mainStage.btn5.getText() == "") {
                    mainStage.btn5.setText(getTurn());
                    mainStage.btn5.setDisable(true);
                    checkWinner();
                }

            }

        }
        );

        mainStage.btn6.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn7");
                setTurn();
                if (mainStage.btn6.getText() == "") {
                    mainStage.btn6.setText(getTurn());
                    mainStage.btn6.setDisable(true);
                    checkWinner();
                }

            }

        }
        );

        mainStage.btn7.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn8");

                setTurn();
                if (mainStage.btn7.getText() == "") {
                    mainStage.btn7.setText(getTurn());
                    mainStage.btn7.setDisable(true);
                    checkWinner();
                }
            }

        }
        );

    }

    public void checkWinner() {

        if (mainStage.btn0.getText() == "X" && mainStage.btn3.getText() == "X" && mainStage.btn6.getText() == "X") {
            System.out.println("X is the winner");
            xScore++;
            isWinner = 0;

            endGame();
        }
        if (mainStage.btn0.getText() == "O" && mainStage.btn3.getText() == "O" && mainStage.btn6.getText() == "O") {
            System.out.println("O is the winner");
            oScore++;
            isWinner = 1;
            endGame();

        }

        ///////////////////////////////////////////////////////////////////
        if (mainStage.btn1.getText() == "X" && mainStage.btn4.getText() == "X" && mainStage.btn7.getText() == "X") {
            System.out.println("X is the winner");
            xScore++;
            isWinner = 0;
            endGame();
        }
        if (mainStage.btn1.getText() == "O" && mainStage.btn4.getText() == "O" && mainStage.btn7.getText() == "O") {
            System.out.println("O is the winner");
            oScore++;
            isWinner = 1;
            endGame();
        }
        ///////////////////////////////////////////////////////////////////////
        if (mainStage.btn2.getText() == "X" && mainStage.btn5.getText() == "X" && mainStage.btn8.getText() == "X") {
            System.out.println("X is the winner");
            xScore++;
            isWinner = 0;
            endGame();
        }
        if (mainStage.btn2.getText() == "O" && mainStage.btn5.getText() == "O" && mainStage.btn8.getText() == "O") {
            System.out.println("O is the winner");
            oScore++;
            isWinner = 1;
            endGame();
        }

        if (mainStage.btn2.getText() == "X" && mainStage.btn4.getText() == "X" && mainStage.btn6.getText() == "X") {
            System.out.println("X is the winner");
            xScore++;
            isWinner = 0;
            endGame();
        }
        if (mainStage.btn2.getText() == "O" && mainStage.btn4.getText() == "O" && mainStage.btn6.getText() == "O") {
            System.out.println("O is the winner");
            oScore++;
            isWinner = 1;
            endGame();
        }

        //////////////////////////////////////////////////
        if (mainStage.btn0.getText() == "X" && mainStage.btn4.getText() == "X" && mainStage.btn8.getText() == "X") {
            System.out.println("X is the winner");
            isWinner = 0;
            xScore++;
            endGame();
        }
        if (mainStage.btn0.getText() == "O" && mainStage.btn4.getText() == "O" && mainStage.btn8.getText() == "O") {
            System.out.println("O is the winner");
            oScore++;
            isWinner = 1;
            endGame();
        }

        if (mainStage.btn0.getText() == "X" && mainStage.btn1.getText() == "X" && mainStage.btn2.getText() == "X") {
            System.out.println("X is the winner");
            xScore++;
            isWinner = 0;
            endGame();
        }
        if (mainStage.btn0.getText() == "O" && mainStage.btn1.getText() == "O" && mainStage.btn2.getText() == "O") {

            System.out.println("O is the winner");
            isWinner = 1;
            oScore++;
            endGame();
        }

        ////////////////////////////////////
        if (mainStage.btn3.getText() == "X" && mainStage.btn4.getText() == "X" && mainStage.btn5.getText() == "X") {
            System.out.println("X is the winner");
            isWinner = 0;
            xScore++;
            endGame();
        }
        if (mainStage.btn3.getText() == "O" && mainStage.btn4.getText() == "O" && mainStage.btn5.getText() == "O") {
            System.out.println("O is the winner");
            isWinner = 1;
            oScore++;
            endGame();
        }
        ///////////////////////////////////////////
        if (mainStage.btn6.getText() == "X" && mainStage.btn7.getText() == "X" && mainStage.btn8.getText() == "X") {
            System.out.println("X is the winner");
            isWinner = 0;
            xScore++;
            endGame();
        }
        if (mainStage.btn6.getText() == "O" && mainStage.btn7.getText() == "O" && mainStage.btn8.getText() == "O") {
            System.out.println("O is the winner");
            isWinner = 1;
            oScore++;
            endGame();
        }

        if (mainStage.btn0.getText() != "" && mainStage.btn1.getText() != "" && mainStage.btn2.getText() != "" && mainStage.btn3.getText() != "" && mainStage.btn4.getText() != "" && mainStage.btn5.getText() != "" && mainStage.btn6.getText() != "" && mainStage.btn7.getText() != "" && mainStage.btn8.getText() != "") {
            isWinner = -1;
            tieScore++;
            endGame();
        }

    }

    public void resetGame() {
        mainStage.btn8.setDisable(false);
        mainStage.btn0.setDisable(false);
        mainStage.btn1.setDisable(false);
        mainStage.btn2.setDisable(false);
        mainStage.btn3.setDisable(false);
        mainStage.btn4.setDisable(false);
        mainStage.btn5.setDisable(false);
        mainStage.btn6.setDisable(false);
        mainStage.btn7.setDisable(false);

        mainStage.btn0.setText("");
        mainStage.btn1.setText("");
        mainStage.btn2.setText("");
        mainStage.btn3.setText("");
        mainStage.btn4.setText("");
        mainStage.btn5.setText("");
        mainStage.btn6.setText("");
        mainStage.btn7.setText("");
        mainStage.btn8.setText("");

    }

    public void endGame() {

        mainStage.btn8.setDisable(true);
        mainStage.btn0.setDisable(true);
        mainStage.btn1.setDisable(true);
        mainStage.btn2.setDisable(true);
        mainStage.btn3.setDisable(true);
        mainStage.btn4.setDisable(true);
        mainStage.btn5.setDisable(true);
        mainStage.btn6.setDisable(true);
        mainStage.btn7.setDisable(true);

        mainStage.scoreLabel_1.setText(Integer.toString(oScore));
        mainStage.scoreLabel_2.setText(Integer.toString(xScore));
        mainStage.tieScoreLabel.setText(Integer.toString(tieScore));

        switch (isWinner) {
            case 1:
                finalResult = "Player 1 is the winner - Cheers \n";
                break;
            case 0:
                finalResult = "Player 2 is the winner - Cheers \n";
                break;

            case -1:
                finalResult = "Tough Draw \n";

                break;

        }

        Alert alert = new Alert(AlertType.CONFIRMATION,
                finalResult + "would you like to play again ?",
                ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            //do stuff
            resetGame();
            turnFlag = 0;
        }

        if (alert.getResult() == ButtonType.NO) {
            //do stuff
            System.out.println("Exiting");
            Scene s = new Scene(homeScene);
            EntryPoint.myStage.setScene(s);

        }

    }

    public void setTurn() {

        if (turnFlag == 0) {
            turnFlag = 1;
        } else {
            turnFlag = 0;
        }
    }

    public String getTurn() {
        if (turnFlag == 0) {
            return "X";
        } else {
            return "O";
        }

    }

    //Scene scene = new Scene(mainStage);
}
