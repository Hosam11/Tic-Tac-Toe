/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;
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
public class PlayerVsPc {

    GameSceneBase mainStage = new GameSceneBase();

    int turnFlag = 0;

    int oScore, xScore, tieScore = 0;
    int isWinner = -2;// 0 => x is winner / 1 => o is winner / -1 draw
    String finalResult;
    int cpuMove = 0;
    int i = 1;
//    int minCaseValue = 1; // modify to suit your case
//    int maxCaseValue = 9; // modify to suit your case
    ArrayList<Integer> gameMoves = new ArrayList<>();
    MenuSceneBase homeScene = new MenuSceneBase();

    boolean chk;

    public PlayerVsPc(GameSceneBase gameSceneBase) {
        mainStage = gameSceneBase;

        mainStage.scoreLabel_1.setText(Integer.toString(oScore));
        mainStage.scoreLabel_2.setText(Integer.toString(xScore));
        mainStage.tieScoreLabel.setText(Integer.toString(tieScore));
        mainStage.logo.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Are You Sure", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Scene s = new Scene(homeScene);
                EntryPoint.myStage.setScene(s);
            }

        });

        mainStage.btn0.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn1");
                setTurn();
                if ("".equals(mainStage.btn0.getText())) {
                    gameMoves.add(1);
                    mainStage.btn0.setText(getTurn());
                    mainStage.btn0.setDisable(true);

//                    checkWinner();
                    gameMoves.add(1);

                    nextCpuMove();

                }
//                System.out.println(turnFlag);

            }

        }
        );

        mainStage.btn1.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

//                System.out.println("btn2");
                if ("".equals(mainStage.btn1.getText())) {
                    gameMoves.add(2);
                    setTurn();
                    mainStage.btn1.setText(getTurn());
                    mainStage.btn1.setDisable(true);

                    gameMoves.add(2);
                    nextCpuMove();

//        checkWinner();
                }

            }

        }
        );

        mainStage.btn2.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

//                System.out.println("btn3");
                setTurn();
                if ("".equals(mainStage.btn2.getText())) {
                    gameMoves.add(3);
                    mainStage.btn2.setText(getTurn());
                    mainStage.btn2.setDisable(true);
//  checkWinner();

                    gameMoves.add(3);
                    nextCpuMove();

                }
            }

        }
        );

        mainStage.btn3.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn4");

                setTurn();
                if ("".equals(mainStage.btn3.getText())) {
                    gameMoves.add(4);
                    mainStage.btn3.setText(getTurn());
                    mainStage.btn3.setDisable(true);

                    gameMoves.add(3);
                    nextCpuMove();
//      checkWinner();

                }

            }

        }
        );

        mainStage.btn4.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn5");
                setTurn();
                if ("".equals(mainStage.btn4.getText())) {
                    gameMoves.add(5);
                    mainStage.btn4.setText(getTurn());
                    mainStage.btn4.setDisable(true);
//              checkWinner();
                    gameMoves.add(5);
                    nextCpuMove();

                }

            }

        }
        );

        mainStage.btn5.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn6");
                setTurn();
                if ("".equals(mainStage.btn5.getText())) {
                    gameMoves.add(6);
                    mainStage.btn5.setText(getTurn());
                    mainStage.btn5.setDisable(true);

//                    checkWinner();
                    gameMoves.add(6);
                    nextCpuMove();

                }

            }

        }
        );

        mainStage.btn6.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                gameMoves.add(7);
