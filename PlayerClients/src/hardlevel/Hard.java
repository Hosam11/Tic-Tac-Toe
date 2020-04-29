/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardlevel;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import tictactoe.EntryPoint;
import tictactoe.GameSceneBase;
import tictactoe.MenuSceneBase;

public class Hard {

    Button[][] board = new Button[3][3];

    int moveNum = 0;
    HardLevel.Move bestMove;
    int oScore, xScore, tieScore = 0;

    GameSceneBase mainStage = new GameSceneBase();

    Scene scene = new Scene(mainStage);

    MenuSceneBase homeScene = new MenuSceneBase();

    public Hard(GameSceneBase gameSceneScene) {
        mainStage = gameSceneScene;
        mainStage.logo.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are You Sure", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Scene s = new Scene(homeScene);
                EntryPoint.myStage.setScene(s);
            }

        });

        mainStage.scoreLabel_2.setText(Integer.toString(xScore));
        mainStage.scoreLabel_1.setText(Integer.toString(oScore));

        board[0][0] = mainStage.btn0;
        board[0][1] = mainStage.btn1;
        board[0][2] = mainStage.btn2;
        board[1][0] = mainStage.btn3;
        board[1][1] = mainStage.btn4;
        board[1][2] = mainStage.btn5;
        board[2][0] = mainStage.btn6;
        board[2][1] = mainStage.btn7;
        board[2][2] = mainStage.btn8;

        for (Button[] btns : board) {
            for (Button btn : btns) {

                btn.addEventHandler(ActionEvent.ACTION, (ActionEvent event) -> {

                    btn.setText("O");
                    System.out.println("xxx");
                    btn.setMouseTransparent(true);
                    if (moveNum + 1 < 9) {
                        bestMove = HardLevel.findBestMove(board);
                        board[bestMove.row][bestMove.col].setText("X");
                        board[bestMove.row][bestMove.col].setMouseTransparent(true);
                    }

                    moveNum += 2;
                    if (moveNum >= 5) {

                        int result = Evaluation.evaluate(board);
                        if (result == 10) {
                            System.out.println("You lost :(");
                            // edit 

                            xScore++;
                            System.out.println("the x score is" + xScore);

                            mainStage.scoreLabel_2.setText(Integer.toString(xScore));
                            mainStage.scoreLabel_1.setText(Integer.toString(oScore));

                            gameAgin("You lost would you like to play again ? ");

                        } else if (result == -10) {
                            System.out.println("You won ^^");
                            // edit 
                            oScore++;
                            mainStage.scoreLabel_1.setText(Integer.toString(oScore));
                            gameAgin("Congratulation would you like to play again ?");
                            System.out.println(oScore);
                            //

                        } else if (HardLevel.isMoveLeft(board) == false) {
                            System.out.println("No One Wins !");
                            tieScore++;
                            mainStage.tieScoreLabel.setText(Integer.toString(tieScore));
                            gameAgin("No One Wins ! would you like to play again ?");

                            System.out.println("tie score " + tieScore);
                        }
                    }
                });
            }
        }
    }

    public void resetGame() {

        mainStage.btn0.setText("");
        mainStage.btn1.setText("");
        mainStage.btn2.setText("");
        mainStage.btn3.setText("");
        mainStage.btn4.setText("");
        mainStage.btn5.setText("");
        mainStage.btn6.setText("");
        mainStage.btn7.setText("");
        mainStage.btn8.setText("");
        moveNum = 0;

        mainStage.btn0.setMouseTransparent(false);
        mainStage.btn1.setMouseTransparent(false);
        mainStage.btn2.setMouseTransparent(false);
        mainStage.btn3.setMouseTransparent(false);
        mainStage.btn4.setMouseTransparent(false);
        mainStage.btn5.setMouseTransparent(false);
        mainStage.btn6.setMouseTransparent(false);
        mainStage.btn7.setMouseTransparent(false);
        mainStage.btn8.setMouseTransparent(false);

    }

    public void gameAgin(String content) {
        Alert alert = new Alert(AlertType.CONFIRMATION,
                content, ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            resetGame();
        }
        if (alert.getResult() == ButtonType.NO) {
            System.out.println("Exiting");
            Scene s = new Scene(homeScene);
            EntryPoint.myStage.setScene(s);

        }
    }

}
