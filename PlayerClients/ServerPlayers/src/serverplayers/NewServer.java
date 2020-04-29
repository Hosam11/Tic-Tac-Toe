package serverplayers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HoSaM
 */
public class NewServer extends Application {

    ServerSocket mSSocket;
    //two connection
    List<Socket> socketList = new ArrayList<>();
    List<Handler> room = new ArrayList<>();

    int player; // 1 for X --  for O
    String s1 = "hossam";
    String s2 = "Ali";
    static boolean flagReadSocket = true;

    ServerSceneBase serverSceneBase = new ServerSceneBase();

    public NewServer() {

        ServerThread serverThread = new ServerThread();
        Thread thread = new Thread(serverThread);

        thread.start();

    }

    public static void main(String[] args) {
        System.out.println("This is NewServer");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = serverSceneBase;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        serverSceneBase.textArea.appendText("server shutdown...");
        System.exit(0);
    }

    class ServerThread implements Runnable {

        @Override
        public void run() {

            try {
                mSSocket = new ServerSocket(4949);
            } catch (IOException ex) {
                System.out.println("from catch serverSocket");
                Logger.getLogger(NewServer.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (true) {
                try {
                    System.err.println("@@@@from start while(true) NewServer");
                    serverSceneBase.textArea.appendText("Server is running...\n");

                    if (socketList.isEmpty()) {
                        socketList.add(0, mSSocket.accept());
                        System.out.println("player 1 connceted >> " + s1);
                        new Handler(socketList.get(0), NewServer.this, s1);
                        serverSceneBase.textArea.appendText("Player 1 Connected...\n");
                        //room.add(h1);
                    } else if (socketList.size() == 1) {
                        socketList.add(1, mSSocket.accept());
                        System.out.println("player 2 connceted >> " + s2);
                        new Handler(socketList.get(1), NewServer.this, s2);
                        serverSceneBase.textArea.appendText("Player 2 Connected...\n");
                        // room.add(h2);
                        socketList.clear();
                        System.err.println("socket cleared && len is >> " + socketList.size());
                        // Handler.conList.clear();
                    } else {
                        System.out.println("sorry server is busy");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(NewServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