//                System.out.println("btn7");
                setTurn();
                if ("".equals(mainStage.btn6.getText())) {
                    mainStage.btn6.setText(getTurn());
                    mainStage.btn6.setDisable(true);
//                    checkWinner();
                    gameMoves.add(7);
                    nextCpuMove();
                }

            }

        }
        );

        mainStage.btn7.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn8");
                setTurn();
                if ("".equals(mainStage.btn7.getText())) {
                    gameMoves.add(8);
                    mainStage.btn7.setText(getTurn());
                    mainStage.btn7.setDisable(true);
//                    checkWinner();
//      
                    gameMoves.add(8);
                    nextCpuMove();
                }
            }

        }
        );

        mainStage.btn8.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//                System.out.println("btn9");
                setTurn();
                if ("".equals(mainStage.btn8.getText())) {
                    mainStage.btn8.setText(getTurn());
                    mainStage.btn8.setDisable(true);
                    gameMoves.add(9);
//                checkWinner();

                    gameMoves.add(9);
                    nextCpuMove();

                }

            }

        }
        );

    }

    public void nextCpuMove() {
        checkTie2();

        System.out.println(gameMoves.size() + " size of moves : ");
        if (!chk) {
            checkWinner();
            cpuMove = generateRand();
            System.out.println("this is cpu next move :" + cpuMove);
            if (gameMoves.contains(cpuMove)) {

                System.out.println("cpu couldnt play in this move :" + cpuMove);
                nextCpuMove();
//                if(gameMoves.size() == 9){
//                    System.out.println("tie");   
//                }

            } else {

                switch (cpuMove) {
                    case 1:
                        if ("".equals(mainStage.btn0.getText())) {

                            setTurn();
                            mainStage.btn0.setText(getTurn());
                            mainStage.btn0.setDisable(true);
                            gameMoves.add(1);

                            checkWinner();

                        }
                        break;
                    case 2:

                        if ("".equals(mainStage.btn1.getText())) {
                            setTurn();
                            mainStage.btn1.setText(getTurn());
                            mainStage.btn1.setDisable(true);
                            gameMoves.add(2);
                            checkWinner();

                        }
                        break;
                    case 3:
                        if ("".equals(mainStage.btn2.getText())) {
                            setTurn();
                            mainStage.btn2.setText(getTurn());
                            mainStage.btn2.setDisable(true);
                            gameMoves.add(3);
                            checkWinner();

                        }
                        break;
                    case 4:
                        if ("".equals(mainStage.btn3.getText())) {
                            setTurn();
                            mainStage.btn3.setText(getTurn());
                            mainStage.btn3.setDisable(true);
                            gameMoves.add(4);
                            checkWinner();

                        }
                        break;
                    case 5:
                        if ("".equals(mainStage.btn4.getText())) {
                            setTurn();
                            mainStage.btn4.setText(getTurn());
                            mainStage.btn4.setDisable(true);
                            gameMoves.add(5);
                            checkWinner();

                        }
                        break;
                    case 6:
//                        checkWinner();
                        if ("".equals(mainStage.btn5.getText())) {
                            setTurn();
                            mainStage.btn5.setText(getTurn());
                            mainStage.btn5.setDisable(true);
                            gameMoves.add(6);
                            checkWinner();

                        }
                        break;
                    case 7:
//                        checkWinner();
                        if ("".equals(mainStage.btn6.getText())) {
                            setTurn();
                            mainStage.btn6.setText(getTurn());
                            mainStage.btn6.setDisable(true);
                            gameMoves.add(7);
                            checkWinner();

                        }
                        break;
                    case 8:
//                 checkWinner();
                        if ("".equals(mainStage.btn7.getText())) {
                            setTurn();

                            mainStage.btn7.setText(getTurn());
                            mainStage.btn7.setDisable(true);
                            gameMoves.add(8);
                            checkWinner();

                        }
                        break;

                    case 9:
//                        checkWinner();
                        if ("".equals(mainStage.btn8.getText())) {
                            setTurn();
                            mainStage.btn8.setText(getTurn());
                            mainStage.btn8.setDisable(true);
                            gameMoves.add(9);
                            checkWinner();

                        }
                        break;

                }
            }
        }
    }

    public void checkWinner() {

        if ("X".equals(mainStage.btn0.getText()) && "X".equals(mainStage.btn3.getText()) && "X".equals(mainStage.btn6.getText())) {
            System.out.println("X is the winner");
            isWinner = 0;
//            xScore++;
            endGame();
        }
        if ("O".equals(mainStage.btn0.getText()) && "O".equals(mainStage.btn3.getText()) && "O".equals(mainStage.btn6.getText())) {
            System.out.println("O is the winner");
//            oScore++;
            isWinner = 1;
            endGame();
        }

        ///////////////////////////////////////////////////////////////////
        if ("X".equals(mainStage.btn1.getText()) && "X".equals(mainStage.btn4.getText()) && "X".equals(mainStage.btn7.getText())) {
            System.out.println("X is the winner");
            isWinner = 0;
//            xScore++;
            endGame();

        }
        if ("O".equals(mainStage.btn1.getText()) && "O".equals(mainStage.btn4.getText()) && "O".equals(mainStage.btn7.getText())) {
            System.out.println("O is the winner");
//            oScore++;
            isWinner = 1;
            endGame();
        }
        ///////////////////////////////////////////////////////////////////////
        if ("X".equals(mainStage.btn2.getText()) && "X".equals(mainStage.btn5.getText()) && "X".equals(mainStage.btn8.getText())) {
            System.out.println("X is the winner");
//            xScore++;
            isWinner = 0;
            endGame();
        }
        if ("O".equals(mainStage.btn2.getText()) && "O".equals(mainStage.btn5.getText()) && "O".equals(mainStage.btn8.getText())) {
            System.out.println("O is the winner");
//            oScore++;
            isWinner = 1;
            endGame();
        }

        if ("X".equals(mainStage.btn2.getText()) && "X".equals(mainStage.btn4.getText()) && "X".equals(mainStage.btn6.getText())) {
            System.out.println("X is the winner");
//            xScore++;
            isWinner = 0;
            endGame();
        }
        if ("O".equals(mainStage.btn2.getText()) && "O".equals(mainStage.btn4.getText()) && "O".equals(mainStage.btn6.getText())) {
            System.out.println("O is the winner");
//            oScore++;
            isWinner = 1;
            endGame();
        }

        //////////////////////////////////////////////////
        if ("X".equals(mainStage.btn0.getText()) && "X".equals(mainStage.btn4.getText()) && "X".equals(mainStage.btn8.getText())) {
            System.out.println("X is the winner");
//            xScore++;
            isWinner = 0;
            endGame();
        }
        if ("O".equals(mainStage.btn0.getText()) && "O".equals(mainStage.btn4.getText()) && "O".equals(mainStage.btn8.getText())) {
            System.out.println("O is the winner");
//            oScore++;
            isWinner = 1;
            endGame();
        }

        if ("X".equals(mainStage.btn0.getText()) && "X".equals(mainStage.btn1.getText()) && "X".equals(mainStage.btn2.getText())) {
            System.out.println("X is the winner");
//            xScore++;
            isWinner = 0;
            endGame();
        }
        if ("O".equals(mainStage.btn0.getText()) && "O".equals(mainStage.btn1.getText()) && "O".equals(mainStage.btn2.getText())) {
            System.out.println("O is the winner");
//            oScore++;
            isWinner = 1;
            endGame();
        }

        ////////////////////////////////////
        if ("X".equals(mainStage.btn3.getText()) && "X".equals(mainStage.btn4.getText()) && "X".equals(mainStage.btn5.getText())) {
            System.out.println("X is the winner");
//            xScore++;
            isWinner = 0;
            endGame();
        }
        if ("O".equals(mainStage.btn3.getText()) && "O".equals(mainStage.btn4.getText()) && "O".equals(mainStage.btn5.getText())) {
            System.out.println("O is the winner");
//            oScore++;
            isWinner = 1;
            endGame();
        }
        ///////////////////////////////////////////
        if ("X".equals(mainStage.btn6.getText()) && "X".equals(mainStage.btn7.getText()) && "X".equals(mainStage.btn8.getText())) {
            System.out.println("X is the winner");
//            xScore++;
            isWinner = 0;
            endGame();
        }
        if ("O".equals(mainStage.btn6.getText()) && "O".equals(mainStage.btn7.getText()) && "O".equals(mainStage.btn8.getText())) {
            System.out.println("O is the winner");
            isWinner = 1;
//            oScore++;
            endGame();
        }

        if (!"".equals(mainStage.btn0.getText()) && !"".equals(mainStage.btn1.getText()) && !"".equals(mainStage.btn2.getText()) && !"".equals(mainStage.btn3.getText()) && !"".equals(mainStage.btn4.getText()) && !"".equals(mainStage.btn5.getText()) && !"".equals(mainStage.btn6.getText()) && !"".equals(mainStage.btn7.getText()) && !"".equals(mainStage.btn8.getText())) {

//                tieScore++;
            endGame();
        }

    }

    public void endGame() {

        System.out.println("iswinner = " + isWinner);

        mainStage.btn8.setDisable(true);
        mainStage.btn0.setDisable(true);
        mainStage.btn1.setDisable(true);
        mainStage.btn2.setDisable(true);
        mainStage.btn3.setDisable(true);
        mainStage.btn4.setDisable(true);
        mainStage.btn5.setDisable(true);
        mainStage.btn6.setDisable(true);
        mainStage.btn7.setDisable(true);

        switch (isWinner) {
            case 0:
                finalResult = "Player X is the winner \n";
                break;
            case 1:
                finalResult = "Player O is the winner \n";
                break;
            case -1:
                finalResult = "That's a Draw \n";
                break;
        }

        Alert alert = new Alert(AlertType.CONFIRMATION, finalResult
                + "would you like to play again ?",
                ButtonType.YES, ButtonType.NO);

        alert.showAndWait();
        switch (isWinner) {
            case -1:
                tieScore++;
                if (alert.getResult() == ButtonType.YES) {
                    //do stuff
                    resetGame();
                } else {
                    resetGame();
                    System.out.println("exit");
                    Scene s = new Scene(homeScene);
                    EntryPoint.myStage.setScene(s);
                }
                break;
            case 0:
                xScore++;
                if (alert.getResult() == ButtonType.YES) {

                    resetGame();

                } else {
                    System.out.println("exit");
                    resetGame();
                    Scene s = new Scene(homeScene);
                    EntryPoint.myStage.setScene(s);
                }

                break;
            case 1:
                oScore++;
                if (alert.getResult() == ButtonType.YES) {
                    //do stuff
                    resetGame();

                } else {
                    //do stuff
                    System.out.println("exit");
                    resetGame();
                    Scene s = new Scene(homeScene);
                    EntryPoint.myStage.setScene(s);
                }

                break;

        }
        mainStage.scoreLabel_1.setText(Integer.toString(oScore));
        mainStage.scoreLabel_2.setText(Integer.toString(xScore));
        mainStage.tieScoreLabel.setText(Integer.toString(tieScore));

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

    public int generateRand() {

        return (int) (Math.random() * ((9 - 1) + 1)) + 1;
    }

    public void checkTie2() {
        if (mainStage.btn0.getText() != ""
                && mainStage.btn1.getText() != ""
                && mainStage.btn2.getText() != "" && mainStage.btn3.getText() != "" && mainStage.btn4.getText() != "" && mainStage.btn5.getText() != "" && mainStage.btn6.getText() != "" && mainStage.btn7.getText() != "" && mainStage.btn8.getText() != "") {
            isWinner = -1;
//            tieScore++;
            endGame();
        }

    }

    public void resetGame() {
        getTurn();

        mainStage.btn0.setText("");
        mainStage.btn1.setText("");
        mainStage.btn2.setText("");
        mainStage.btn3.setText("");
        mainStage.btn4.setText("");
        mainStage.btn5.setText("");
        mainStage.btn6.setText("");
        mainStage.btn7.setText("");
        mainStage.btn8.setText("");

        chk = false;
        isWinner = -2;

        gameMoves.clear();

        mainStage.btn8.setDisable(false);
        mainStage.btn0.setDisable(false);
        mainStage.btn1.setDisable(false);
        mainStage.btn2.setDisable(false);
        mainStage.btn3.setDisable(false);
        mainStage.btn4.setDisable(false);
        mainStage.btn5.setDisable(false);
        mainStage.btn6.setDisable(false);
        mainStage.btn7.setDisable(false);

    }

}
