package TicTacToc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marwazabara
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static String username = "root";
    public static String password = "root";

    public DBConnection() {

//        ArrayList<String> moves = new ArrayList<String>();
//        moves.add("2_1");
//        moves.add("4_2");
//        moves.add("1_1");
//        moves.add("5_2");
//        moves.add("3_1");
//        moves.add("7_2");
//        moves.add("9_1");
//        moves.add("8_2");
//        moves.add("6_1");
//
//        System.out.println(moves);
//try{
//	DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
//	Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/XO","marwazabara","tvbd824%");
//	Statement stmt = con.createStatement();
//	String queryString = new String("select * from tst");
//	ResultSet rs = stmt.executeQuery(queryString);
//	while(rs.next()){
//		System.out.println(rs.getString(1));
//	}
//	stmt.close();
//	con.close();
//
//}
//catch(SQLException ex){
//	ex.printStackTrace();
//}
    }

//Players
    public static boolean AddPlayer(String Pname) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            //Connection con = DriverManager.getConnection

            Statement stmt = con.createStatement();
            String queryString = new String("insert into Players (Pname) values('" + Pname + "')");
            int rs = stmt.executeUpdate(queryString);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static int Signin(String Pname, String psswd) {
        try {
            if (Pname != "" && psswd != "") {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
                Statement stmt = con.createStatement();
                String queryString = new String("Select * FROM Players WHERE Pname='" + Pname + "'");
                ResultSet rs = stmt.executeQuery(queryString);
                if (rs.next()) {
                    if (psswd.equalsIgnoreCase(rs.getString("password"))) {
                        System.out.println("ok found");
                        stmt.close();
                        con.close();
                        return 1;
                    }
                } else {
                    System.out.println("not found");
                    stmt.close();
                    con.close();
                    return 0;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int Signup(String Pname, String psswd) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("Select * FROM Players WHERE Pname='" + Pname + "'");
            ResultSet rs = stmt.executeQuery(queryString);
            if (rs.next()) {
                System.out.println("This username already in use");
                stmt.close();
                con.close();
                return 0;
            } else {
                System.out.println("not found");
                String querySignup = new String("insert into Players (Pname,password) values('" + Pname + "','" + psswd + "')");
                int res = stmt.executeUpdate(querySignup);
                System.out.println("res="+res);
                stmt.close();
                con.close();
                return res;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public static boolean UpdateScore(String Pname, int Score) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("UPDATE Players SET Score =" + Score + " WHERE Pname='" + Pname + "'");
            int rs = stmt.executeUpdate(queryString);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static long GetScore(String Pname) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("Select Score FROM Players where Pname='" + Pname + "'");
            ResultSet rs = stmt.executeQuery(queryString);
            rs.next();
            long Score = rs.getLong(1);
            stmt.close();
            con.close();
            return Score;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

//Game
    public static boolean AddGame(String P1, String P2) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("insert into Games (player1,player2) values('" + P1 + "','" + P2 + "')");
            int rs = stmt.executeUpdate(queryString);
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }

    public static boolean SetWinner(long GameID, String Winner) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("UPDATE Games SET winner ='" + Winner + "' WHERE GID='" + GameID + "'");
            int rs = stmt.executeUpdate(queryString);
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static long GetGID() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("SELECT GID FROM Games ORDER BY GID Desc Limit 1");
            ResultSet rs = stmt.executeQuery(queryString);
            rs.next();
            long GID = rs.getLong(1);
            stmt.close();
            con.close();
            return GID;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

//Moves
    public static boolean AddMove(long GID, int MoveNum, int POS, String Player) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("insert into Moves (GID,MoveNum,POS,Player) values(" + GID + "," + MoveNum + "," + POS + "," + "'" + Player + "')");
            int rs = stmt.executeUpdate(queryString);
            stmt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public static ResultSet GetMoves(long GID) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("select * from Moves where GID=" + GID);
            ResultSet rs = stmt.executeQuery(queryString);
//            stmt.close();
//            con.close();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ResultSet GetPlayedGames(String Pname) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/XO", username, password);
            Statement stmt = con.createStatement();
            String queryString = new String("Select * FROM Games where player1 = '" + Pname + "'OR player2='" + Pname + "'");
            ResultSet rs = stmt.executeQuery(queryString);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

//try{
//	DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
//	Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/XO","marwazabara","tvbd824%");
//	Statement stmt = con.createStatement();
//	String queryString = new String("select * from tst");
//	ResultSet rs = stmt.executeQuery(queryString);
//	while(rs.next()){
//		System.out.println(rs.getString(1));
//	}
//	stmt.close();
//	con.close();
//
//}
//catch(SQLException ex){
//	ex.printStackTrace();
//}
}
