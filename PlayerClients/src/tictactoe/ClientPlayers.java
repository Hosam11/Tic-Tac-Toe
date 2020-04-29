package tictactoe;

import animations.Won;
import animations.lost2;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class ClientPlayers {

    //UIGame uIGame = new UIGame();
    GameSceneBase gameScene;
    // home screen object
    MenuSceneBase homeScene = new MenuSceneBase();
    Socket sClient;
    DataInputStream dInputStream;
    PrintStream pStream;

    // strings of btns
    final String btn_0 = "0";
    final String btn_1 = "1";
    final String btn_2 = "2";
    final String btn_3 = "3";
    final String btn_4 = "4";
    final String btn_5 = "5";
    final String btn_6 = "6";
    final String btn_7 = "7";
    final String btn_8 = "8";

    String dReaded;
    String p1; // hold number of p1  //1
    String p2; // hold number of p2  //2

    String[] dataReaedArray;

    String playerRecived = "t";
    String btnRecived = "t";
    String turnRecived = "t";
    String moveRecived = "t";
    String winState;
    String drawStat;
    // was static
    boolean flagReadingPlayer = true;

    String isReplay = "r";

    String[] strCounters = new String[3];

    // name of player which send to server 
    String pName;

    boolean p1Connected = false;
    boolean p2Connected = false;

    boolean p1EndPlaying = false;
    boolean p2EndPlaying = false;

    public ClientPlayers(GameSceneBase scene, String pName) {
        gameScene = scene;
        this.pName = pName;
        gameScene.playerName.setText(pName);

        System.out.println("pName is >> " + this.pName);
        System.err.println("p1Connected is >> " + p1Connected);
        System.err.println("p2Connected is >> " + p2Connected);
        //gameScene.
        try {
            System.out.println("from try cons player");
            sClient = new Socket("127.0.0.1", 4949);
           // sClient = new Socket("172.16.4.13", 4949);
            dInputStream = new DataInputStream(sClient.getInputStream());
            pStream = new PrintStream(sClient.getOutputStream());
        } catch (IOException ex) {
            System.out.println("server down");
            dialogServerDown();
            System.err.println("1-From SockeClient - input-outputStreams ");
        }

        ThreadOperations operations = new ThreadOperations();
        Thread thread = new Thread(operations);
        thread.start();

        gameScene.logo.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            flagReadingPlayer = false;
            System.err.println("cClient is >> " + sClient);
            System.out.println("mouse clicked");
            // aler yes or no
            Dialog d = new Dialog();
            ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            d.getDialogPane().getButtonTypes().addAll(okButtonType);
            d.setContentText("Are You Sure ?  ");
            Button okBtn = (Button) d.getDialogPane().lookupButton(okButtonType);
            // reset connection
            // resetVariables();
            // if confirm go to ho
            okBtn.setOnAction(ev -> {
                System.out.println("pressed");
                if (p1 != null && p1.equals("1")) {
                    pStream.println(p1 + "_" + 3456789);
                } else if (p2 != null && p2.equals("2")) {
                    pStream.println(p2 + "_" + 3456789);
                }
                // disable falage of while loop that read from server 
                // [hint] at that point the code i hold and wait inside readLine in that falg
                flagReadingPlayer = false;
                closeConnections();
                Scene s = new Scene(homeScene);
                EntryPoint.myStage.setScene(s);
            });
            
            
            d.showAndWait();
        });

        EntryPoint.myStage.setOnCloseRequest((WindowEvent we) -> {
            System.out.println("Stage is closing from player");
            // _11 meaningless just with size 6 to differnt from other str stats
            if (p1 != null && p1.equals("1")) {
                System.out.println("#setOnCloseRequest#close clicked >> p1 send to server");
                flagReadingPlayer = false;
                pStream.println(p1 + "_" + "c" + "_11");
            } else if (p2 != null && p2.equals("2")) {
                System.out.println("#setOnCloseRequest#close clicked >> p2 send to server");
                flagReadingPlayer = false;
                pStream.println(p2 + "_" + "c" + "_11");
            }
//             signInSceneBase.countsPlayers --;
            System.exit(0);
        });
        
        //send to server btn clicked
        onClickBtnOfBoard();
    }

    /**
     * call it when server is down and players try to connect it
     */
    private void dialogServerDown() {
        Platform.runLater(() -> {
            Dialog d = new Dialog();
            ButtonType okButtonType = new ButtonType("Ok",
                    ButtonBar.ButtonData.OK_DONE);
            d.getDialogPane().getButtonTypes().addAll(okButtonType);
            d.setContentText("Sorry Server Down!");
            Button okBtn = (Button) d.getDialogPane().lookupButton(okButtonType);
            Scene s = new Scene(homeScene);

            okBtn.setOnAction(ev -> {
                EntryPoint.myStage.setScene(s);
            });

            d.setOnCloseRequest((eve) -> {
                System.out.println("from setOnCloseRequest() >> dialogServerDown");
                EntryPoint.myStage.setScene(s);
            });
                        d.showAndWait();


        });
    }

    /**
     * @param title
     * @param content
     */
    private void displayDialog(String title, String content) {
        Platform.runLater(() -> {
            System.out.println("from alert");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(content);
            alert.showAndWait();

        });
    }

    /**
     * call it when the game is on then server shutdown
     */
    private void dialogeServerProblem(String content) {
        //displayDialog("sorry there is a problem with the server", "connection error");
        Platform.runLater(() -> {
            Dialog d = new Dialog();
            ButtonType okButtonType = new ButtonType("Ok",
                    ButtonBar.ButtonData.OK_DONE);
            d.getDialogPane().getButtonTypes().addAll(okButtonType);
            d.setContentText(content);
            Button okBtn = (Button) d.getDialogPane().lookupButton(okButtonType);
            okBtn.setOnAction(ev -> {
                goHomeScene();
            });
            d.setOnCloseRequest((eve) -> {
                System.out.println("from setOnCloseRequest() >> dialogeServerProblem");
                goHomeScene();
            });
            d.showAndWait();
        });
    }

    /**
     * call resetVariables() then change scene
     */
    private void goHomeScene() {
        closeConnections();
        Platform.runLater(() -> {
            Scene s = new Scene(homeScene);
            EntryPoint.myStage.setScene(s);
            System.err.println("after scenc changed2");
        });
    }

    /**
     * close pStream & dInputStream & sClient coz the player no longer in game
     * set the condition of the infante loop to be false
     */
    private void closeConnections() {
        System.out.println("from closeConnections()");
        //flagReadingPlayer = false;
        pStream.close();
        try {
            dInputStream.close();
            sClient.close();
        } catch (IOException ex) {
            System.out.println("from catch resetVariables() ");
            Logger.getLogger(ClientPlayers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class ThreadOperations implements Runnable {

        Won win; // winner animation scence
        lost2 lose; // loser animation scence

        @Override
        public void run() {
            System.err.println("flagReadingPlayer befor try is >> " + flagReadingPlayer);
            while (flagReadingPlayer) {
                try {
                    dReaded = dInputStream.readLine();
                    //String s = dInputStream.readLine();
                    //System.out.println("sec is >> " + s);
                    // String dR2 = dInputStream.readLine();
                    System.err.println("flagReadingPlayer befor try is >> " + flagReadingPlayer);
                    System.err.println("dr1 is >> " + dReaded);
                    //System.err.println("dr2 is >> " + dR2);
                    // coz at the end of the game dRead at some point will be null
                    // and i do not want to throw an exception
                    if (dReaded != null) {
                        // that str send from server to tell first player the second player has conntected
                        if (dReaded.equals("12")) {
                            Platform.runLater(() -> {
                                gameScene.statusLable.setText("conntected");
                            });
                            //String s = dInputStream.readLine();
                            //System.out.println("s " + s);                                                                        
                            System.out.println("from connected");

                        } else if (dReaded.equals("unwanted")) {
                            System.out.println("from unwanted player");
                            flagReadingPlayer = false;
                            dialogeServerProblem("sorry server busy please try again later");

                        } // one of players go to home
                        else if (dReaded.length() == 9) {
                            System.out.println("dReaded is >>> " + dReaded);
                            System.out.println("from one of players go to home");
                            showAlertPlayerRefusedPlaying("other player left game");
                            flagReadingPlayer = false;
                            //resetConnectionVariables();
                        } // there is a player close the app
                        else if (dReaded.length() == 6) {
                            if (p1 != null && p1.equals("1")) {
                                System.out.println(" player 2 closed");
                            } else if (p2 != null && p2.equals("2")) {
                                System.out.println(" player 1 closed");
                            }
                            flagReadingPlayer = false;
                            // alert then go to back screen
                            showAlertPlayerRefusedPlaying("Sorry the second player exit the game");

                        } else // to check which player that data send from
                        // p2Connected if ture >> mean i send the name 
                        //so i dont excute that code inside
                        if (dReaded.equals("1") && dReaded != null && !p1Connected) {
                            p1 = dReaded;
                            Platform.runLater(() -> {
                                System.out.println("from change text label waiting");
                                gameScene.statusLable.setText("waiting for player 2");
                            });
                            // length with 13 send pName
                            pStream.println("1234567891234");
                            pStream.println(pName);
                            // to disable that contion after i send p1Name
                            p1Connected = true;
                            System.err.println("int value client p1 is >> " + p1);
                            // to check which player that data send from
                            // p2Connected if ture >> mean i send the name 
                            //so i dont excute that code inside
                        } else if (dReaded.equals("2") && dReaded != null && !p2Connected) {
                            //gameScene.label1.setText("");
                            p2 = dReaded;
                            System.err.println("int value client p2 is >> " + p2);
                            // length with 13 send pName
                            pStream.println("1234567891234");
                            pStream.println(pName);
                            // to disable that contion after i send p2Name
                            p2Connected = true;
                            // data comming from server like 1_t_2_f so len is 7
                        } // if game finished and need to know play again or not
                        else if (dReaded.length() == 7) {
                            System.out.println("F%%%%%%%rom afterGameEnded");
                            gamedEndedHandlePlayAgainOrNot();
                        } // here normal game has began and two cleint can send and recive from the server
                        else {
                            System.err.println("data read from server is >> " + dReaded);
                            // when server send to remaing player that the first one has left
                            // the game will send an str with len of 6 and i do not want
                            // to enter that method if len is 6
                            if (dReaded.length() != 6 && !dReaded.equals("game_active")) {
                                Platform.runLater(() -> {
                                    gameScene.statusLable.setText("");
                                });
                                processDataReturnFromServer(dReaded);
                            }
                        }
                    }

                } catch (IOException ex) {
                    // TODO >>> 
                    // coz when click in home buttom this vaiavle was be false but code
                    // was aleardy listing and stop at readLine so if that case 
                    // i do not need to display that dialog in that case                                         
                    System.out.println("from catch >> flagReadingPlayer " + flagReadingPlayer);
                    if (flagReadingPlayer) {
                        flagReadingPlayer = false;
                        dialogeServerProblem("server error");
                        System.out.println("2-from readLinePlayer");
                        Logger.getLogger(ClientPlayers.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        /**
         * see if it valid turn then see if it valid move and if ture caa
         * updateUI to set X or O then call check for winner
         *
         * @param dataReaded: CONTRACT STATMENT 0 1 2 3 4 5 CONTRACT STATMENT
         * name_btn_turn_move_win_draw
         */
        private void processDataReturnFromServer(String dataReaded) {
            dataReaedArray = dataReaded.split("_");
            playerRecived = dataReaedArray[0];
            btnRecived = dataReaedArray[1];
            turnRecived = dataReaedArray[2];
            moveRecived = dataReaedArray[3];
            winState = dataReaedArray[4];
            drawStat = dataReaedArray[5];
            System.out.println("%^%^ >> pRecived is " + playerRecived);
            System.out.println("str from process is  >> " + dataReaded);

            if (turnRecived.equals("t")) { // vaild turn
                if (moveRecived.equals("t")) { // vaild move
                    //set text to ui
                    int whichBtnClicked = Integer.parseInt(btnRecived);
                    int playerId = Integer.parseInt(playerRecived);
                    System.out.println("@@- p is >> " + playerId + " btn is >> " + whichBtnClicked);
                    // update ui by x or o
                    whichButtonClicked(whichBtnClicked, playerId);
                    checkForWinsDraw(playerId);
                } else { // Invaild move
                    displayDialog("Invalid move", "Invaild Move please, try again");
                    /*
                    Alert1BtnSceneBase absb = new Alert1BtnSceneBase();
                    Platform.runLater(() -> {
                        boolean added = gameScene.getChildren().add(absb);
                        System.out.println("fron runlater abs >> " + added);
                    });
                     */
                }
            } else { // invaild turn
                displayDialog("You Already played please wait for anthor player", "Not Your Turn");
            }
        }

        /**
         * take player ID and compare it with winState to see if there is a win
         * or in case of win -- see which player has win and display right
         * dialog and celebration to each player
         *
         * @param playerId: player ID compare it with winState to see
         */
        private void checkForWinsDraw(int playerId) {
            // Checks For WINNER after drar
            if (winState.equals("t")) {
                if (playerRecived.equals(p1)) { // winner                    
                    animationWin();
                } else if (playerRecived.equals(p2)) { // winner                    
                    animationWin();
                } else { // loser                       
                    animationLose();
                }
                System.out.println("there is a winner + pId >> " + playerId);
            } else if (drawStat.equals("d")) {
                // TODO 
                Fade(gameScene.lineH1);
                Fade(gameScene.lineH2);
                Fade(gameScene.lineV1);
                Fade(gameScene.lineV2);
                
                //Fade(gameScene.lineH21);
                Platform.runLater(() -> {
                    Alert alert = new Alert(AlertType.CONFIRMATION,
                            "draw would you like to play again ?", ButtonType.YES, ButtonType.NO);
                    alert.showAndWait();

                    if (alert.getResult() == ButtonType.YES) {
                        isReplay = "t";
                        sendYesOrNoStrToServer();
                    }
                    if (alert.getResult() == ButtonType.NO) {
                        isReplay = "f";
                        sendYesOrNoStrToServer();
                    }
                });

                System.out.println("there is a  draw is >> " + playerRecived);

            }
        }

        /**
         * take the playAgainBtn clicked and pId that click then send those data
         * to printXorO() to set the playAgainBtn to X or o
         *
         * @param whichBtnClicked : which playAgainBtn are clicked
         * @param playerId : who has played
         */
        private void whichButtonClicked(int whichBtnClicked, int playerId) {
            switch (whichBtnClicked) {
                case 0:
                    printXorO(playerId, gameScene.btn0);
                    break;
                case 1:
                    printXorO(playerId, gameScene.btn1);
                    break;
                case 2:
                    printXorO(playerId, gameScene.btn2);
                    break;
                case 3:
                    printXorO(playerId, gameScene.btn3);
                    break;
                case 4:
                    printXorO(playerId, gameScene.btn4);
                    break;
                case 5:
                    printXorO(playerId, gameScene.btn5);
                    break;
                case 6:
                    printXorO(playerId, gameScene.btn6);
                    break;
                case 7:
                    printXorO(playerId, gameScene.btn7);
                    break;
                case 8:
                    printXorO(playerId, gameScene.btn8);
                    break;
            }
        }

        /**
         * take numbers of player and buttons to check appropriate player to Set
         * weather X or O on the playAgainBtn
         *
         * @param pId : player number
         * @param btn : playAgainBtn number
         */
        public void printXorO(int pId, Button btn) {
            Platform.runLater(() -> {
                if (pId == 1) {
                    btn.setText("X");
                } else if (pId == 2) {
                    btn.setText("O");
                }
                // btn.setDisable(true);
            });
        }

        /**
         * show animation and set the value of isReplay wheather f or t to use
         * it later in afterGameEnded
         */
        private void animationWin() {
            win = new Won();
            Scene scene = new Scene(win);
            scene.getStylesheets().addAll(getClass().getResource("/animations/StyleSheet.css").toExternalForm());
            Platform.runLater(() -> {
                //gameScene.getChildren().add(win);
                EntryPoint.myStage.setScene(scene);
                EntryPoint.myStage.show();
            });
            win.playAgainBtn.setOnAction((e) -> {
                isReplay = "t";
                System.out.println("yes clicked");
                sendYesOrNoStrToServer();
            });
            win.exitBtn.setOnAction((e) -> {
                isReplay = "f";
                sendYesOrNoStrToServer();
                System.out.println("exit cliked");
            });

        }

        /**
         * after btn was clicked send str of clicked to server then disable the
         * buttons so avoid problem will happend if user click twice on the btn
         * TODO >> may be throw an exception i will handle it later
         */
        private void sendYesOrNoStrToServer() {
            if (p1 != null && p1.equals("1")) {
                System.out.println("from p1 animation");
                pStream.println(p1 + "_" + isReplay);
            } else if (p2 != null && p2.equals("2")) {
                System.out.println("from p2 animation");
                pStream.println(p2 + "_" + isReplay);
            }
            // coz this method win and lose excute it and draw
            if (win != null) {
                System.out.println("from  win not null ");
                win.playAgainBtn.setDisable(true);
                win.exitBtn.setDisable(true);
            }
            if (lose != null) {
                System.out.println("from  lose not null ");
                lose.playAgainBtn.setDisable(true);
                lose.exitBtn.setDisable(true);
            }
//            if (lose == null && win == null) {
//                
//            
//            }
        }

        private void animationLose() {
            lose = new lost2();
            Scene scene = new Scene(lose);
            scene.getStylesheets().addAll(getClass().getResource("/animations/StyleSheet.css").toExternalForm());

            Platform.runLater(() -> {
                EntryPoint.myStage.setScene(scene);
                EntryPoint.myStage.show();
            });
            lose.playAgainBtn.setOnAction((e) -> {
                isReplay = "t";
                System.out.println("yes clicked");
                sendYesOrNoStrToServer();
            });
            lose.exitBtn.setOnAction((e) -> {
                isReplay = "f";
                System.out.println("exit cliked");
                sendYesOrNoStrToServer();
            });
        }

        public void Fade(Line n) {
            FadeTransition fade = new FadeTransition();
            fade.setDuration(Duration.millis(400));
            fade.setFromValue(10);
            fade.setToValue(0.1);
            fade.setCycleCount(10);
            fade.setAutoReverse(true);
            fade.setNode(n);
            fade.play();
        }

        /**
         * str lenght = 6 "1_t_1_f" read from server that "1_t_1_f" which means
         * weather player want to play again or not if want to set text of btns
         * to "" and read from another stream 3 counter of game
         */
        private void gamedEndedHandlePlayAgainOrNot() {
            String dReaded2 = null;
            try {
                // read 3 counter -- p1Wins - p2Wins - draw
                dReaded2 = dInputStream.readLine();
            } catch (IOException ex) {
                System.out.println("3- from  afterGameEnded.readLine()");
                Logger.getLogger(ClientPlayers.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("dRead  is >> " + dReaded);
            System.out.println("dRead2  is >> " + dReaded2);
            strCounters = dReaded2.split("_");
            //check to see the data to which player if values play again
            // set all buttons to "" so can play again
            String replayStat1YorN = dReaded.split("_")[1]; // t or f
            String replayStat2YorN = dReaded.split("_")[3];
            System.out.println("stat is ><>< " + dReaded);

            if (p1 != null && p1.equals("1")) { // case player one
                if (replayStat1YorN.equals("t")) { // player1 accepted
                    if (replayStat2YorN.equals("f")) { // player2 refused
                        // then back to privous screen
                        System.out.println("sorry p2 refused the request");
                        // ## Somthing Wrong ## if that comment coz he enter while loop 
                        // so first we nedd to set that to false
                        flagReadingPlayer = false;
                        // alert message then go to home
                        showAlertPlayerRefusedPlaying("other player2 refused the request"); // then  // go to home screens
                        // alertPlayerRefusedPlayAgai other player2 refused the request");                     
                        System.out.println("then i as p1 will go to home screen");
                    } else if (replayStat2YorN.equals("t")) { // all want to play again
                        // set ui to new game
                        setTextBtnsToNull();
                        // set ui ti game scence coz i at that momebt eather in won scene or lose
                        setGameScene();
                        System.out.println("all accept stat new game from " + p1);
                    }
                } else if (replayStat1YorN.equals("f")) { // p1 refused play
                    System.out.println("i as p1 refused i will go to home screen)");
                    //  back to privous screen
                    System.out.println("then i will go to home screen");
                    flagReadingPlayer = false;
                    goHomeAfterRefusedPlay();
                }
                // update counter for player wins
                // X_O_tie
                // 1_1_1                
                Platform.runLater(() -> {
                    updateCounterScore();
                });

            } // case player 2
            else if (p2 != null && p2.equals("2")) {
                if (replayStat2YorN.equals("t")) { // player2 accepted
                    if (replayStat1YorN.equals("f")) { // player1 refused
                        System.out.println("sorry p1 refused the request");
                        System.out.println("then i will go to home screen");
                        // must be here to avoid exception of conncection error 
                        // coz i think while alert is showing and wait code excute
                        // while read so will throw that exception
                        flagReadingPlayer = false;
                        // then back to home screen
                        showAlertPlayerRefusedPlaying("other player1 refused the request"); // then go home from there
                    } else if (replayStat1YorN.equals("t")) { // all agree
                        // set ui to new game
                        setGameScene();
                        setTextBtnsToNull();
                        System.out.println("all accept stat new game from " + p2);
                    }
                } else if (replayStat2YorN.equals("f")) { // p2 refused play
                    System.out.println("i as p2 refused and i will go to home screen");
                    //  back to privous screen
                    flagReadingPlayer = false;
                    goHomeAfterRefusedPlay();
                }
                // update counter for player wins
                Platform.runLater(() -> {
                    updateCounterScore();
                });
            }
            System.err.println("#@# len is 7 " + dReaded);
        }

        private void updateCounterScore() {
            gameScene.scoreLabel_2.setText(strCounters[0]);
            gameScene.scoreLabel_1.setText(strCounters[1]);
            gameScene.tieScoreLabel.setText(strCounters[2]);
        }

        private void setTextBtnsToNull() {
            Platform.runLater(() -> {
                gameScene.btn0.setText("");
                gameScene.btn1.setText("");
                gameScene.btn2.setText("");
                gameScene.btn3.setText("");
                gameScene.btn4.setText("");
                gameScene.btn5.setText("");
                gameScene.btn6.setText("");
                gameScene.btn7.setText("");
                gameScene.btn8.setText("");
            });

        }

        /**
         * set same scene again to play again coz the scene was changed in lose
         * or win
         */
        private void setGameScene() {
            Scene scene = gameScene.btn0.getScene();
            Platform.runLater(() -> {
                EntryPoint.myStage.setScene(scene);
                EntryPoint.myStage.show();
            });

        }

        /**
         * show alert tell the player that the second player refused play again
         * then call goHome() method
         *
         * @param content: String to display on alert
         */
        private void showAlertPlayerRefusedPlaying(String content) {
            Platform.runLater(() -> {
                Dialog d = new Dialog();
                ButtonType okButtonType = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                d.getDialogPane().getButtonTypes().addAll(okButtonType);
                d.setContentText(content);
                Button okBtn = (Button) d.getDialogPane().lookupButton(okButtonType);
                okBtn.setOnAction(e -> {
                    System.out.println("pressed");
                    goHomeAfterRefusedPlay();
                });
                d.showAndWait();
            });
        }

        /**
         * send to server to tell that one player go to home screen then then
         * call resetConnectionVariables() that responsible for change scence
         * and set defus vars
         */
        private void goHomeAfterRefusedPlay() {
            System.out.println("btnok from aler clicked");
            if (p1 != null && p1.equals("1")) {
                System.out.println("player 1 go to home");
                pStream.println(p1 + "_" + "GoHome");
            } else if (p2 != null && p2.equals("2")) {
                System.out.println("player 2 go to home");
                pStream.println(p2 + "_" + "GoHome");
            }
            goHomeScene();
        }
    }

    // >>-------------------------------------------------------------<<
    // >>-------------------------------------------------------------<<
    // >>-------------------------------------------------------------<<    
    /**
     * send to server that 0 1 2 3 4 5 CONTRACT STATMENT
     * name_btn_turn_move_win_draw
     */
    private void onClickBtnOfBoard() {
        //                     0   1   2    3   4    5
        //CONTRACT STATMENT name_btn_turn_move_win_draw
        gameScene.btn0.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_0 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_0 + "_" + turnRecived + "_" + moveRecived);
            }
//            System.out.println("from btn1 click >> countPlayer is >>  " +  signInSceneBase.countsPlayers);
            //clickBtnSound();
        });

        gameScene.btn1.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_1 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_1 + "_" + turnRecived + "_" + moveRecived);
            }
            // clickBtnSound();

        });
        gameScene.btn2.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_2 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_2 + "_" + turnRecived + "_" + moveRecived);
            }
            // clickBtnSound();

        });

        gameScene.btn3.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_3 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_3 + "_" + turnRecived + "_" + moveRecived);
            }
            //          clickBtnSound();

        });

        gameScene.btn4.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_4 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_4 + "_" + turnRecived + "_" + moveRecived);
            }
            // clickBtnSound();

        });

        gameScene.btn5.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_5 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_5 + "_" + turnRecived + "_" + moveRecived);
            }
        });

        gameScene.btn6.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_6 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_6 + "_" + turnRecived + "_" + moveRecived);
            }
        });

        gameScene.btn7.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_7 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_7 + "_" + turnRecived + "_" + moveRecived);
            }
        });

        gameScene.btn8.setOnAction((ActionEvent event) -> {
            if (p1 != null && p1.equals("1")) {
                pStream.println(p1 + "_" + btn_8 + "_" + turnRecived + "_" + moveRecived);
            } else if (p2 != null && p2.equals("2")) {
                pStream.println(p2 + "_" + btn_8 + "_" + turnRecived + "_" + moveRecived);
            }
        });
    }
}
