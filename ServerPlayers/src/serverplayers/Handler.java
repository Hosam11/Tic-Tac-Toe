package serverplayers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handler extends Thread {

    Socket socket;
    NewServer nServer;
    int curPlayer; // 1 for X --  for O
    //int nextPlayer = 0;
    DataInputStream dis;
    PrintStream ps;
    static boolean isPlayersCons = false;
    // store 2 sockets
    static List<Handler> conList = new ArrayList<>();

    static List<Handler> unWantedPlayer = new ArrayList<>();

    //  counter for players
    static int counPlyer = 0;

    static int lastPlayerTurn = 0;
    int playerComing;
    //name_turn_move_win_draw
    static String vaildTurn = "t";
    static String validMove = "t";
    static boolean gamePrepared = false;
    static String isPlayerWin = "f";
    static String isNoPlayerWin = "f";
    // just test
    String pN1;
    String pN2;
    String[] names = new String[2];
    static long GID;

    // Strings for locations if X or O
    // countForMove, btn + "_" + pId
    static List<String> finalBoardXO = new ArrayList<>();
    // to tack every move on board
    static int[] boardXO = new int[9];
    // when become  9 >> draw
    static int countForMove = 0;

    static List<String> replaysForCloseWindow = new ArrayList<>();
    static boolean IsGameEnd = false;
    // who winners
    static int winner = 0;
    // counter diplayed in ui 
    static int sCountForWinP1 = 0;
    static int sCountForWinP2 = 0;
    static int sCountForDraw = 0;

    boolean flagReadingServer = true;
    static boolean p1Left = false;
    static boolean fp2Left = false;

    static boolean takeNames = false;

    static ArrayList<String> playerNames = new ArrayList<>();

    static boolean p1Connected = false;
    static boolean p2Connected = false;

    public Handler(Socket c, NewServer newServer, String sName) {

        System.err.println("### from cons ###");
        System.err.println("count p1 is ?   " + sCountForWinP1
                + "  -* count p2 ??  " + sCountForWinP2
                + "  -* count darw ??  " + sCountForDraw);
        socket = c;
        nServer = newServer;
        for (Handler sHandler : conList) {
            System.err.println("@@@sHandler is  is >> " + sHandler);
        }
        try {
            System.out.println("from try cons Handler");
            dis = new DataInputStream(c.getInputStream());
            ps = new PrintStream(c.getOutputStream());
            if (conList.isEmpty()) {
                System.out.println("isEmpty ##cons## server");
                conList.add(0, this);
                counPlyer++;
                names[0] = sName;
                gamePrepared = true;
                System.out.println("f name is >> " + names[0]);
                curPlayer = 1; // for X
            } else if (conList.size() == 1) {  // size become 2
                System.out.println("from is size()==1 server");
                conList.add(1, this);
                counPlyer++;
                names[1] = sName;
                gamePrepared = true;
                //isGameActive = true;
                System.out.println("f name is >> " + names[1]);

                curPlayer = 2; // for O
            } else {
                counPlyer++;
                unWantedPlayer.add(0, this);
                System.out.println("that is unwanted player");
            }
            start();
        } catch (IOException ex) {
            System.out.println("1- from catch handler");
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("countPlayer is >> " + counPlyer);

    }

    @Override
    public void run() {
        while (flagReadingServer) {
            for (int i : boardXO) {
                System.out.print(i + " - ");
            }
            System.err.println("p1Con is >> " + p1Connected
                    + " -- p2Con is >> " + p2Connected);
            // send id of two curPlayer to them to make a different between them

            if (gamePrepared) { // 
                // send with playerid a vlaue reperesent 2 player or one
                // p1Connected if false means server did not send pIds yet2
                if (curPlayer == 1 && !p1Connected) {
                    System.out.println(" counPlyer is 1");
                    ps.println(curPlayer);
                    System.out.println("server send no 1 to p1");
                    //ps.println("ali");
                } else if (curPlayer == 2 && !p2Connected) {
                    System.out.println(" counPlyer is 2");
                    ps.println(curPlayer);
                    // 12 mean 2 player connected -- 
                    //send to p1 to change state text from wait to connected 
                    conList.get(0).ps.println("12");
                    System.out.println("size of names is  >> " + playerNames.size());
                    playerNames.forEach((name) -> {
                        //System.out.println("name is >> "+ name);
                    });
                    /*
                    conList.forEach((sHandler) -> {
                        // send array of names to each player so can update their ui                        
                        sHandler.ps.println(playerNames);
                    });
                     */
                    //counPlyer = 0;
                    //when 2 player connect and each player take own id 
                    // so i don't need to enter that ps again after init the game
                    gamePrepared = false;
                    //ps.println("hossam");
                }
                System.out.println("in game prepared");
            }
            System.out.println("gamePrepared >> " + gamePrepared);
            if (counPlyer == 3 && !gamePrepared && !unWantedPlayer.isEmpty()) {
                System.out.println("send to client unwanted");
                unWantedPlayer.get(0).ps.println("unwanted");
                curPlayer--;
                unWantedPlayer.clear();
            }
            System.out.println("after if game prepared");
            // code did not reach here until

            System.err.println("count p1 is ?   " + sCountForWinP1
                    + "  -* count p2 ??  " + sCountForWinP2
                    + "  -* count darw ??  " + sCountForDraw);
            afterTwoPlayerConntected();
        }
    }

    /**
     * read data from 1 player at a time check if game not ended yet check for
     * valid turn and valid move if game end call the right method to handle it
     */
    private void afterTwoPlayerConntected() {
        String dataReadedFromPlayer = null;
        try {
            System.out.println("from try of afterTwoPlayerConntected");
            // read data sended from players object - btn clicked
            // just reading
            // --MAIN-- reading from players
            dataReadedFromPlayer = dis.readLine();
            System.out.println("PLAYER ReplayStr is >> " + dataReadedFromPlayer);
        } catch (IOException ex) {
            System.out.println("2- from readline handler");
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        // recived players names >>dataReadedFromPlayer<< received meaningless i just need lenght
        if (dataReadedFromPlayer.length() == 13) {
            System.out.println("is >> " + dataReadedFromPlayer);
            try {
                String pName = dis.readLine();
                playerNames.add(pName);
                if (playerNames.size() == 1) {
                    p1Connected = true;
                } else if (playerNames.size() == 2) {
                    p2Connected = true;
                    DBConnection.AddGame(playerNames.get(0), playerNames.get(1));
                    GID = (long) DBConnection.GetGID();
                    System.out.println("GID=" + GID);
                    System.out.println("names=" + playerNames.get(0));
                    System.out.println("names=" + playerNames.get(1));
                }
                System.out.println("n is >> " + pName);
            } catch (IOException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        else // goes home after endGame
        if (dataReadedFromPlayer.length() == 8) {
            resetGamePlayerLeft();
            resetGameEndGame();
            conList.clear();
        } // player hit home btn
        else if (dataReadedFromPlayer.length() == 9) {
            String playerThatGoHome = dataReadedFromPlayer.split("_")[0];
            System.out.println("!!!!!!!!!!!!!! From HomeBtn >> " + dataReadedFromPlayer);
            if (playerThatGoHome.equals("1")) {
                System.out.println("from player is 1");
                if (conList.size() == 2) {
                    conList.get(1).ps.println(playerThatGoHome + "_" + "3456789");
                }
            } else if (playerThatGoHome.equals("2")) {
                if (conList.size() == 2) {
                    conList.get(0).ps.println(playerThatGoHome + "_" + "3456789");
                }
            }
            resetGamePlayerLeft();
            resetGameEndGame();
            conList.clear();
        } // stat about close window clicked
        else if (dataReadedFromPlayer.length() == 6) {
            whenReciveStrOfClosedPlayer(dataReadedFromPlayer);
        } // count 2 means to player connected -- is game end false means player still playing 
        //        else if (counPlyer > 2 && !IsGameEnd) {
        // to ensure if one player dose nothing until 2 player connected
        else if (!gamePrepared && !IsGameEnd) {
            gameOperations(dataReadedFromPlayer);
        } // maybe MUST put a contition
        // the game has ended strat new operations 
        else if (dataReadedFromPlayer.length() == 3) {
            // handle data returend from dialoges of replaying
            afterGameFinishedPlayAgainOrNot(dataReadedFromPlayer);
        }
    }

    /**
     *
     * @param dReadedFromPlayer: str has send stat is >> 1_c_11 player_close //
     * _11 meaningless just with size 6 to different from other str stats
     */
    private void whenReciveStrOfClosedPlayer(String dReadedFromPlayer) {
        System.out.println("data sended from close " + dReadedFromPlayer);
        // player that close the window

        int player = Integer.parseInt(dReadedFromPlayer.split("_")[0]);
        try {
            dis.close();
            // disable while of reading 
            flagReadingServer = false;
            // 123456 meaningless just with size 6 to differnt from other str stats              
            if (player == 1) { // p1 close
                System.out.println("from close server p1");
                // send to second 
                // coz if p2 aleardy left i do not want to send anthing to it
                // only send to p1
                //  [conList.size() == 2] means the two player still exist
                if (!fp2Left && conList.size() == 2) { // def false
                    System.out.println("counp ^^ is " + counPlyer);
                    System.out.println("from close server  p1 %% p2 not left ");
                    conList.get(1).ps.println("123456");
                }
                // else {
                // reomve player 1 
                //there is no else coz i need to excute that code too
                conList.remove(0);
                p1Left = true;
                //  }                
            } else if (player == 2) { // p2 close
                System.out.println("from close server  p2");
                conList.get(0).ps.println("123456");
                // coz if the p1 already left so the index will be 0 not 1 
                if (p1Left) {
                    conList.remove(0);
                    fp2Left = true;
                    System.out.println("from insde flagP1Left in P2");
                    //  [conList.size() == 2] means the two player still exist
                } else if (!p1Left && conList.size() == 2) { // in case if p2 closed first 
                    conList.remove(1);
                    fp2Left = true;
                }
            }
            for (Handler sHandler : conList) {
                System.err.println("@@@cur is  is >> " + sHandler.curPlayer);
                System.out.println("flag p1Left is >> " + p1Left
                        + "flag p2Left is >> " + fp2Left);
            }
            // set values used after game finished to defults
            // means the  players left the game i want to rest those values to defult
            // to enable next player to manged correctly 
            if (conList.isEmpty()) {
                System.out.println("from is empty");
                resetGamePlayerLeft();
            }
            resetGameEndGame();
        } catch (IOException ex) {
            System.out.println("addCatch close dis");
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * do operations of game -- check valid turn and move -- calling the right
     * methods
     * @param dReadedFromPlayer : 0 1 2 3 4 5 CONTRACT STATMENT
     * name_btn_turn_move_win_draw
     */
    private void gameOperations(String dReadedFromPlayer) {
        String pId = dReadedFromPlayer.split("_")[0]; // player number
        int btn = Integer.parseInt(dReadedFromPlayer.split("_")[1]);
        String moveRecived = dReadedFromPlayer.split("_")[3];
        //String pTurn = dataReadedFromClient.split("_")[3];
        System.err.println("btn is ## " + btn);
        playerComing = Integer.parseInt(pId);
        boolean isVailedTurn = checkIsVaildTurn();
        //                     0   1   2    3   4    5
        //CONTRACT STATMENT name_btn_turn_move_win_draw
        System.out.println("&&&- Com str is ?? >> " + dReadedFromPlayer);
        System.out.println("turn before ifIsVaildTurn str is >> " + moveRecived);
        if (isVailedTurn == true) {
            System.out.println("@@Valid turn");
            boolean isVailedMove = checkIsVaildMove(btn, Integer.parseInt(pId));
            System.out.println("dSendFrom VaildTrue p is >> " + playerComing + "-btn is>>"
                    + "-va");
            if (isVailedMove == true) {
                afterItsVaildMove(btn);
            } else { // invaild move
                // if vaild move the lastPlayerTurn will changed to anthor player
                // and no longer can make a move so i will return it to same player
                // so can make anthor plays
                if (lastPlayerTurn == 1) {
                    lastPlayerTurn = 2;
                } else if (lastPlayerTurn == 2) {
                    lastPlayerTurn = 1;
                }
                //invaild move tell client to diplay dialog
                ps.println(playerComing + "_" + btn + "_" + vaildTurn + "_"
                        + validMove + "_" + isPlayerWin + "_" + isNoPlayerWin);
            }
        } else { // invalid turn
            System.out.println("@@invalid turn");
            ps.println(playerComing + "_" + btn + "_" + vaildTurn + "_"
                    + validMove + "_" + isPlayerWin + "_" + isNoPlayerWin);
            System.err.println("turn after evluate and send to player ");
        }
    }

    /**
     * check for winner then send to 2 players to tell then the results if there
     * is a winner increment right counter weather is p1 or p2 or draw then set
     * var >> gameEnd << to true and >> resetGame() << TODO Store in database
     * @param btn:
     */
    private void afterItsVaildMove(int btn) {
        System.out.println("@@Valid move");
        // Send to 2 player to update ui then
        for (Handler sHandler : conList) {
            // check for winners and set flages of win or draw
            isWinner();
            System.err.println("@@@playerComing is >> " + playerComing);
            sHandler.ps.println(playerComing + "_" + btn + "_" + vaildTurn + "_"
                    + validMove + "_" + isPlayerWin + "_" + isNoPlayerWin);

        }
        // if GAMEOVER so send game board to database
        if (isPlayerWin.equals("t") || isNoPlayerWin.equals("d")) {
            // save winner in own variable
            // last player plays that is the winner
            winner = playerComing;
            // see which winner to count the wins time
            if (isPlayerWin.equals("t") && winner == 1) {
                System.out.println("from countForWinP1");
                sCountForWinP1++;
            } else if (isPlayerWin.equals("t") && winner == 2) {
                System.out.println("from countForWinP2");
                sCountForWinP2++;
            } else {
                System.out.println("from countForDraw");
                sCountForDraw++;
            }
            // ####### Marwa #########
            // TODO >> DataBase >> send final draw to database -- and counters
              for (int i = 0; i < finalBoardXO.size(); i++) {
                System.out.println(finalBoardXO.get(i));
                String dr = finalBoardXO.get(i);
                String[] ss = new String[4];
                ss = dr.split("_");
                int pos = Integer.parseInt(ss[0]);
                int cplayer = Integer.parseInt(ss[1]);
                System.out.println("pos=" + ss[0]);
                if (Integer.parseInt(ss[1]) == 1) {
                
                }

                // System.out.println("player=" + p);
                System.out.println("GID in moves=" + GID);
                DBConnection.AddMove(GID, i + 1, pos, playerNames.get(cplayer - 1));
              }

            // That forloop Diplay content of final bored
            for (int i = 0; i < finalBoardXO.size(); i++) {
                System.err.println(finalBoardXO.get(i));
            }
            // game ended that must to be true to make code enter ther after gameEnded
          
            DBConnection.SetWinner(GID,playerNames.get(winner-1));
            IsGameEnd = true;
            resetGameEndGame();
            System.err.println("winner end of game");
        }
        
    }

    /**
     * see if the lastPlayerTurn is equals to the playerComing
     *
     * @return true and make vaildTurn="t" and that means if they not equals
     * valid turn
     */
    private boolean checkIsVaildTurn() {
        boolean vaild = false;
        // at first nP = 0 then will be false
        if (lastPlayerTurn != playerComing) { // dif players
            lastPlayerTurn = playerComing;
            vaildTurn = "t";
            vaild = true;
        } else {
            vaildTurn = "f";
            vaild = false;
        }
        return vaild;
    }

    /**
     * take a button and the player who plays and check the button clicked in
     * the board of game if the button if empty put plauerId on the board then
     * make the validMove="t" of "f"
     *
     * @param btn : the button has clicked on
     * @param pId : the player who plays
     * @return ture if the mark on the empty place
     */
    private boolean checkIsVaildMove(int btn, int pId) {
        boolean vaild = false;
        if (boardXO[btn] == 0) { // vaild move
            boardXO[btn] = pId;
            validMove = "t";
            vaild = true;
            // 0_7_2
            finalBoardXO.add(countForMove, btn + "_" + pId);
            System.out.println("@#@# move ->> " + countForMove + " <<- is >> "
                    + finalBoardXO.get(countForMove));
            countForMove++;
        } else {
            validMove = "f";
            vaild = false;
        }
        return vaild;
    }

    /**
     * see if there is a matched 3 values in array updates flags to be f or t or
     * d
     */
    private void isWinner() {
        boolean isWin = false;
        // 1 row
        if (boardXO[0] == boardXO[1] && boardXO[1] == boardXO[2] && boardXO[0] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 2 row
        else if (boardXO[3] == boardXO[4] && boardXO[4] == boardXO[5] && boardXO[3] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 3 row 
        else if (boardXO[6] == boardXO[7] && boardXO[7] == boardXO[8] && boardXO[6] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 1 col
        else if (boardXO[0] == boardXO[3] && boardXO[3] == boardXO[6] && boardXO[0] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 2 col
        else if (boardXO[1] == boardXO[4] && boardXO[4] == boardXO[7] && boardXO[1] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 3 col
        else if (boardXO[2] == boardXO[5] && boardXO[5] == boardXO[8] && boardXO[2] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 0 interaction
        else if (boardXO[0] == boardXO[4] && boardXO[4] == boardXO[8] && boardXO[0] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } // 2 interaction
        else if (boardXO[2] == boardXO[4] && boardXO[4] == boardXO[6] && boardXO[2] != 0) {
            isWin = true;
            isPlayerWin = "t";
        } else if (countForMove == 9) {
            isNoPlayerWin = "d";
            isWin = false;
        }
        System.err.println("isWin is >  " + isWin);
        // return isWin;
    }

    /**
     * reset all variable when the game finished to make another game start
     * correctly
     */
    private void resetGameEndGame() {
        System.out.println("count p1 is ? " + sCountForWinP1
                + "-* count p2 ?? " + sCountForWinP2
                + "-* count darw ?? " + sCountForDraw);
        //boardXO = 0;
        Arrays.fill(boardXO, 0); // to start store anther game board
        lastPlayerTurn = 0; // to frest start to checking for vaild turn
        winner = 0;
        countForMove = 0;
        isPlayerWin = "f";
        isNoPlayerWin = "f";
        finalBoardXO.clear();
        vaildTurn = "t";
        validMove = "t";
        //counPlyer = 0; // make a problem
    }

    /**
     * reset variables when player close the window or go to home
     */
    private void resetGamePlayerLeft() {
        p1Left = false;
        fp2Left = false;
        counPlyer = 0;
        sCountForWinP1 = 0;
        sCountForWinP2 = 0;
        sCountForDraw = 0;
        p1Connected = false;
        p2Connected = false;
        playerNames.clear();
    }

    /**
     * read data from 2 players store it in array >> (replaysForCloseWindow) of
     * 2 element and once the array is full check send to each player the whole
     * response and player handle from there *--* then clear
     * replaysForCloseWindow to take anthor response an set IsGameEnd to false
     *
     * @param dReadedFromClient : data like << pID_YorN >> [0] = 1_t <##> [1] =
     * 2_f
     */
    private void afterGameFinishedPlayAgainOrNot(String dReadedFromClient) {
        // after game ended
        System.err.println("from playAginOrNot&& " + dReadedFromClient);
        replaysForCloseWindow.add(dReadedFromClient);
        // that means 2 player chose their response
        if (replaysForCloseWindow.size() == 2) {
            System.out.println("from if YorN");
            for (Handler sHandler : conList) {
                // p1_t_p2_f lnegt = 7
                System.out.println("after concat str >> "
                        + replaysForCloseWindow.get(0) + "_" + replaysForCloseWindow.get(1));
                sHandler.ps.println(replaysForCloseWindow.get(0) + "_" + replaysForCloseWindow.get(1));
                // send who wins to each player
                //sHandler.ps.println(winner);
                sHandler.ps.println(sCountForWinP1 + "_" + sCountForWinP2
                        + "_" + sCountForDraw);
            }
            replaysForCloseWindow.clear();
            // must be here to make it enter the right read Contition
            IsGameEnd = false;
        }
    }

}
