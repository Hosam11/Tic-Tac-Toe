/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Conf extends Application {

    DataInputStream dis;
    ServerSceneBase serverSceneBase = new ServerSceneBase();

    public Conf() {
        ServerThreadDB serverThread = new ServerThreadDB();
        Thread thread = new Thread(serverThread);
        thread.start();

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = serverSceneBase;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class ServerThreadDB implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    serverSceneBase.textArea.appendText("DataBase Server running...\n");

                    int check;
                    String send;
                    System.err.println("from conf in while");
                    ServerSocket ss = new ServerSocket(6000);
                    Socket socket = ss.accept();
                    System.out.println("Connection from " + socket + "!");
                    InputStream inputStream = socket.getInputStream();
//              Socket soc = new Socket("localhost", 6000);
                    System.out.println("Connected!");
                    serverSceneBase.textArea.appendText("player connected...\n");

                    // get the output stream from the socket.
                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    String message = dataInputStream.readUTF();
                    System.out.println("The message sent from the socket was: " + message);
                    String[] input = new String[3];
                    input = message.split("_");
                    String uname = input[0];
                    System.out.println("name=" + uname);
                    String pass = input[1];
                    System.out.println("pass=" + pass);
                    String type = input[2];
                    System.out.println("type = " + type);
                    System.out.println("type=" + type);

                    if (type.equalsIgnoreCase("IN")) {

                        if (!uname.isEmpty() && !pass.isEmpty()) {
                            check = DBConnection.Signin(uname, pass);
                            if (check == 1) {
                                //send data
                                String score = Long.toString(DBConnection.GetScore(uname));
                                send = uname + "_" + score;
                                ResultSet rs = DBConnection.GetPlayedGames(uname);
                                while (rs.next()) {
                                    // String GID = Long.toString(rs.getLong("GID"));
                                    //System.out.println("GID=" + GID);
                                    send = send.concat("_" + rs.getLong("GID") + "," + rs.getString("player1") + "," + rs.getString("player2") + "," + rs.getString("winner"));

                                }
                                System.out.println("send at the end=" + send);
                                // send data as name_score_gameId_gameId_....
                                dataOutputStream.writeUTF(send);

                            } else {
                                dataOutputStream.writeUTF("NOT FOUND");
                            }
                        } else {
                            dataOutputStream.writeUTF("NO ENTRY");
                        }
                    } else if (type.equalsIgnoreCase("UP")) {
                        if (!uname.isEmpty() && !pass.isEmpty()) {
                            check = DBConnection.Signup(uname, pass);
                            if (check == 1) {
                                dataOutputStream.writeUTF(uname);
                            } else {
                                dataOutputStream.writeUTF("ALREADY EXISTS");

                            }

                        } else {
                            dataOutputStream.writeUTF("NO ENTRY");

                        }
                    } // uname_GID_GETMOVES
                    //pass = GID
                    else if (type.equalsIgnoreCase("GetMoves")) {
                        long GID = Long.valueOf(pass);
                        send = Long.toString(GID);
                        ResultSet rs = DBConnection.GetMoves(GID);
                        while (rs.next()) {

                            send = send.concat("_" + rs.getLong("GID") + "," + rs.getString("MoveNum") + "," + rs.getString("POS") + "," + rs.getString("Player"));

                        }
                        System.out.println("send at the end=" + send);
                        // send data as GID_move1_move2_...
                        dataOutputStream.writeUTF(send);

                    } else if (type.equalsIgnoreCase("GETGames")) {
                        System.out.println("IN GET GAMES");
                        //long GID = Long.valueOf(pass);
                        send = uname;
                        ResultSet rs = DBConnection.GetPlayedGames(uname);
                        while (rs.next()) {
                            send = send.concat("_" + 
                                    rs.getLong("GID") + "," +
                                    rs.getString("player1") + "," + 
                                    rs.getString("player2") + "," +
                                    rs.getString("winner"));
                        }
                        System.out.println("send at the end=" + send);
                        // send data as GID_move1_move2_...
                        System.err.println("ret fro server is >> + " + send);
                        dataOutputStream.writeUTF(send);
                    }
                    ss.close();
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Conf.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Conf.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    @Override
    public void stop() throws Exception {
        serverSceneBase.textArea.appendText("server shutdown...");
        System.exit(0);
    }

}
