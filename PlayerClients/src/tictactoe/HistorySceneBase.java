package tictactoe;

import Models.ModelTable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.Duration;
import static tictactoe.SignInSceneBase.p;

public class HistorySceneBase extends BorderPane {

    protected final AnchorPane leftSideAnchorPane;
    protected final AnchorPane rightSideAnchorPane;
    protected final AnchorPane containerPane;
    protected final AnchorPane contentPane;
    protected final ImageView soundIcon;
    protected final Label gameTitle;
    protected final ImageView logo;
    protected final Label userName;
    protected final ScrollPane scrollTablePane;
    protected final TableView historyTable;
    protected final TableColumn game_id_col;
    protected final TableColumn player_1_col;
    protected final TableColumn player_2_col;
    protected final TableColumn winnerCol;
    
    static boolean  fromHistoryFlage = false;

    public HistorySceneBase() {

        leftSideAnchorPane = new AnchorPane();
        rightSideAnchorPane = new AnchorPane();
        containerPane = new AnchorPane();
        contentPane = new AnchorPane();
        soundIcon = new ImageView();
        gameTitle = new Label();
        logo = new ImageView();
        userName = new Label();
        scrollTablePane = new ScrollPane();
        historyTable = new TableView();
        game_id_col = new TableColumn();
        player_1_col = new TableColumn();
        player_2_col = new TableColumn();
        winnerCol = new TableColumn();

        setId("parentPane");
        setMaxWidth(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(578.0);
        setPrefWidth(600.0);
        getStylesheets().add("/tictactoe/../css/styles.css");

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
        containerPane.setPrefHeight(596.0);
        containerPane.setPrefWidth(382.0);

        contentPane.setId("contentPane");
        contentPane.setLayoutX(8.0);
        contentPane.setLayoutY(2.0);
        contentPane.setPrefHeight(575.0);
        contentPane.setPrefWidth(372.0);

        soundIcon.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        soundIcon.setFitHeight(30.0);
        soundIcon.setFitWidth(35.0);
        soundIcon.setLayoutX(313.0);
        soundIcon.setLayoutY(26.0);
        soundIcon.setOnMouseClicked(this::muteSound);
        soundIcon.setPickOnBounds(true);
        soundIcon.setPreserveRatio(true);
        soundIcon.setImage(new Image(getClass().getResource("../img/sound/sound_icon.png").toExternalForm()));

        gameTitle.setAlignment(javafx.geometry.Pos.CENTER);
        gameTitle.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        gameTitle.setId("gameTitle");
        gameTitle.setLayoutX(46.0);
        gameTitle.setLayoutY(9.0);
        gameTitle.setText("Game History");
        gameTitle.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        gameTitle.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        gameTitle.setFont(new Font("System Bold", 14.0));

        logo.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        logo.setAccessibleRoleDescription("toHomePage");
        logo.setFitHeight(46.0);
        logo.setFitWidth(40.0);
        logo.setId("logo");
        logo.setOnMouseClicked(this::loadHomeScene);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        logo.setImage(new Image(getClass().getResource("../img/logo/icon.png").toExternalForm()));

        userName.setId("gameTitle");
        userName.setLayoutX(33.0);
        userName.setLayoutY(159.0);
        userName.setText("Hi, userName:");
        userName.setTextFill(javafx.scene.paint.Color.valueOf("#fce473"));
        userName.setFont(new Font("System Bold", 12.0));
        userName.setText("Hi," + SignInSceneBase.p.name);

        scrollTablePane.setLayoutY(229.0);
        scrollTablePane.setPrefHeight(332.0);
        scrollTablePane.setPrefWidth(363.0);

        historyTable.setPrefHeight(317.0);
        historyTable.setPrefWidth(363.0);

        game_id_col.setPrefWidth(68.66669178009033);
        game_id_col.setText("Game");

        player_1_col.setPrefWidth(88.66667938232422);
        player_1_col.setText("Player 1");

        player_2_col.setPrefWidth(92.66667175292969);
        player_2_col.setText("Player 2");

        winnerCol.setPrefWidth(97.333251953125);
        winnerCol.setText("Winner");
        scrollTablePane.setContent(historyTable);
        setCenter(containerPane);

        contentPane.getChildren().add(soundIcon);
        contentPane.getChildren().add(gameTitle);
        contentPane.getChildren().add(logo);
        contentPane.getChildren().add(userName);
        historyTable.getColumns().add(game_id_col);
        historyTable.getColumns().add(player_1_col);
        historyTable.getColumns().add(player_2_col);
        historyTable.getColumns().add(winnerCol);
        contentPane.getChildren().add(scrollTablePane);
        containerPane.getChildren().add(contentPane);
        loadData();
        historyTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override

            public void handle(MouseEvent event) {
                System.out.println("A row was clicked");
                ModelTable selectedRow = (ModelTable) historyTable.getSelectionModel().getSelectedItem();
                if (selectedRow == null) {
                    System.out.println("null");
                } else {
                    int GID = selectedRow.getGameId();
                    System.out.println("id=" + GID);
                    GameSceneBase gameScene = new GameSceneBase();
                    Scene s = new Scene(gameScene);
                    EntryPoint.myStage.setScene(s);
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.err.println("from t");
                            fromHistoryFlage = true;
                            replay(gameScene, selectedRow);
                        }
                    });
                    t.start();

                }

            }

        });

    }

    private void replay(GameSceneBase gameScene, ModelTable selectedGame) {
        OutputStream outputStream = null;
        try {
            System.out.println("in replay id = " + selectedGame.getGameId());
            System.out.println("in replay");
//            Socket socket = new Socket("172.16.4.13", 6000);
            Socket socket = new Socket("127.0.0.1", 6000);
            System.out.println("Connected!");
            outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            System.out.println("Sending string to the ServerSocket");
            // write the message we want to send
            dataOutputStream.writeUTF(SignInSceneBase.p.name + "_" + selectedGame.getGameId() + "_GetMoves");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String message = dataInputStream.readUTF();
            System.out.println("The message sent from the socket was: " + message);
            dataOutputStream.flush(); // send the message
            dataOutputStream.close(); // close the output stream when we're done.
            socket.close();
            List<String> moves = new ArrayList<String>();
            Collections.addAll(moves, message.split("_"));
            System.out.println(moves);

            System.out.println("moves size=" + moves.size());
            int x = 1;
            String player;
            int POS;
            int MoveNum;
            while (x < moves.size()) {
                String move = moves.get(x);
                List<String> MData = new ArrayList<String>();
                Collections.addAll(MData, move.split(","));
                System.out.println("MDATA GAME ID = " + MData.get(0));
                System.out.println("MDATA MOVENUM= " + MData.get(1));
                System.out.println("MDATA POS = " + MData.get(2));
                System.out.println("MDATA PLAYER = " + MData.get(3));

                MoveNum = Integer.valueOf(MData.get(1));
                POS = Integer.valueOf(MData.get(2));
                player = MData.get(3);

                x++;

                String symb;
                if (player.equalsIgnoreCase(selectedGame.getPlayer1())) {
                    symb = "X";
                } else {
                    symb = "O";
                }
                System.out.println(symb);
                switch (POS) {
                    case (0):
                        Platform.runLater(() -> gameScene.btn0.setText(symb));
                        ;
                        System.out.println(1);
                        break;
                    case (1):
                        Platform.runLater(() -> gameScene.btn1.setText(symb));
                        System.out.println(2);
                        break;
                    case (2):

                        Platform.runLater(() -> gameScene.btn2.setText(symb));
                        System.out.println(3);
                        break;
                    case (3):
//                             button2.setText(symb);
                        Platform.runLater(() -> gameScene.btn3.setText(symb));
                        System.out.println(4);
                        break;
                    case (4):
//                             button2.setText(symb);
                        Platform.runLater(() -> gameScene.btn4.setText(symb));
                        System.out.println(5);
                        break;
                    case (5):
//                             button2.setText(symb);
                        Platform.runLater(() -> gameScene.btn5.setText(symb));
                        System.out.println(6);
                        break;
                    case (6):
                        Platform.runLater(() -> gameScene.btn6.setText(symb));
                        System.out.println(7);
                        break;
                    case (7):
                        Platform.runLater(() -> gameScene.btn7.setText(symb));
                        System.out.println("dym is >> " + symb);
                        System.out.println(8);
                        break;
                    case (8):
                        Platform.runLater(() -> gameScene.btn8.setText(symb));
                        System.out.println(9);
                        break;
                }
                TimeUnit.SECONDS.sleep(2);

            }
            Platform.runLater(() -> gameScene.statusLable.setText("Show ended"));

            ;
        } catch (IOException ex) {
            Logger.getLogger(HistorySceneBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(HistorySceneBase.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(HistorySceneBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    protected void muteSound(javafx.scene.input.MouseEvent mouseEvent) {
        soundIcon.setImage(new Image(getClass().getResource("../img/sound/sound_off.png").toExternalForm()));

    }

    protected void loadHomeScene(javafx.scene.input.MouseEvent mouseEvent) {
        MenuSceneBase ms = new MenuSceneBase();
        Scene scene = logo.getScene();
        BorderPane p = (BorderPane) scene.getRoot();
        p.setCenter(ms.containerPane);

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

    private void loadData() {
        try {
            ObservableList<Models.ModelTable> oblist = 
                    FXCollections.observableArrayList();
            oblist.removeAll(oblist);
            historyTable.getItems().clear();
            System.out.println("oblist" + oblist);
            System.out.println("loadData");
            Socket socket = new Socket("127.0.0.1", 6000);
            System.out.println("Connected!");
            OutputStream outputStream = null;
            outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            System.out.println("Sending string to the ServerSocket");
            // write the message we want to send
            dataOutputStream.writeUTF(SignInSceneBase.p.name + "_" + "paas" + "_GETGames");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            
            String message = dataInputStream.readUTF();
            
            System.out.println("The message sent from the socket was: " + message);
            dataOutputStream.flush(); // send the message
            dataOutputStream.close();
            List<String> Data = new ArrayList<>();
            
            Collections.addAll(Data, message.split("_"));
            
            System.out.println("<<--list of data is -->>"+Data);
            System.out.println("pname=" + p.name);
            int x = 1;
//            while (x < Data.size()) {
//                System.out.println("size data is >> "+ Data.size());
//                String game = Data.get(x);
//                List<String> GData = new ArrayList<>();
//                Collections.addAll(GData, game.split(","));
//                System.out.println("GDATA ID = " + GData.get(0));
//                System.out.println("GDATA p1 = " + GData.get(1));
//                System.out.println("GDATA p2 = " + GData.get(2));
//                System.out.println("GDATA winner = " + GData.get(3));
//                p.Games.add(game);
//                x++;
//
////  System.out.println("gameId" + GID);
//            }
            System.out.println("....................");
            int sizeGames = (SignInSceneBase.p.Games).size();
                for (int i = 0; i < sizeGames; i++) {
                System.err.println("size is >> " + sizeGames);
                List<String> GData = new ArrayList<>();
                Collections.addAll(GData, (SignInSceneBase.p.Games).get(i).split(","));
                System.out.println("GDATA ID = " + GData.get(0));
                System.out.println("GDATA p1 = " + GData.get(1));
                System.out.println("GDATA p2 = " + GData.get(2));
                System.out.println("GDATA winner = " + GData.get(3));
                oblist.add(new ModelTable(Integer.valueOf(GData.get(0)),
                        GData.get(1), GData.get(2), GData.get(3)));

            }

            game_id_col.setCellValueFactory(new PropertyValueFactory<>("GameId"));
            player_1_col.setCellValueFactory(new PropertyValueFactory<>("Player1"));

            player_2_col.setCellValueFactory(new PropertyValueFactory<>("Player2"));

            winnerCol.setCellValueFactory(new PropertyValueFactory<>("Winner"));
            historyTable.setItems(oblist);
        } catch (IOException ex) {
            Logger.getLogger(HistorySceneBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
